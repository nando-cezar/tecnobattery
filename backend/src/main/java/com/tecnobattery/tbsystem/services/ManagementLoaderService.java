package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementLoaderDTO;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.repositories.ManagementLoaderRepository;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagementLoaderService {

  @Autowired
  private ManagementLoaderRepository loaderRepository;

  @Autowired
  private ModelMapper mapper;

  public List<ManagementLoaderDTO> findAll() {
    List<ManagementLoader> loaders = loaderRepository.findAll();
    return toCollectionDTO(loaders);
  }

  private ManagementLoaderDTO toModel(ManagementLoader managementLoader) {
    mapper.getConfiguration().setPropertyCondition(context -> !(context.getSource() instanceof PersistentCollection));
    return mapper.map(managementLoader, ManagementLoaderDTO.class);
  }

  private List<ManagementLoaderDTO> toCollectionDTO(List<ManagementLoader> loaders) {
    return loaders.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
