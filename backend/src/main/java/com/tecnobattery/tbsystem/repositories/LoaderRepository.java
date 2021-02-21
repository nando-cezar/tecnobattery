package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Loader;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaderRepository extends JpaRepository<Loader, Long> {

  Loader findByModel(String model);

  List<Loader> findByBrandContaining(String brand);
}
