package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.ManagementLoaderOutput;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.ManagementLoaderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementLoaderService {

  @Autowired
  private ManagementLoaderRepository managementLoaderRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public ManagementLoaderOutput save(ManagementLoader managementLoader) {
    return toolModelMapper.toModel(managementLoaderRepository.save(managementLoader), ManagementLoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public List<ManagementLoaderOutput> findAll() {
    List<ManagementLoader> loaders = managementLoaderRepository.findAll();
    return toolModelMapper.toCollection(loaders, ManagementLoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public ManagementLoaderOutput findById(Long managementLoaderId) {
    Optional<ManagementLoader> managementLoader = managementLoaderRepository.findById(managementLoaderId);
    if (managementLoader.isPresent()) {
      return toolModelMapper.toModel(managementLoader.get(), ManagementLoaderOutput.class);
    }
    return toolModelMapper.toModel(
        managementLoader.orElseThrow(() -> new BusinessException("ManagementLoader: não encontrada.")),
        ManagementLoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long managementLoaderId) {
    return managementLoaderRepository.existsById(managementLoaderId);
  }

  public void deleteById(Long managementLoaderId) {
    managementLoaderRepository.deleteById(managementLoaderId);
  }
}
