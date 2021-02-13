package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.ProviderDTO;
import com.tecnobattery.tbsystem.services.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/providers")
public class ProviderController {

  @Autowired
  private ProviderService providerService;

  @GetMapping
  public ResponseEntity<List<ProviderDTO>> findAll() {
    List<ProviderDTO> list = providerService.findAll();
    return ResponseEntity.ok().body(list);
  }
}