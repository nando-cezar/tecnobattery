package com.tecnobattery.tbsystem.controllers.management;

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
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping(value = "/management/api/v1/boards")
public class BoardManagementController {

  @Autowired
  private BoardService boardService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @PreAuthorize("hasAuthority('global:write')")
  @ResponseStatus(HttpStatus.CREATED)
  public BoardResponse save(@Valid @RequestBody BoardRequest boardInput) {
    return boardService.save(toolModelMapper.toModel(boardInput, Board.class), false);
  }

  @GetMapping
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<List<BoardResponse>> findAll() {
    return ResponseEntity.ok().body(boardService.findAll());
  }

  @GetMapping("/{boardId}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<BoardResponse> findById(@PathVariable Long boardId) {
    return ResponseEntity.ok(boardService.findById(boardId));
  }

  @PutMapping("/{boardId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<BoardResponse> update(@Valid @PathVariable Long boardId, @RequestBody BoardRequest boardInput) {

    if (!boardService.existsById(boardId)) {
      return ResponseEntity.notFound().build();
    }

    Board board = new Board();
    board = toolModelMapper.toModel(boardInput, Board.class);
    board.setId(boardId);

    return ResponseEntity.ok(boardService.save(board, true));
  }

  @DeleteMapping("/{boardId}")
  @PreAuthorize("hasAuthority('global:write')")
  public ResponseEntity<Void> deleteById(@PathVariable Long boardId) {
    if (!boardService.existsById(boardId)) {
      return ResponseEntity.notFound().build();
    }
    boardService.deleteById(boardId);
    return ResponseEntity.noContent().build();
  }
}
