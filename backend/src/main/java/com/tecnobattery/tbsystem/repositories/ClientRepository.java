package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
