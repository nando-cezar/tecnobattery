package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, Long> {

}
