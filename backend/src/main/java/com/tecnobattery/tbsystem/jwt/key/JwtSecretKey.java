package com.tecnobattery.tbsystem.jwt.key;

import javax.crypto.SecretKey;

import com.tecnobattery.tbsystem.jwt.config.JwtConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtSecretKey {

  private final JwtConfig jwtConfig;

  @Autowired
  public JwtSecretKey(JwtConfig jwtConfig) {
    this.jwtConfig = jwtConfig;
  }

  @Bean
  public SecretKey secretKey() {
    return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
  }
}
