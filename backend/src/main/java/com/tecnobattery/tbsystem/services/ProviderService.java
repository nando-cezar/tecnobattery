package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.ProviderOutput;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.exception.BusinessException;
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

  public ProviderOutput save(Provider provider) {

    Provider providerExists = providerRepository.findByCnpj(provider.getCnpj());

    if (providerExists != null && !providerExists.equals(provider)) {
      throw new BusinessException("Já existe um fornecedor cadastrado com este CNPJ.");
    }
    return toModel(providerRepository.save(provider));
  }

  @Transactional(readOnly = true)
  public List<ProviderOutput> findAll() {
    List<Provider> providers = providerRepository.findAll();
    return toCollectionDTO(providers);
  }

  @Transactional(readOnly = true)
  public ProviderOutput findById(Long providerId) {
    Optional<Provider> provider = providerRepository.findById(providerId);
    if (provider.isPresent()) {
      return toModel(provider.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long providerId) {
    return providerRepository.existsById(providerId);
  }

  public void deleteById(Long providerId) {
    providerRepository.deleteById(providerId);
  }

  private ProviderOutput toModel(Provider provider) {
    return mapper.map(provider, ProviderOutput.class);
  }

  private List<ProviderOutput> toCollectionDTO(List<Provider> providers) {
    return providers.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
