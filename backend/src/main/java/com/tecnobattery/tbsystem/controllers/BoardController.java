package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.BoardDTO;
import com.tecnobattery.tbsystem.dto.input.BoardInput;
import com.tecnobattery.tbsystem.services.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BoardDTO save(@RequestBody BoardInput board) {
    return boardService.save(board.getBrand(), board.getModel(), board.getPower(), board.getVoltage(), board.getWidth(),
        board.getHeight(), board.getLength(), board.getImageUrl());
  }

  @GetMapping
  public ResponseEntity<List<BoardDTO>> findAll() {
    List<BoardDTO> list = boardService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
