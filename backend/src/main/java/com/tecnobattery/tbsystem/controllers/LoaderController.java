package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.LoaderDTO;
import com.tecnobattery.tbsystem.dto.input.LoaderInput;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.services.LoaderService;

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
@RequestMapping(value = "/loaders")
public class LoaderController {

  @Autowired
  private LoaderService loaderService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoaderDTO save(@Valid @RequestBody LoaderInput loaderInput) {
    Loader loader = new Loader();
    loader.setBrand(loaderInput.getBrand());
    loader.setModel(loaderInput.getModel());
    loader.setPower(loaderInput.getPower());
    loader.setVoltage(loaderInput.getVoltage());
    loader.setWidth(loaderInput.getWidth());
    loader.setHeight(loaderInput.getHeight());
    loader.setLength(loaderInput.getLength());
    loader.setWeight(loaderInput.getWeight());
    loader.setImageUrl(loaderInput.getImageUrl());
    return loaderService.save(loader);
  }

  @GetMapping
  public ResponseEntity<List<LoaderDTO>> findAll() {
    List<LoaderDTO> list = loaderService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{loaderId}")
  public ResponseEntity<LoaderDTO> findById(@PathVariable Long loaderId) {
    LoaderDTO loader = loaderService.findById(loaderId);
    if (loader != null) {
      return ResponseEntity.ok(loader);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{loaderId}")
  public ResponseEntity<LoaderDTO> update(@Valid @PathVariable Long loaderId, @RequestBody LoaderInput loaderInput) {

    if (!loaderService.existsById(loaderId)) {
      return ResponseEntity.notFound().build();
    }

    Loader loader = new Loader();
    loader.setId(loaderId);
    loader.setBrand(loaderInput.getBrand());
    loader.setModel(loaderInput.getModel());
    loader.setPower(loaderInput.getPower());
    loader.setVoltage(loaderInput.getVoltage());
    loader.setWidth(loaderInput.getWidth());
    loader.setHeight(loaderInput.getHeight());
    loader.setLength(loaderInput.getLength());
    loader.setWeight(loaderInput.getWeight());
    loader.setImageUrl(loaderInput.getImageUrl());

    return ResponseEntity.ok(loaderService.save(loader));
  }

  @DeleteMapping("/{loaderId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long loaderId) {
    if (!loaderService.existsById(loaderId)) {
      return ResponseEntity.notFound().build();
    }
    loaderService.deleteById(loaderId);
    return ResponseEntity.noContent().build();
  }
}
