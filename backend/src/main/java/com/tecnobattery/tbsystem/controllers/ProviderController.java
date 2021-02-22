package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.ProviderOutput;
import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.dto.input.ProviderInput;
import com.tecnobattery.tbsystem.services.ProviderService;

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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ProviderOutput save(@Valid @RequestBody ProviderInput providerInput) {
    Provider provider = new Provider();
    Address address = new Address();
    provider.setCnpj(providerInput.getCnpj());
    provider.setName(providerInput.getName());
    provider.setFantasyName(providerInput.getFantasyName());
    provider.setPhone(providerInput.getPhone());
    provider.setEmail(providerInput.getEmail());
    address.setPostalCode(providerInput.getPostalCode());
    address.setPublicPlace(providerInput.getPublicPlace());
    address.setComplement(providerInput.getComplement());
    address.setNeighborhood(providerInput.getNeighborhood());
    address.setCity(providerInput.getCity());
    address.setState(providerInput.getState());
    provider.setAddress(address);
    return providerService.save(provider);
  }

  @GetMapping
  public ResponseEntity<List<ProviderOutput>> findAll() {
    List<ProviderOutput> list = providerService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{providerId}")
  public ResponseEntity<ProviderOutput> findById(@PathVariable Long providerId) {
    ProviderOutput provider = providerService.findById(providerId);
    if (provider != null) {
      return ResponseEntity.ok(provider);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{providerId}")
  public ResponseEntity<ProviderOutput> update(@Valid @PathVariable Long providerId,
      @RequestBody ProviderInput providerInput) {

    if (!providerService.existsById(providerId)) {
      return ResponseEntity.notFound().build();
    }

    Provider provider = new Provider();
    Address address = new Address();
    provider.setCnpj(providerInput.getCnpj());
    provider.setName(providerInput.getName());
    provider.setFantasyName(providerInput.getFantasyName());
    provider.setPhone(providerInput.getPhone());
    provider.setEmail(providerInput.getEmail());
    address.setPostalCode(providerInput.getPostalCode());
    address.setPublicPlace(providerInput.getPublicPlace());
    address.setComplement(providerInput.getComplement());
    address.setNeighborhood(providerInput.getNeighborhood());
    address.setCity(providerInput.getCity());
    address.setState(providerInput.getState());
    provider.setAddress(address);

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