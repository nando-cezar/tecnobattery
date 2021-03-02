package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.ClientOutput;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ClientRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ClientOutput save(Client client) {

    Client clientExists = clientRepository.findByCnpj(client.getCnpj());

    if (clientExists != null && clientExists.equals(client)) {
      throw new BusinessException("Já existe um cliente cadastrado com este CNPJ.");
    }
    return toolModelMapper.toModel(clientRepository.save(client), ClientOutput.class);
  }

  @Transactional(readOnly = true)
  public List<ClientOutput> findAll() {
    List<Client> clients = clientRepository.findAll();
    return toolModelMapper.toCollection(clients, ClientOutput.class);
  }

  @Transactional(readOnly = true)
  public ClientOutput findById(Long clientId) {
    Optional<Client> client = clientRepository.findById(clientId);
    if (client.isPresent()) {
      return toolModelMapper.toModel(client.get(), ClientOutput.class);
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
}
