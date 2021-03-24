package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface OrderRepository extends JpaRepository<Order, Long> {

  @Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products "
      + " WHERE obj.status = 'PENDING' ORDER BY obj.opening ASC")
  List<Order> findOrdersWithProducts();
}
