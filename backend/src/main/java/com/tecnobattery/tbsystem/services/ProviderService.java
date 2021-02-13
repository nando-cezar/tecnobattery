package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ProviderDTO;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;

import org.hibernate.collection.spi.PersistentCollection;
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

  @Transactional(readOnly = true)
  public List<ProviderDTO> findAll() {
    List<Provider> providers = providerRepository.findAll();
    return toCollectionDTO(providers);
  }

  private ProviderDTO toModel(Provider provider) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(provider, ProviderDTO.class);
  }

  private List<ProviderDTO> toCollectionDTO(List<Provider> providers) {
    return providers.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
