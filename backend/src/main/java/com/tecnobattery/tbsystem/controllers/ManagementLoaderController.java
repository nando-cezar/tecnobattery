package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.ManagementLoaderRequest;
import com.tecnobattery.tbsystem.dto.response.ManagementLoaderResponse;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.services.LoaderService;
import com.tecnobattery.tbsystem.services.ManagementLoaderService;
import com.tecnobattery.tbsystem.services.ProviderService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/managementLoaders")
public class ManagementLoaderController {

  @Autowired
  private ManagementLoaderService managementLoaderService;

  @Autowired
  private LoaderService batteryService;

  @Autowired
  private ProviderService providerService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ManagementLoaderResponse save(@Valid @RequestBody ManagementLoaderRequest managementLoaderInput) {

    ManagementLoader managementLoader = toolModelMapper.toModel(managementLoaderInput, ManagementLoader.class);
    managementLoader
        .setLoader(toolModelMapper.toModel(batteryService.findById(managementLoaderInput.getLoaderId()), Loader.class));
    managementLoader.setProvider(
        toolModelMapper.toModel(providerService.findById(managementLoaderInput.getProviderId()), Provider.class));
    managementLoader.setMoment(OffsetDateTime.now());

    return managementLoaderService.save(managementLoader);
  }

  @GetMapping
  public ResponseEntity<List<ManagementLoaderResponse>> findAll() {
    return ResponseEntity.ok().body(managementLoaderService.findAll());
  }

  @GetMapping("/{managementLoaderId}")
  public ResponseEntity<ManagementLoaderResponse> findById(@PathVariable Long managementLoaderId) {
    return ResponseEntity.ok(managementLoaderService.findById(managementLoaderId));
  }

  @PutMapping("/{managementLoaderId}")
  public ResponseEntity<ManagementLoaderResponse> update(@Valid @PathVariable Long managementLoaderId,
      @RequestBody ManagementLoaderRequest managementLoaderInput) {

    if (!managementLoaderService.existsById(managementLoaderId)) {
      return ResponseEntity.notFound().build();
    }

    ManagementLoader managementLoader = toolModelMapper.toModel(managementLoaderService.findById(managementLoaderId),
        ManagementLoader.class);
    managementLoader
        .setLoader(toolModelMapper.toModel(batteryService.findById(managementLoaderInput.getLoaderId()), Loader.class));
    managementLoader.setProvider(
        toolModelMapper.toModel(providerService.findById(managementLoaderInput.getProviderId()), Provider.class));
    managementLoader.setAmount(managementLoaderInput.getAmount());
    managementLoader.setId(managementLoaderId);

    return ResponseEntity.ok(managementLoaderService.save(managementLoader));
  }

  @DeleteMapping("/{managementLoaderId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long managementLoaderId) {
    if (!managementLoaderService.existsById(managementLoaderId)) {
      return ResponseEntity.notFound().build();
    }
    managementLoaderService.deleteById(managementLoaderId);
    return ResponseEntity.noContent().build();
  }
}
