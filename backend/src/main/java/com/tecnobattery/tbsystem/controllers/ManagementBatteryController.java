package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.input.ManagementBatteryInput;
import com.tecnobattery.tbsystem.dto.output.ManagementBatteryOutput;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.services.BatteryService;
import com.tecnobattery.tbsystem.services.ManagementBatteryService;
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
@RequestMapping(value = "/managementBatterys")
public class ManagementBatteryController {

  @Autowired
  private ManagementBatteryService managementBatteryService;

  @Autowired
  private BatteryService batteryService;

  @Autowired
  private ProviderService providerService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ManagementBatteryOutput save(@Valid @RequestBody ManagementBatteryInput managementBatteryInput) {

    ManagementBattery managementBattery = toolModelMapper.toModel(managementBatteryInput, ManagementBattery.class);
    managementBattery.setBattery(toolModelMapper.toModel(batteryService.findById(managementBatteryInput.getBatteryId()), Battery.class));
    managementBattery.setProvider(toolModelMapper.toModel(providerService.findById(managementBatteryInput.getProviderId()), Provider.class));
    managementBattery.setMoment(OffsetDateTime.now());

    return managementBatteryService.save(managementBattery);
  }

  @GetMapping
  public ResponseEntity<List<ManagementBatteryOutput>> findAll() {
    return ResponseEntity.ok().body(managementBatteryService.findAll());
  }

  @GetMapping("/{managementBatteryId}")
  public ResponseEntity<ManagementBatteryOutput> findById(@PathVariable Long managementBatteryId) {
    return ResponseEntity.ok(managementBatteryService.findById(managementBatteryId));
  }

  @PutMapping("/{managementBatteryId}")
  public ResponseEntity<ManagementBatteryOutput> update(@Valid @PathVariable Long managementBatteryId, @RequestBody ManagementBatteryInput managementBatteryInput) {

    if (!managementBatteryService.existsById(managementBatteryId)) {
      return ResponseEntity.notFound().build();
    }

    ManagementBattery managementBattery = toolModelMapper.toModel(managementBatteryService.findById(managementBatteryId), ManagementBattery.class);
    managementBattery.setBattery(toolModelMapper.toModel(batteryService.findById(managementBatteryInput.getBatteryId()), Battery.class));
    managementBattery.setProvider(toolModelMapper.toModel(providerService.findById(managementBatteryInput.getProviderId()), Provider.class));
    managementBattery.setAmount(managementBatteryInput.getAmount());
    managementBattery.setId(managementBatteryId);

    return ResponseEntity.ok(managementBatteryService.save(managementBattery));
  }

  @DeleteMapping("/{managementBatteryId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long managementBatteryId) {
    if (!managementBatteryService.existsById(managementBatteryId)) {
      return ResponseEntity.notFound().build();
    }
    managementBatteryService.deleteById(managementBatteryId);
    return ResponseEntity.noContent().build();
  }
}
