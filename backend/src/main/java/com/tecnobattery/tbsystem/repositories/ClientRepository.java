package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ClientRepository extends JpaRepository<Client, Long> {

  Client findByCnpj(String cnpj);

  List<Client> findByNameContaining(String name);
}
