package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
