package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.ClientOutput;
import com.tecnobattery.tbsystem.dto.input.ClientInput;
//import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.services.ClientService;
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
@RequestMapping(value = "/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private ToolModelMapper toolModelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientOutput save(@Valid @RequestBody ClientInput clientInput) {

    return clientService.save(toolModelMapper.toModel(clientInput, Client.class), false);
  }

  @GetMapping
  public ResponseEntity<List<ClientOutput>> findAll() {
    return ResponseEntity.ok().body(clientService.findAll());
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<ClientOutput> findById(@PathVariable Long clientId) {
    return ResponseEntity.ok(clientService.findById(clientId));
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<ClientOutput> update(@Valid @PathVariable Long clientId, @RequestBody ClientInput clientInput) {

    if (!clientService.existsById(clientId)) {
      return ResponseEntity.notFound().build();
    }

    Client client = new Client();
    client = toolModelMapper.toModel(clientInput, Client.class);
    client.setId(clientId);

    return ResponseEntity.ok(clientService.save(client, true));
  }

  @DeleteMapping("/{clientId}")
  public ResponseEntity<Void> deleteById(@PathVariable Long clientId) {
    if (!clientService.existsById(clientId)) {
      return ResponseEntity.notFound().build();
    }
    clientService.deleteById(clientId);
    return ResponseEntity.noContent().build();
  }
}
