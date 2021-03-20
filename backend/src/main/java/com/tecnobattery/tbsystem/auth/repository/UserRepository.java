package com.tecnobattery.tbsystem.auth.repository;

import java.util.Optional;

import com.tecnobattery.tbsystem.auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  Optional<User> findByUsername(String username);
}
