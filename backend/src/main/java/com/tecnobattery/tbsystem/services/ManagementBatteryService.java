package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ManagementBatteryResponse;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementBatteryRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagementBatteryService {

  private final ManagementBatteryRepository managementBatteryRepository;
  private final ToolModelMapper toolModelMapper;

  public ManagementBatteryResponse save(ManagementBattery managementBattery) {
    return toolModelMapper.toModel(managementBatteryRepository.save(managementBattery),
        ManagementBatteryResponse.class);
  }

  public List<ManagementBatteryResponse> findAll() {
    return toolModelMapper.toCollection(managementBatteryRepository.findAll(), ManagementBatteryResponse.class);
  }

  public ManagementBatteryResponse findById(Long managementBatteryId) {
    Optional<ManagementBattery> managementBattery = managementBatteryRepository.findById(managementBatteryId);
    if (managementBattery.isPresent()) {
      return toolModelMapper.toModel(managementBattery.get(), ManagementBatteryResponse.class);
    }
    return toolModelMapper.toModel(
        managementBattery.orElseThrow(() -> new BusinessException("ManagementBattery: não encontrada.")),
        ManagementBatteryResponse.class);
  }

  public boolean existsById(Long managementBatteryId) {
    return managementBatteryRepository.existsById(managementBatteryId);
  }

  public void deleteById(Long managementBatteryId) {
    managementBatteryRepository.deleteById(managementBatteryId);
  }
}
