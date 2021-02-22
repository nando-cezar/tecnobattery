package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.output.LoaderOutput;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.LoaderRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoaderService {

  @Autowired
  private LoaderRepository loaderRepository;

  @Autowired
  private ModelMapper mapper;

  public LoaderOutput save(Loader loader) {

    Loader loaderExists = loaderRepository.findByModel(loader.getModel());

    if (loaderExists != null && !loaderExists.equals(loader)) {
      throw new BusinessException("Já existe uma placa cadastrada com este modelo.");
    }
    return toModel(loaderRepository.save(loader));
  }

  @Transactional(readOnly = true)
  public List<LoaderOutput> findAll() {
    List<Loader> loaders = loaderRepository.findAll();
    return toCollectionDTO(loaders);
  }

  @Transactional(readOnly = true)
  public LoaderOutput findById(Long loaderId) {
    Optional<Loader> loader = loaderRepository.findById(loaderId);
    if (loader.isPresent()) {
      return toModel(loader.get());
    }
    return null;
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long loaderId) {
    return loaderRepository.existsById(loaderId);
  }

  public void deleteById(Long loaderId) {
    loaderRepository.deleteById(loaderId);
  }

  private LoaderOutput toModel(Loader loader) {
    return mapper.map(loader, LoaderOutput.class);
  }

  private List<LoaderOutput> toCollectionDTO(List<Loader> loaders) {
    return loaders.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
