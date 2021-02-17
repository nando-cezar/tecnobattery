package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ClientDTO;
import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.entities.Client;
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

  public ClientDTO save(String cnpj, String name, String fantasyName, String phone, String email, String postalCode,
      String publicPlace, String complement, String neighborhood, String city, String state) {
    Client client = new Client();
    Address address = new Address();
    client.setCnpj(cnpj);
    client.setName(name);
    client.setFantasyName(fantasyName);
    client.setPhone(phone);
    client.setEmail(email);
    address.setPostalCode(postalCode);
    address.setPublicPlace(publicPlace);
    address.setComplement(complement);
    address.setNeighborhood(neighborhood);
    address.setCity(city);
    address.setState(state);
    client.setAddress(address);

    return toModel(clientRepository.save(client));
  }

  @Transactional(readOnly = true)
  public List<ClientDTO> findAll() {
    List<Client> clients = clientRepository.findAll();
    return toCollectionDTO(clients);
  }

  private ClientDTO toModel(Client client) {
    return mapper.map(client, ClientDTO.class);
  }

  private List<ClientDTO> toCollectionDTO(List<Client> clients) {
    return clients.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
