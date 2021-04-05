package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface StockRepository extends JpaRepository<Stock, Long> {

}
