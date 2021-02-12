package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.ManagementBatteryDTO;
import com.tecnobattery.tbsystem.services.ManagementBatteryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/managementBatterys")
public class ManagementBatteryController {

  @Autowired
  private ManagementBatteryService clientService;

  @GetMapping
  public ResponseEntity<List<ManagementBatteryDTO>> findAll() {
    List<ManagementBatteryDTO> list = clientService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
