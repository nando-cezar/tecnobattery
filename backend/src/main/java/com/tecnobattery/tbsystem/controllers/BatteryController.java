package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.BatteryDTO;
import com.tecnobattery.tbsystem.dto.input.BatteryInput;
import com.tecnobattery.tbsystem.services.BatteryService;

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
@RequestMapping(value = "/batterys")
public class BatteryController {

  @Autowired
  private BatteryService batteryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BatteryDTO save(@RequestBody BatteryInput battery) {
    return batteryService.save(battery.getBrand(), battery.getModel(), battery.getCapacity(), battery.getVoltage(),
        battery.getDiameter(), battery.getHeight(), battery.getImageUrl());
  }

  @GetMapping
  public ResponseEntity<List<BatteryDTO>> findAll() {
    List<BatteryDTO> list = batteryService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
