package com.tecnobattery.tbsystem.services;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.ManagementLoaderDTO;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.entities.ManagementLoader;
import com.tecnobattery.tbsystem.entities.Provider;
import com.tecnobattery.tbsystem.repositories.LoaderRepository;
import com.tecnobattery.tbsystem.repositories.ManagementLoaderRepository;
import com.tecnobattery.tbsystem.repositories.ProviderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagementLoaderService {

  @Autowired
  private ManagementLoaderRepository managementLoaderRepository;

  @Autowired
  private ProviderRepository providerRepository;

  @Autowired
  private LoaderRepository loaderRepository;

  @Autowired
  private ModelMapper mapper;

  public ManagementLoaderDTO save(Long providerId, Long loaderId, OffsetDateTime moment, Integer amount)
      throws Exception {
    Provider provider = providerRepository.findById(providerId).orElseThrow(() -> new Exception("Provider: not found"));
    Loader loader = loaderRepository.findById(loaderId).orElseThrow(() -> new Exception("Loader: not found"));
    ManagementLoader managementLoader = new ManagementLoader();
    managementLoader.setProvider(provider);
    managementLoader.setLoader(loader);
    managementLoader.setMoment(moment);
    managementLoader.setAmount(amount);

    return toModel(managementLoaderRepository.save(managementLoader));
  }

  @Transactional(readOnly = true)
  public List<ManagementLoaderDTO> findAll() {
    List<ManagementLoader> loaders = managementLoaderRepository.findAll();
    return toCollectionDTO(loaders);
  }

  private ManagementLoaderDTO toModel(ManagementLoader managementLoader) {
    return mapper.map(managementLoader, ManagementLoaderDTO.class);
  }

  private List<ManagementLoaderDTO> toCollectionDTO(List<ManagementLoader> loaders) {
    return loaders.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
