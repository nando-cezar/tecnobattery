package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.output.ProviderOutput;
import com.tecnobattery.tbsystem.dto.input.ProviderInput;
import com.tecnobattery.tbsystem.services.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public ProviderOutput save(@RequestBody ProviderInput provider) {
    return providerService.save(provider.getCnpj(), provider.getName(), provider.getFantasyName(), provider.getPhone(),
        provider.getEmail(), provider.getPostalCode(), provider.getPublicPlace(), provider.getComplement(),
        provider.getNeighborhood(), provider.getCity(), provider.getState());
  }

  @GetMapping
  public ResponseEntity<List<ProviderOutput>> findAll() {
    List<ProviderOutput> list = providerService.findAll();
    return ResponseEntity.ok().body(list);
  }
}