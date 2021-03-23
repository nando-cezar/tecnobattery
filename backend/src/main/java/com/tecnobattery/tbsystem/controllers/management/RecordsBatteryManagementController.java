package com.tecnobattery.tbsystem.controllers.management;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.ManagementBatteryRequest;
import com.tecnobattery.tbsystem.dto.response.ManagementBatteryResponse;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.services.BatteryService;
import com.tecnobattery.tbsystem.services.ManagementBatteryService;
import com.tecnobattery.tbsystem.services.ProviderService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/management/api/v1/managementBatterys")
@AllArgsConstructor
public class RecordsBatteryManagementController {

  private final ManagementBatteryService managementBatteryService;
  private final BatteryService batteryService;
  private final ProviderService providerService;
  private final ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  @ResponseStatus(HttpStatus.CREATED)
  public ManagementBatteryResponse save(@Valid @RequestBody ManagementBatteryRequest managementBatteryInput) {

    ManagementBattery managementBattery = toolModelMapper.toModel(managementBatteryInput, ManagementBattery.class);
    managementBattery.setBattery(
        toolModelMapper.toModel(batteryService.findById(managementBatteryInput.getBatteryId()), Battery.class));
    managementBattery.setProvider(
        toolModelMapper.toModel(providerService.findById(managementBatteryInput.getProviderId()), Provider.class));
    managementBattery.setMoment(OffsetDateTime.now());

    return managementBatteryService.save(managementBattery);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<ManagementBatteryResponse>> findAll() {
    return ResponseEntity.ok().body(managementBatteryService.findAll());
  }

  @GetMapping("/{managementBatteryId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<ManagementBatteryResponse> findById(@PathVariable Long managementBatteryId) {
    return ResponseEntity.ok(managementBatteryService.findById(managementBatteryId));
  }

  @PutMapping("/{managementBatteryId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<ManagementBatteryResponse> update(@PathVariable Long managementBatteryId,
      @Valid @RequestBody ManagementBatteryRequest managementBatteryInput) {

    if (!managementBatteryService.existsById(managementBatteryId)) {
      return ResponseEntity.notFound().build();
    }

    ManagementBattery managementBattery = toolModelMapper
        .toModel(managementBatteryService.findById(managementBatteryId), ManagementBattery.class);
    managementBattery.setBattery(
        toolModelMapper.toModel(batteryService.findById(managementBatteryInput.getBatteryId()), Battery.class));
    managementBattery.setProvider(
        toolModelMapper.toModel(providerService.findById(managementBatteryInput.getProviderId()), Provider.class));
    managementBattery.setAmount(managementBatteryInput.getAmount());
    managementBattery.setId(managementBatteryId);

    return ResponseEntity.ok(managementBatteryService.save(managementBattery));
  }

  @DeleteMapping("/{managementBatteryId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long managementBatteryId) {
    if (!managementBatteryService.existsById(managementBatteryId)) {
      return ResponseEntity.notFound().build();
    }
    managementBatteryService.deleteById(managementBatteryId);
    return ResponseEntity.noContent().build();
  }
}
