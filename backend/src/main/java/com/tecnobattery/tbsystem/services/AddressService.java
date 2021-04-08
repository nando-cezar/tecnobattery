package com.tecnobattery.tbsystem.services;

import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.AddressResponse;
import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.AddressRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {

  private final AddressRepository addressRepository;
  private final ToolModelMapper toolModelMapper;

  public AddressResponse findById(String codePostal) {
    Optional<Address> address = addressRepository.searchPostalCode(codePostal);
    if (address.isPresent()) {
      return toolModelMapper.toModel(address.get(), AddressResponse.class);
    }
    return toolModelMapper.toModel(address.orElseThrow(() -> new BusinessException("Address: não encontrada.")),
        AddressResponse.class);
  }

}
