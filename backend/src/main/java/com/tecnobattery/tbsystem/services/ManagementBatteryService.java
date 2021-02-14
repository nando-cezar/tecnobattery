package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementBatteryDTO;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.repositories.ManagementBatteryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBatteryService {

  @Autowired
  private ManagementBatteryRepository batteryRepository;

  @Autowired
  private ModelMapper mapper;

  @Transactional(readOnly = true)
  public List<ManagementBatteryDTO> findAll() {
    List<ManagementBattery> batterys = batteryRepository.findAll();
    return toCollectionDTO(batterys);
  }

  private ManagementBatteryDTO toModel(ManagementBattery managementBattery) {
    return mapper.map(managementBattery, ManagementBatteryDTO.class);
  }

  private List<ManagementBatteryDTO> toCollectionDTO(List<ManagementBattery> batterys) {
    return batterys.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
