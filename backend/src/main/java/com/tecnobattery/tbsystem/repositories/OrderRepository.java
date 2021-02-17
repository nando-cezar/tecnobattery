package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
