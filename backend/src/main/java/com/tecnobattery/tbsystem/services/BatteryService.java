package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.BatteryDTO;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.repositories.BatteryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatteryService {

  @Autowired
  private BatteryRepository batteryRepository;

  @Autowired
  private ModelMapper mapper;

  public BatteryDTO save(Battery battery) {
    return toModel(batteryRepository.save(battery));
  }

  @Transactional(readOnly = true)
  public List<BatteryDTO> findAll() {
    List<Battery> batterys = batteryRepository.findAll();
    return toCollectionDTO(batterys);
  }

  @Transactional(readOnly = true)
  public BatteryDTO findById(Long batteryId) {
    Optional<Battery> battery = batteryRepository.findById(batteryId);
    if (battery.isPresent()) {
      return toModel(battery.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long batteryId) {
    return batteryRepository.existsById(batteryId);
  }

  public void deleteById(Long batteryId) {
    batteryRepository.deleteById(batteryId);
  }

  private BatteryDTO toModel(Battery battery) {
    return mapper.map(battery, BatteryDTO.class);
  }

  private List<BatteryDTO> toCollectionDTO(List<Battery> batterys) {
    return batterys.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
