package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ClientResponse;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ClientRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

  private final ClientRepository clientRepository;
  private final ToolModelMapper toolModelMapper;

  public ClientResponse save(Client client, boolean identifier) {

    if (!identifier) {

      Client clientExists = clientRepository.findByCnpj(client.getCnpj());

      if (clientExists != null && !clientExists.equals(client)) {
        throw new BusinessException("Já existe um cliente cadastrado com este CNPJ.");
      }
    }
    return toolModelMapper.toModel(clientRepository.save(client), ClientResponse.class);
  }

  @Transactional(readOnly = true)
  public List<ClientResponse> findAll() {
    List<Client> clients = clientRepository.findAll();
    return toolModelMapper.toCollection(clients, ClientResponse.class);
  }

  @Transactional(readOnly = true)
  public ClientResponse findById(Long clientId) {
    Optional<Client> client = clientRepository.findById(clientId);
    if (client.isPresent()) {
      return toolModelMapper.toModel(client.get(), ClientResponse.class);
    }
    return toolModelMapper.toModel(client.orElseThrow(() -> new BusinessException("Client: não encontrada.")),
        ClientResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long clientId) {
    return clientRepository.existsById(clientId);
  }

  public void deleteById(Long clientId) {
    clientRepository.deleteById(clientId);
  }
}
