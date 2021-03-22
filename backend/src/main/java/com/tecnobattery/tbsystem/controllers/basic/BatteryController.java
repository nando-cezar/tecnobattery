package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.BatteryResponse;
import com.tecnobattery.tbsystem.services.BatteryService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/batterys")
@AllArgsConstructor
public class BatteryController {

  private final BatteryService batteryService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<BatteryResponse>> findAll() {
    return ResponseEntity.ok().body(batteryService.findAll());
  }

  @GetMapping("/{batteryId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<BatteryResponse> findById(@PathVariable Long batteryId) {
    return ResponseEntity.ok(batteryService.findById(batteryId));
  }
}
