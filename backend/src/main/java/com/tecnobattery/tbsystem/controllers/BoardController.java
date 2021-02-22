package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.BoardOutput;
import com.tecnobattery.tbsystem.dto.input.BoardInput;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.services.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
  public BoardOutput save(@Valid @RequestBody BoardInput boardInput) {
    Board board = new Board();
    board.setBrand(boardInput.getBrand());
    board.setModel(boardInput.getModel());
    board.setPower(boardInput.getPower());
    board.setVoltage(boardInput.getVoltage());
    board.setWidth(boardInput.getWidth());
    board.setHeight(boardInput.getHeight());
    board.setLength(boardInput.getLength());
    board.setWeight(boardInput.getWeight());
    board.setImageUrl(boardInput.getImageUrl());
    return boardService.save(board);
  }

  @GetMapping
  public ResponseEntity<List<BoardOutput>> findAll() {
    List<BoardOutput> list = boardService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<BoardOutput> findById(@PathVariable Long boardId) {
    BoardOutput board = boardService.findById(boardId);
    if (board != null) {
      return ResponseEntity.ok(board);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{boardId}")
  public ResponseEntity<BoardOutput> update(@Valid @PathVariable Long boardId, @RequestBody BoardInput boardInput) {

    if (!boardService.existsById(boardId)) {
      return ResponseEntity.notFound().build();
    }

    Board board = new Board();
    board.setId(boardId);
    board.setBrand(boardInput.getBrand());
    board.setModel(boardInput.getModel());
    board.setPower(boardInput.getPower());
    board.setVoltage(boardInput.getVoltage());
    board.setWidth(boardInput.getWidth());
    board.setHeight(boardInput.getHeight());
    board.setLength(boardInput.getLength());
    board.setWeight(boardInput.getWeight());
    board.setImageUrl(boardInput.getImageUrl());

    return ResponseEntity.ok(boardService.save(board));
  }

  @DeleteMapping("/{boardId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long boardId) {
    if (!boardService.existsById(boardId)) {
      return ResponseEntity.notFound().build();
    }
    boardService.deleteById(boardId);
    return ResponseEntity.noContent().build();
  }
}
