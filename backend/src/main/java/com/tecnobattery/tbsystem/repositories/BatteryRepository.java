package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Battery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface BatteryRepository extends JpaRepository<Battery, Long> {

  Battery findByModel(String model);

  List<Battery> findByBrandContaining(String brand);

}
