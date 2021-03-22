package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.BoardResponse;
import com.tecnobattery.tbsystem.services.BoardService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/boards")
@AllArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<BoardResponse>> findAll() {
    return ResponseEntity.ok().body(boardService.findAll());
  }

  @GetMapping("/{boardId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<BoardResponse> findById(@PathVariable Long boardId) {
    return ResponseEntity.ok(boardService.findById(boardId));
  }
}
