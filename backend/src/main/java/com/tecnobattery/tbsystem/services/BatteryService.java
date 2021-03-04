package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.BatteryOutput;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.BatteryRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatteryService {

  @Autowired
  private BatteryRepository batteryRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public BatteryOutput save(Battery battery, boolean identifier) {

    if (!identifier) {

      Battery batteryExists = batteryRepository.findByModel(battery.getModel());

      if (batteryExists != null && !batteryExists.equals(battery)) {
        throw new BusinessException("Já existe uma bateria cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(batteryRepository.save(battery), BatteryOutput.class);
  }

  @Transactional(readOnly = true)
  public List<BatteryOutput> findAll() {
    List<Battery> batterys = batteryRepository.findAll();
    return toolModelMapper.toCollection(batterys, BatteryOutput.class);
  }

  @Transactional(readOnly = true)
  public BatteryOutput findById(Long batteryId) {
    Optional<Battery> battery = batteryRepository.findById(batteryId);
    if (battery.isPresent()) {
      return toolModelMapper.toModel(battery.get(), BatteryOutput.class);
    }
    return toolModelMapper.toModel(battery.orElseThrow(() -> new BusinessException("Battery: não encontrada.")),
        BatteryOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long batteryId) {
    return batteryRepository.existsById(batteryId);
  }

  public void deleteById(Long batteryId) {
    batteryRepository.deleteById(batteryId);
  }

}
