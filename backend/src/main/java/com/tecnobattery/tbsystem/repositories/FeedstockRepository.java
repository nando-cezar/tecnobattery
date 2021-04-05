package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Feedstock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FeedstockRepository extends JpaRepository<Feedstock, Long> {

  Feedstock findByModel(String model);

  List<Feedstock> findByBrandContaining(String brand);

}
