package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.LoaderDTO;
import com.tecnobattery.tbsystem.services.LoaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/loaders")
public class LoaderController {

  @Autowired
  private LoaderService loaderService;

  @GetMapping
  public ResponseEntity<List<LoaderDTO>> findAll() {
    List<LoaderDTO> list = loaderService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
