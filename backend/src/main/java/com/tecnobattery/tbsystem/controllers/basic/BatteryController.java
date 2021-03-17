package com.tecnobattery.tbsystem.controllers.basic;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/batterys")
public class BatteryController {

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
}
