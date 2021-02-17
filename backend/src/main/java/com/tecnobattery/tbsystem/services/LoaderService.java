package com.tecnobattery.tbsystem.services;

import java.util.List;
import java.util.stream.Collectors;

import com.tecnobattery.tbsystem.dto.LoaderDTO;
import com.tecnobattery.tbsystem.entities.Loader;
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

  public LoaderDTO save(String brand, String model, Integer power, Integer voltage, Integer width, Integer height,
      Integer length, String imageUrl) {
    Loader loader = new Loader();
    loader.setBrand(brand);
    loader.setModel(model);
    loader.setPower(power);
    loader.setVoltage(voltage);
    loader.setWidth(width);
    loader.setHeight(height);
    loader.setLength(length);
    loader.setImageUrl(imageUrl);

    return toModel(loaderRepository.save(loader));
  }

  @Transactional(readOnly = true)
  public List<LoaderDTO> findAll() {
    List<Loader> loaders = loaderRepository.findAll();
    return toCollectionDTO(loaders);
  }

  private LoaderDTO toModel(Loader loader) {
    return mapper.map(loader, LoaderDTO.class);
  }

  private List<LoaderDTO> toCollectionDTO(List<Loader> loaders) {
    return loaders.stream().map(x -> toModel(x)).collect(Collectors.toList());
  }
}
