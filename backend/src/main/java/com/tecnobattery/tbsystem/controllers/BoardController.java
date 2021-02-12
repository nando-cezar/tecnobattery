package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.BoardDTO;
import com.tecnobattery.tbsystem.services.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping
  public ResponseEntity<List<BoardDTO>> findAll() {
    List<BoardDTO> list = boardService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
