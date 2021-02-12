package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.BatteryDTO;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.repositories.BatteryRepository;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatteryService {

  @Autowired
  private BatteryRepository batteryRepository;

  @Autowired
  private ModelMapper mapper;

  public List<BatteryDTO> findAll() {
    List<Battery> batterys = batteryRepository.findAll();
    return toCollectionDTO(batterys);
  }

  private BatteryDTO toModel(Battery battery) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(battery, BatteryDTO.class);
  }

  private List<BatteryDTO> toCollectionDTO(List<Battery> batterys) {
    return batterys.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
