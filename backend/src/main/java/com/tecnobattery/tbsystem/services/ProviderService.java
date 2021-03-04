package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.ProviderOutput;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderService {

  @Autowired
  private ProviderRepository providerRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ProviderOutput save(Provider provider, boolean identifier) {

    if (!identifier) {

      Provider providerExists = providerRepository.findByCnpj(provider.getCnpj());

      if (providerExists != null && !providerExists.equals(provider)) {
        throw new BusinessException("Já existe um fornecedor cadastrado com este CNPJ.");
      }
    }
    return toolModelMapper.toModel(providerRepository.save(provider), ProviderOutput.class);
  }

  @Transactional(readOnly = true)
  public List<ProviderOutput> findAll() {
    List<Provider> providers = providerRepository.findAll();
    return toolModelMapper.toCollection(providers, ProviderOutput.class);
  }

  @Transactional(readOnly = true)
  public ProviderOutput findById(Long providerId) {
    Optional<Provider> provider = providerRepository.findById(providerId);
    if (provider.isPresent()) {
      return toolModelMapper.toModel(provider.get(), ProviderOutput.class);
    }
    return toolModelMapper.toModel(provider.orElseThrow(() -> new BusinessException("Provider: não encontrada.")),
        ProviderOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long providerId) {
    return providerRepository.existsById(providerId);
  }

  public void deleteById(Long providerId) {
    providerRepository.deleteById(providerId);
  }
}
