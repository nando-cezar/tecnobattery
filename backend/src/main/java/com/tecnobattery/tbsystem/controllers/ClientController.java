package com.tecnobattery.tbsystem.controllers;

import java.util.List;

import javax.validation.Valid;

import com.tecnobattery.tbsystem.dto.output.ClientOutput;
import com.tecnobattery.tbsystem.dto.input.ClientInput;
import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.services.ClientService;

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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientOutput save(@Valid @RequestBody ClientInput clientInput) {
    Client client = new Client();
    Address address = new Address();
    client.setCnpj(clientInput.getCnpj());
    client.setName(clientInput.getName());
    client.setFantasyName(clientInput.getFantasyName());
    client.setPhone(clientInput.getPhone());
    client.setEmail(clientInput.getEmail());
    address.setPostalCode(clientInput.getPostalCode());
    address.setPublicPlace(clientInput.getPublicPlace());
    address.setComplement(clientInput.getComplement());
    address.setNeighborhood(clientInput.getNeighborhood());
    address.setCity(clientInput.getCity());
    address.setState(clientInput.getState());
    client.setAddress(address);
    return clientService.save(client);
  }

  @GetMapping
  public ResponseEntity<List<ClientOutput>> findAll() {
    List<ClientOutput> list = clientService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/{clientId}")
  public ResponseEntity<ClientOutput> findById(@PathVariable Long clientId) {
    ClientOutput client = clientService.findById(clientId);
    if (client != null) {
      return ResponseEntity.ok(client);
    }
    return ResponseEntity.notFound().build();
  }

  @PutMapping("/{clientId}")
  public ResponseEntity<ClientOutput> update(@Valid @PathVariable Long clientId, @RequestBody ClientInput clientInput) {

    if (!clientService.existsById(clientId)) {
      return ResponseEntity.notFound().build();
    }

    Client client = new Client();
    Address address = new Address();
    client.setId(clientId);
    client.setCnpj(clientInput.getCnpj());
    client.setName(clientInput.getName());
    client.setFantasyName(clientInput.getFantasyName());
    client.setPhone(clientInput.getPhone());
    client.setEmail(clientInput.getEmail());
    address.setPostalCode(clientInput.getPostalCode());
    address.setPublicPlace(clientInput.getPublicPlace());
    address.setComplement(clientInput.getComplement());
    address.setNeighborhood(clientInput.getNeighborhood());
    address.setCity(clientInput.getCity());
    address.setState(clientInput.getState());
    client.setAddress(address);

    return ResponseEntity.ok(clientService.save(client));
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
