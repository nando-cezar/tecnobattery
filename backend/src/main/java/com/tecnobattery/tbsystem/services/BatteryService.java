package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.BatteryResponse;
import com.tecnobattery.tbsystem.entities.Battery;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.BatteryRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BatteryService {

  private final BatteryRepository batteryRepository;
  private final ToolModelMapper toolModelMapper;

  public BatteryResponse save(Battery battery, boolean identifier) {

    if (!identifier) {

      Battery batteryExists = batteryRepository.findByModel(battery.getModel());

      if (batteryExists != null && !batteryExists.equals(battery)) {
        throw new BusinessException("Já existe uma bateria cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(batteryRepository.save(battery), BatteryResponse.class);
  }

  public List<BatteryResponse> findAll() {
    return toolModelMapper.toCollection(batteryRepository.findAll(), BatteryResponse.class);
  }

  public BatteryResponse findById(Long batteryId) {
    Optional<Battery> battery = batteryRepository.findById(batteryId);
    if (battery.isPresent()) {
      return toolModelMapper.toModel(battery.get(), BatteryResponse.class);
    }
    return toolModelMapper.toModel(battery.orElseThrow(() -> new BusinessException("Battery: não encontrada.")),
        BatteryResponse.class);
  }

  public boolean existsById(Long batteryId) {
    return batteryRepository.existsById(batteryId);
  }

  public void deleteById(Long batteryId) {
    batteryRepository.deleteById(batteryId);
  }

}
