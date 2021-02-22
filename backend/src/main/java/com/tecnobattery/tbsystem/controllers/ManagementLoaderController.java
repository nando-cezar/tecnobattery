package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.output.ManagementLoaderOutput;
import com.tecnobattery.tbsystem.services.ManagementLoaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/managementLoaders")
public class ManagementLoaderController {

  @Autowired
  private ManagementLoaderService managementLoaderService;

  @GetMapping
  public ResponseEntity<List<ManagementLoaderOutput>> findAll() {
    List<ManagementLoaderOutput> list = managementLoaderService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
