package com.tecnobattery.tbsystem.controllers.management;

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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/management/api/v1/managementLoaders")
@AllArgsConstructor
public class RecordsLoaderManagementController {

  private final ManagementLoaderService managementLoaderService;
  private final LoaderService batteryService;
  private final ProviderService providerService;
  private final ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
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
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<ManagementLoaderResponse>> findAll() {
    return ResponseEntity.ok().body(managementLoaderService.findAll());
  }

  @GetMapping("/{managementLoaderId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<ManagementLoaderResponse> findById(@PathVariable Long managementLoaderId) {
    return ResponseEntity.ok(managementLoaderService.findById(managementLoaderId));
  }

  @PutMapping("/{managementLoaderId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<ManagementLoaderResponse> update(@PathVariable Long managementLoaderId,
      @Valid @RequestBody ManagementLoaderRequest managementLoaderInput) {

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
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long managementLoaderId) {
    if (!managementLoaderService.existsById(managementLoaderId)) {
      return ResponseEntity.notFound().build();
    }
    managementLoaderService.deleteById(managementLoaderId);
    return ResponseEntity.noContent().build();
  }
}
