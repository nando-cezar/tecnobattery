package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.Optional;

import com.tecnobattery.tbsystem.dto.output.LoaderOutput;
import com.tecnobattery.tbsystem.entities.Loader;
import com.tecnobattery.tbsystem.exception.BusinessException;
import com.tecnobattery.tbsystem.repositories.LoaderRepository;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoaderService {

  @Autowired
  private LoaderRepository loaderRepository;

  @Autowired
  private ToolModelMapper toolModelMapper;

  public LoaderOutput save(Loader loader, boolean identifier) {

    if (!identifier) {

      Loader loaderExists = loaderRepository.findByModel(loader.getModel());

      if (loaderExists != null && !loaderExists.equals(loader)) {
        throw new BusinessException("Já existe uma carregador cadastrada com este modelo.");
      }
    }
    return toolModelMapper.toModel(loaderRepository.save(loader), LoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public List<LoaderOutput> findAll() {
    List<Loader> loaders = loaderRepository.findAll();
    return toolModelMapper.toCollection(loaders, LoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public LoaderOutput findById(Long loaderId) {
    Optional<Loader> loader = loaderRepository.findById(loaderId);
    if (loader.isPresent()) {
      return toolModelMapper.toModel(loader.get(), LoaderOutput.class);
    }
    return toolModelMapper.toModel(loader.orElseThrow(() -> new BusinessException("Loader: não encontrada.")),
        LoaderOutput.class);
  }

  @Transactional(readOnly = true)
  public boolean existsById(Long loaderId) {
    return loaderRepository.existsById(loaderId);
  }

  public void deleteById(Long loaderId) {
    loaderRepository.deleteById(loaderId);
  }
}
