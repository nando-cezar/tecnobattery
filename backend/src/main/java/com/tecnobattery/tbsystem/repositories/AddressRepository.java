package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface AddressRepository extends JpaRepository<Address, Long> {

}
