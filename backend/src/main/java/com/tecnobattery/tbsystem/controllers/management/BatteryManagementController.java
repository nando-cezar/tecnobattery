package com.tecnobattery.tbsystem.controllers.management;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.BatteryRequest;
import com.tecnobattery.tbsystem.dto.response.BatteryResponse;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.services.BatteryService;
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
@RequestMapping(value = "management/api/v1/batterys")
public class BatteryManagementController {

  @Autowired
  private BatteryService batteryService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BatteryResponse save(@Valid @RequestBody BatteryRequest batteryInput) {
    return batteryService.save(toolModelMapper.toModel(batteryInput, Battery.class), false);
  }

  @GetMapping
  public ResponseEntity<List<BatteryResponse>> findAll() {
    return ResponseEntity.ok().body(batteryService.findAll());
  }

  @GetMapping("/{batteryId}")
  public ResponseEntity<BatteryResponse> findById(@PathVariable Long batteryId) {
    return ResponseEntity.ok(batteryService.findById(batteryId));
  }

  @PutMapping("/{batteryId}")
  public ResponseEntity<BatteryResponse> update(@Valid @PathVariable Long batteryId,
      @RequestBody BatteryRequest batteryInput) {

    if (!batteryService.existsById(batteryId)) {
      return ResponseEntity.notFound().build();
    }

    Battery battery = new Battery();
    battery = toolModelMapper.toModel(batteryInput, Battery.class);
    battery.setId(batteryId);

    return ResponseEntity.ok(batteryService.save(battery, true));
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
