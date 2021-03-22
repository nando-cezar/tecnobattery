package com.tecnobattery.tbsystem.tools.config;

import com.tecnobattery.tbsystem.tools.ToolConvertIdObject;
import com.tecnobattery.tbsystem.tools.ToolModelMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolsConfig {

  @Bean
  public ToolModelMapper toolModelMapper() {
    return new ToolModelMapper();
  }

  @Bean
  public ToolConvertIdObject toolConvertIdObject() {
    return new ToolConvertIdObject();
  }
}
