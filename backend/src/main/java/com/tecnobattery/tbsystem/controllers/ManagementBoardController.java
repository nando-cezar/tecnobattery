package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.ManagementBoardDTO;
import com.tecnobattery.tbsystem.services.ManagementBoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/managementBoards")
public class ManagementBoardController {

  @Autowired
  private ManagementBoardService clientService;

  @GetMapping
  public ResponseEntity<List<ManagementBoardDTO>> findAll() {
    List<ManagementBoardDTO> list = clientService.findAll();
    return ResponseEntity.ok().body(list);
  }
}