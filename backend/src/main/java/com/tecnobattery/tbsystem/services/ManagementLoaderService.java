package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ManagementLoaderResponse;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementLoaderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagementLoaderService {

  private final ManagementLoaderRepository managementLoaderRepository;
  private final ToolModelMapper toolModelMapper;

  public ManagementLoaderResponse save(ManagementLoader managementLoader) {
    return toolModelMapper.toModel(managementLoaderRepository.save(managementLoader), ManagementLoaderResponse.class);
  }

  @Transactional(readOnly = true)
  public List<ManagementLoaderResponse> findAll() {
    List<ManagementLoader> loaders = managementLoaderRepository.findAll();
    return toolModelMapper.toCollection(loaders, ManagementLoaderResponse.class);
  }

  @Transactional(readOnly = true)
  public ManagementLoaderResponse findById(Long managementLoaderId) {
    Optional<ManagementLoader> managementLoader = managementLoaderRepository.findById(managementLoaderId);
    if (managementLoader.isPresent()) {
      return toolModelMapper.toModel(managementLoader.get(), ManagementLoaderResponse.class);
    }
    return toolModelMapper.toModel(
        managementLoader.orElseThrow(() -> new BusinessException("ManagementLoader: não encontrada.")),
        ManagementLoaderResponse.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long managementLoaderId) {
    return managementLoaderRepository.existsById(managementLoaderId);
  }

  public void deleteById(Long managementLoaderId) {
    managementLoaderRepository.deleteById(managementLoaderId);
  }
}
