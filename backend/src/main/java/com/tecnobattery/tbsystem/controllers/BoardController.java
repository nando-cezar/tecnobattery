package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.BoardOutput;
import com.tecnobattery.tbsystem.dto.input.BoardInput;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.services.BoardService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

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

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BoardOutput save(@Valid @RequestBody BoardInput boardInput) {
    return boardService.save(toolModelMapper.toModel(boardInput, Board.class));
  }

  @GetMapping
  public ResponseEntity<List<BoardOutput>> findAll() {
    return ResponseEntity.ok().body(boardService.findAll());
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<BoardOutput> findById(@PathVariable Long boardId) {
      return ResponseEntity.ok(boardService.findById(boardId));
  }

  @PutMapping("/{boardId}")
  public ResponseEntity<BoardOutput> update(@Valid @PathVariable Long boardId,
      @RequestBody BoardInput boardInput) {

    if (!boardService.existsById(boardId)) {
      return ResponseEntity.notFound().build();
    }

    Board board = new Board();
    board = toolModelMapper.toModel(boardInput, Board.class);
    board.setId(boardId);
    
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
