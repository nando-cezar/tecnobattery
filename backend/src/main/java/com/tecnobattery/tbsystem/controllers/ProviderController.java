package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.ProviderOutput;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.dto.input.ProviderInput;
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
@RequestMapping(value = "/providers")
public class ProviderController {

  @Autowired
  private ProviderService providerService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProviderOutput save(@Valid @RequestBody ProviderInput providerInput) {
    return providerService.save(toolModelMapper.toModel(providerInput, Provider.class));
  }

  @GetMapping
  public ResponseEntity<List<ProviderOutput>> findAll() {
    List<ProviderOutput> list = providerService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{providerId}")
  public ResponseEntity<ProviderOutput> findById(@PathVariable Long providerId) {
    return ResponseEntity.ok(providerService.findById(providerId));
  }

  @PutMapping("/{providerId}")
  public ResponseEntity<ProviderOutput> update(@Valid @PathVariable Long providerId,
      @RequestBody ProviderInput providerInput) {

    if (!providerService.existsById(providerId)) {
      return ResponseEntity.notFound().build();
    }

    Provider provider = new Provider();
    provider = toolModelMapper.toModel(providerInput, Provider.class);
    provider.setId(providerId);
    return ResponseEntity.ok(providerService.save(provider));
  }

  @DeleteMapping("/{providerId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long providerId) {
    if (!providerService.existsById(providerId)) {
      return ResponseEntity.notFound().build();
    }
    providerService.deleteById(providerId);
    return ResponseEntity.noContent().build();
  }
}