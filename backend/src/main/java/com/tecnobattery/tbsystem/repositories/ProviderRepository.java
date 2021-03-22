package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Provider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProviderRepository extends JpaRepository<Provider, Long> {

  Provider findByCnpj(String cnpj);

  List<Provider> findByNameContaining(String name);
}
