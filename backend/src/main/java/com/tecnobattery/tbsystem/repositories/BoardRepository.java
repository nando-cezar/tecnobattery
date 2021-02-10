package com.tecnobattery.tbsystem.repositories;

import com.tecnobattery.tbsystem.entities.Board;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
