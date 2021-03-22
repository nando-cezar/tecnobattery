package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.ManagementBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ManagementBoardRepository extends JpaRepository<ManagementBoard, Long> {

}
