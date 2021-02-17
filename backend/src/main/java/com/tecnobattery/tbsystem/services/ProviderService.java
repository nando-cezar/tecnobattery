package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ProviderDTO;
import com.tecnobattery.tbsystem.entities.Address;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderService {

  @Autowired
  private ProviderRepository providerRepository;

  @Autowired
  private ModelMapper mapper;

  public ProviderDTO save(String cnpj, String name, String fantasyName, String phone, String email, String postalCode,
      String publicPlace, String complement, String neighborhood, String city, String state) {
    Provider provider = new Provider();
    Address address = new Address();
    provider.setCnpj(cnpj);
    provider.setName(name);
    provider.setFantasyName(fantasyName);
    provider.setPhone(phone);
    provider.setEmail(email);
    address.setPostalCode(postalCode);
    address.setPublicPlace(publicPlace);
    address.setComplement(complement);
    address.setNeighborhood(neighborhood);
    address.setCity(city);
    address.setState(state);
    provider.setAddress(address);

    return toModel(providerRepository.save(provider));
  }

  @Transactional(readOnly = true)
  public List<ProviderDTO> findAll() {
    List<Provider> providers = providerRepository.findAll();
    return toCollectionDTO(providers);
  }

  private ProviderDTO toModel(Provider provider) {
    return mapper.map(provider, ProviderDTO.class);
  }

  private List<ProviderDTO> toCollectionDTO(List<Provider> providers) {
    return providers.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
