package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);
}
