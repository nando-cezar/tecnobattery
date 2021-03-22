package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ProviderResponse;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProviderService {

  private final ProviderRepository providerRepository;
  private final ToolModelMapper toolModelMapper;

  public ProviderResponse save(Provider provider, boolean identifier) {

    if (!identifier) {

      Provider providerExists = providerRepository.findByCnpj(provider.getCnpj());

      if (providerExists != null && !providerExists.equals(provider)) {
        throw new BusinessException("Já existe um fornecedor cadastrado com este CNPJ.");
      }
    }
    return toolModelMapper.toModel(providerRepository.save(provider), ProviderResponse.class);
  }

  @Transactional(readOnly = true)
  public List<ProviderResponse> findAll() {
    List<Provider> providers = providerRepository.findAll();
    return toolModelMapper.toCollection(providers, ProviderResponse.class);
  }

  @Transactional(readOnly = true)
  public ProviderResponse findById(Long providerId) {
    Optional<Provider> provider = providerRepository.findById(providerId);
    if (provider.isPresent()) {
      return toolModelMapper.toModel(provider.get(), ProviderResponse.class);
    }
    return toolModelMapper.toModel(provider.orElseThrow(() -> new BusinessException("Provider: não encontrada.")),
        ProviderResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long providerId) {
    return providerRepository.existsById(providerId);
  }

  public void deleteById(Long providerId) {
    providerRepository.deleteById(providerId);
  }
}
