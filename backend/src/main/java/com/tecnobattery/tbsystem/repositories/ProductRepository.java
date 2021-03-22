package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findByName(String name);

  List<Product> findByNameContaining(String name);
}
