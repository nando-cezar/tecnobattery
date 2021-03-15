package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ManagementBatteryResponse;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementBatteryRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBatteryService {

  @Autowired
  private ManagementBatteryRepository managementBatteryRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ManagementBatteryResponse save(ManagementBattery managementBattery) {
    return toolModelMapper.toModel(managementBatteryRepository.save(managementBattery),
        ManagementBatteryResponse.class);
  }

  @Transactional(readOnly = true)
  public List<ManagementBatteryResponse> findAll() {
    List<ManagementBattery> batterys = managementBatteryRepository.findAll();
    return toolModelMapper.toCollection(batterys, ManagementBatteryResponse.class);
  }

  @Transactional(readOnly = true)
  public ManagementBatteryResponse findById(Long managementBatteryId) {
    Optional<ManagementBattery> managementBattery = managementBatteryRepository.findById(managementBatteryId);
    if (managementBattery.isPresent()) {
      return toolModelMapper.toModel(managementBattery.get(), ManagementBatteryResponse.class);
    }
    return toolModelMapper.toModel(
        managementBattery.orElseThrow(() -> new BusinessException("ManagementBattery: não encontrada.")),
        ManagementBatteryResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long managementBatteryId) {
    return managementBatteryRepository.existsById(managementBatteryId);
  }

  public void deleteById(Long managementBatteryId) {
    managementBatteryRepository.deleteById(managementBatteryId);
  }
}
