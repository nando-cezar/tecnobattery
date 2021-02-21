package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ClientDTO;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ClientRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ModelMapper mapper;

  public ClientDTO save(Client client) {

    Client clientExists = clientRepository.findByCnpj(client.getCnpj());

    if (clientExists != null && !clientExists.equals(client)) {
      throw new BusinessException("Já existe um cliente cadastrado com este CNPJ.");
    }
    return toModel(clientRepository.save(client));
  }

  @Transactional(readOnly = true)
  public List<ClientDTO> findAll() {
    List<Client> clients = clientRepository.findAll();
    return toCollectionDTO(clients);
  }

  @Transactional(readOnly = true)
  public ClientDTO findById(Long clientId) {
    Optional<Client> client = clientRepository.findById(clientId);
    if (client.isPresent()) {
      return toModel(client.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long clientId) {
    return clientRepository.existsById(clientId);
  }

  public void deleteById(Long clientId) {
    clientRepository.deleteById(clientId);
  }

  private ClientDTO toModel(Client client) {
    return mapper.map(client, ClientDTO.class);
  }

  private List<ClientDTO> toCollectionDTO(List<Client> clients) {
    return clients.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
