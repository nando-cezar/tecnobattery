package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Battery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

}
