package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.ManagementBattery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ManagementBatteryRepository extends JpaRepository<ManagementBattery, Long> {

}
