package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServiceRepository extends JpaRepository<Order, Long> {

}
