package com.tecnobattery.tbsystem.auth.repository;

import java.util.Optional;

import com.tecnobattery.tbsystem.auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
