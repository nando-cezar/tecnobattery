package com.tecnobattery.tbsystem.controllers.management;

import com.tecnobattery.tbsystem.dto.response.AddressResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/management/api/v1/address")
@AllArgsConstructor
public class AddressManagementController {

  private final String URL = "https://brasilapi.com.br/api/cep/v1/";

  @GetMapping("/{cep}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
  public ResponseEntity<AddressResponse> findByCep(@PathVariable String cep) {
    return ResponseEntity.ok(new RestTemplate().getForObject(URL + cep, AddressResponse.class));
  }

}
