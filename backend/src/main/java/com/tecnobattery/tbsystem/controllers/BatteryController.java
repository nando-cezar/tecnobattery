package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.BatteryOutput;
import com.tecnobattery.tbsystem.dto.input.BatteryInput;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.services.BatteryService;

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
@RequestMapping(value = "/batterys")
public class BatteryController {

  @Autowired
  private BatteryService batteryService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BatteryOutput save(@Valid @RequestBody BatteryInput batteryInput) {
    Battery battery = new Battery();
    battery.setBrand(batteryInput.getBrand());
    battery.setModel(batteryInput.getModel());
    battery.setCapacity(batteryInput.getCapacity());
    battery.setVoltage(batteryInput.getVoltage());
    battery.setDiameter(batteryInput.getDiameter());
    battery.setHeight(batteryInput.getHeight());
    battery.setImageUrl(batteryInput.getImageUrl());
    return batteryService.save(battery);
  }

  @GetMapping
  public ResponseEntity<List<BatteryOutput>> findAll() {
    List<BatteryOutput> list = batteryService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{batteryId}")
  public ResponseEntity<BatteryOutput> findById(@PathVariable Long batteryId) {
    BatteryOutput battery = batteryService.findById(batteryId);
    if (battery != null) {
      return ResponseEntity.ok(battery);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{batteryId}")
  public ResponseEntity<BatteryOutput> update(@Valid @PathVariable Long batteryId,
      @RequestBody BatteryInput batteryInput) {

    if (!batteryService.existsById(batteryId)) {
      return ResponseEntity.notFound().build();
    }

    Battery battery = new Battery();
    battery.setId(batteryId);
    battery.setBrand(batteryInput.getBrand());
    battery.setModel(batteryInput.getModel());
    battery.setCapacity(batteryInput.getCapacity());
    battery.setVoltage(batteryInput.getVoltage());
    battery.setDiameter(batteryInput.getDiameter());
    battery.setHeight(batteryInput.getHeight());
    battery.setImageUrl(batteryInput.getImageUrl());

    return ResponseEntity.ok(batteryService.save(battery));
  }

  @DeleteMapping("/{batteryId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long batteryId) {
    if (!batteryService.existsById(batteryId)) {
      return ResponseEntity.notFound().build();
    }
    batteryService.deleteById(batteryId);
    return ResponseEntity.noContent().build();
  }
}
