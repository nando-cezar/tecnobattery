package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ClientDTO;
import com.tecnobattery.tbsystem.entities.Client;
import com.tecnobattery.tbsystem.repositories.ClientRepository;

import org.hibernate.collection.spi.PersistentCollection;
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

  @Transactional(readOnly = true)
  public List<ClientDTO> findAll() {
    List<Client> clients = clientRepository.findAll();
    return toCollectionDTO(clients);
  }

  private ClientDTO toModel(Client client) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(client, ClientDTO.class);
  }

  private List<ClientDTO> toCollectionDTO(List<Client> clients) {
    return clients.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
