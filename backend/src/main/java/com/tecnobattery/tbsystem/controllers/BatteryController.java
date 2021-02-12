package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.BatteryDTO;
import com.tecnobattery.tbsystem.services.BatteryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/batterys")
public class BatteryController {

  @Autowired
  private BatteryService batteryService;

  @GetMapping
  public ResponseEntity<List<BatteryDTO>> findAll() {
    List<BatteryDTO> list = batteryService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
