package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.LoaderDTO;
import com.tecnobattery.tbsystem.dto.input.LoaderInput;
import com.tecnobattery.tbsystem.services.LoaderService;

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
@RequestMapping(value = "/loaders")
public class LoaderController {

  @Autowired
  private LoaderService loaderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoaderDTO save(@RequestBody LoaderInput loader) {
    return loaderService.save(loader.getBrand(), loader.getModel(), loader.getPower(), loader.getVoltage(),
        loader.getWidth(), loader.getHeight(), loader.getLength(), loader.getImageUrl());
  }

  @GetMapping
  public ResponseEntity<List<LoaderDTO>> findAll() {
    List<LoaderDTO> list = loaderService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
