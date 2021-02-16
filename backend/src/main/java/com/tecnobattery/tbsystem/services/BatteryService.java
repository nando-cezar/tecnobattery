package com.tecnobattery.tbsystem.services;

import java.util.List;
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

  public BatteryDTO save(String brand, String model, Integer capacity, Integer voltage, Integer diameter,
      Integer height, String imageUrl) {
    Battery battery = new Battery();
    battery.setBrand(brand);
    battery.setModel(model);
    battery.setCapacity(capacity);
    battery.setVoltage(voltage);
    battery.setDiameter(diameter);
    battery.setHeight(height);
    battery.setImageUrl(imageUrl);

    return toModel(batteryRepository.save(battery));
  }

  @Transactional(readOnly = true)
  public List<BatteryDTO> findAll() {
    List<Battery> batterys = batteryRepository.findAll();
    return toCollectionDTO(batterys);
  }

  private BatteryDTO toModel(Battery battery) {
    return mapper.map(battery, BatteryDTO.class);
  }

  private List<BatteryDTO> toCollectionDTO(List<Battery> batterys) {
    return batterys.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
