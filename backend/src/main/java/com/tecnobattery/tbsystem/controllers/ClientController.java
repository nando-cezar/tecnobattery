package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import com.tecnobattery.tbsystem.dto.ClientDTO;
import com.tecnobattery.tbsystem.dto.input.ClientInput;
import com.tecnobattery.tbsystem.services.ClientService;

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
@RequestMapping(value = "/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientDTO save(@RequestBody ClientInput client) {
    return clientService.save(client.getCnpj(), client.getName(), client.getFantasyName(), client.getPhone(),
        client.getEmail(), client.getPostalCode(), client.getPublicPlace(), client.getComplement(),
        client.getNeighborhood(), client.getCity(), client.getState());
  }

  @GetMapping
  public ResponseEntity<List<ClientDTO>> findAll() {
    List<ClientDTO> list = clientService.findAll();
    return ResponseEntity.ok().body(list);
  }
}
