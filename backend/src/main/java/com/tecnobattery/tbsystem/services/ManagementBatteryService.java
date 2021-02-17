package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementBatteryDTO;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.entities.ManagementBattery;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.repositories.BatteryRepository;
import com.tecnobattery.tbsystem.repositories.ManagementBatteryRepository;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementBatteryService {

  @Autowired
  private ManagementBatteryRepository managementBatteryRepository;

  @Autowired
  private ProviderRepository providerRepository;

  @Autowired
  private BatteryRepository batteryRepository;

  @Autowired
  private ModelMapper mapper;

  public ManagementBatteryDTO save(Long providerId, Long batteryId, OffsetDateTime moment, Integer amount)
      throws Exception {
    Provider provider = providerRepository.findById(providerId).orElseThrow(() -> new Exception("Provider: not found"));
    Battery battery = batteryRepository.findById(batteryId).orElseThrow(() -> new Exception("Battery: not found"));
    ManagementBattery managementBattery = new ManagementBattery();
    managementBattery.setProvider(provider);
    managementBattery.setBattery(battery);
    managementBattery.setMoment(moment);
    managementBattery.setAmount(amount);

    return toModel(managementBatteryRepository.save(managementBattery));
  }

  @Transactional(readOnly = true)
  public List<ManagementBatteryDTO> findAll() {
    List<ManagementBattery> batterys = managementBatteryRepository.findAll();
    return toCollectionDTO(batterys);
  }

  private ManagementBatteryDTO toModel(ManagementBattery managementBattery) {
    return mapper.map(managementBattery, ManagementBatteryDTO.class);
  }

  private List<ManagementBatteryDTO> toCollectionDTO(List<ManagementBattery> batterys) {
    return batterys.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
