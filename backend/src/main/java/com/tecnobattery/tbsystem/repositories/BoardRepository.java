package com.tecnobattery.tbsystem.repositories;

import java.util.List;

import com.tecnobattery.tbsystem.entities.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface BoardRepository extends JpaRepository<Board, Long> {

  Board findByModel(String model);

  List<Board> findByBrandContaining(String brand);
}
