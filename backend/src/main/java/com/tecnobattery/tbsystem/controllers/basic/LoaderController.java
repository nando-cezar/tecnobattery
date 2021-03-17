package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.request.LoaderRequest;
import com.tecnobattery.tbsystem.dto.response.LoaderResponse;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.services.LoaderService;
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
@RequestMapping(value = "/api/v1/loaders")
public class LoaderController {

  @Autowired
  private LoaderService loaderService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public LoaderResponse save(@Valid @RequestBody LoaderRequest loaderInput) {
    return loaderService.save(toolModelMapper.toModel(loaderInput, Loader.class), false);
  }

  @GetMapping
  public ResponseEntity<List<LoaderResponse>> findAll() {
    return ResponseEntity.ok().body(loaderService.findAll());
  }

  @GetMapping("/{loaderId}")
  public ResponseEntity<LoaderResponse> findById(@PathVariable Long loaderId) {
    return ResponseEntity.ok(loaderService.findById(loaderId));
  }
}
