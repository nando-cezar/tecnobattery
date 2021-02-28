package com.tecnobattery.tbsystem.core;

import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public ToolModelMapper toolModelMapper() {
    return new ToolModelMapper();
  }
}
