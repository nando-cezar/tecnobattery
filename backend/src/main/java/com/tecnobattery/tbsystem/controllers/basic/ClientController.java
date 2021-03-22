package com.tecnobattery.tbsystem.controllers.basic;

import java.util.List;

import com.tecnobattery.tbsystem.dto.response.ClientResponse;
import com.tecnobattery.tbsystem.services.ClientService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/clients")
@AllArgsConstructor
public class ClientController {

  private final ClientService clientService;

  @GetMapping
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<List<ClientResponse>> findAll() {
    return ResponseEntity.ok().body(clientService.findAll());
  }

  @GetMapping("/{clientId}")
  @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
  public ResponseEntity<ClientResponse> findById(@PathVariable Long clientId) {
    return ResponseEntity.ok(clientService.findById(clientId));
  }
}
