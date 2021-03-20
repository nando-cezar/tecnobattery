package com.tecnobattery.tbsystem.security.config;

import javax.crypto.SecretKey;

import com.tecnobattery.tbsystem.auth.service.UserService;
import com.tecnobattery.tbsystem.jwt.token.JwtTokenVerifier;
import com.tecnobattery.tbsystem.jwt.config.JwtConfig;
import com.tecnobattery.tbsystem.jwt.filter.JwtUsernameAndPasswordAuthenticationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  private final PasswordEncoder passwordEncoder;

  private final SecretKey secretKey;
  private final JwtConfig jwtConfig;

  @Autowired
  public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, SecretKey secretKey, JwtConfig jwtConfig) {
    this.passwordEncoder = passwordEncoder;
    this.secretKey = secretKey;
    this.jwtConfig = jwtConfig;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*
     * http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
     * );
     */
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig, secretKey));
    http.addFilterAfter(new JwtTokenVerifier(secretKey, jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class);
    http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll().anyRequest().authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(daoAuthenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder);
    provider.setUserDetailsService(userService);
    return provider;
  }
}
