package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.BoardRequest;
import com.tecnobattery.tbsystem.dto.response.BoardResponse;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.services.BoardService;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/boards")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BoardResponse save(@Valid @RequestBody BoardRequest boardInput) {
    return boardService.save(toolModelMapper.toModel(boardInput, Board.class), false);
  }

  @GetMapping
  public ResponseEntity<List<BoardResponse>> findAll() {
    return ResponseEntity.ok().body(boardService.findAll());
  }

  @GetMapping("/{boardId}")
  public ResponseEntity<BoardResponse> findById(@PathVariable Long boardId) {
    return ResponseEntity.ok(boardService.findById(boardId));
  }
}
