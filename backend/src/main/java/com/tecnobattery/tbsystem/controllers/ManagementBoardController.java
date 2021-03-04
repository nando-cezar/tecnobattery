package com.tecnobattery.tbsystem.controllers;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.input.ManagementBoardInput;
import com.tecnobattery.tbsystem.dto.output.ManagementBoardOutput;
import com.tecnobattery.tbsystem.entities.Board;
import com.tecnobattery.tbsystem.entities.ManagementBoard;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.services.BoardService;
import com.tecnobattery.tbsystem.services.ManagementBoardService;
import com.tecnobattery.tbsystem.services.ProviderService;
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
@RequestMapping(value = "/managementBoards")
public class ManagementBoardController {

  @Autowired
  private ManagementBoardService managementBoardService;

  @Autowired
  private BoardService batteryService;

  @Autowired
  private ProviderService providerService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ManagementBoardOutput save(@Valid @RequestBody ManagementBoardInput managementBoardInput) {

    ManagementBoard managementBoard = toolModelMapper.toModel(managementBoardInput, ManagementBoard.class);
    managementBoard.setBoard(toolModelMapper.toModel(batteryService.findById(managementBoardInput.getBoardId()), Board.class));
    managementBoard.setProvider(toolModelMapper.toModel(providerService.findById(managementBoardInput.getProviderId()), Provider.class));
    managementBoard.setMoment(OffsetDateTime.now());

    return managementBoardService.save(managementBoard);
  }

  @GetMapping
  public ResponseEntity<List<ManagementBoardOutput>> findAll() {
    return ResponseEntity.ok().body(managementBoardService.findAll());
  }

  @GetMapping("/{managementBoardId}")
  public ResponseEntity<ManagementBoardOutput> findById(@PathVariable Long managementBoardId) {
    return ResponseEntity.ok(managementBoardService.findById(managementBoardId));
  }

  @PutMapping("/{managementBoardId}")
  public ResponseEntity<ManagementBoardOutput> update(@Valid @PathVariable Long managementBoardId, @RequestBody ManagementBoardInput managementBoardInput) {

    if (!managementBoardService.existsById(managementBoardId)) {
      return ResponseEntity.notFound().build();
    }

    ManagementBoard managementBoard = toolModelMapper.toModel(managementBoardService.findById(managementBoardId), ManagementBoard.class);
    managementBoard.setBoard(toolModelMapper.toModel(batteryService.findById(managementBoardInput.getBoardId()), Board.class));
    managementBoard.setProvider(toolModelMapper.toModel(providerService.findById(managementBoardInput.getProviderId()), Provider.class));
    managementBoard.setAmount(managementBoardInput.getAmount());
    managementBoard.setId(managementBoardId);

    return ResponseEntity.ok(managementBoardService.save(managementBoard));
  }

  @DeleteMapping("/{managementBoardId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long managementBoardId) {
    if (!managementBoardService.existsById(managementBoardId)) {
      return ResponseEntity.notFound().build();
    }
    managementBoardService.deleteById(managementBoardId);
    return ResponseEntity.noContent().build();
  }
}
