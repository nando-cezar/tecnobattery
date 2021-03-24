package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.response.ManagementLoaderResponse;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.error.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementLoaderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManagementLoaderService {

  private final ManagementLoaderRepository managementLoaderRepository;
  private final ToolModelMapper toolModelMapper;

  public ManagementLoaderResponse save(ManagementLoader managementLoader) {
    return toolModelMapper.toModel(managementLoaderRepository.save(managementLoader), ManagementLoaderResponse.class);
  }

  public List<ManagementLoaderResponse> findAll() {
    return toolModelMapper.toCollection(managementLoaderRepository.findAll(), ManagementLoaderResponse.class);
  }

  public ManagementLoaderResponse findById(Long managementLoaderId) {
    Optional<ManagementLoader> managementLoader = managementLoaderRepository.findById(managementLoaderId);
    if (managementLoader.isPresent()) {
      return toolModelMapper.toModel(managementLoader.get(), ManagementLoaderResponse.class);
    }
    return toolModelMapper.toModel(
        managementLoader.orElseThrow(() -> new BusinessException("ManagementLoader: não encontrada.")),
        ManagementLoaderResponse.class);
  }

  public boolean existsById(Long managementLoaderId) {
    return managementLoaderRepository.existsById(managementLoaderId);
  }

  public void deleteById(Long managementLoaderId) {
    managementLoaderRepository.deleteById(managementLoaderId);
  }
}
