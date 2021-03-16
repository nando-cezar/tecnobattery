package com.tecnobattery.tbsystem.security.config;

import java.util.Arrays;

import com.tecnobattery.tbsystem.security.enumerated.ApplicationUserRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  private Environment env;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
      http.headers().frameOptions().disable();
    }

    http.cors().and().csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll().antMatchers("/api/**")
        .hasRole(ApplicationUserRoles.EMPLOYEE.name()).antMatchers("/management/api/**")
        .hasAnyRole(ApplicationUserRoles.ADMIN.name(), ApplicationUserRoles.ADMINTRAINEE.name()).anyRequest()
        .authenticated().and().httpBasic();

  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {

    UserDetails userEmployee = User.builder().username("userEmployee").password(passwordEncoder.encode("passworde"))
        .roles(ApplicationUserRoles.EMPLOYEE.name()).build();

    UserDetails userAdmin = User.builder().username("userAdmin").password(passwordEncoder.encode("passworda"))
        .roles(ApplicationUserRoles.ADMIN.name()).build();

    UserDetails userAdminTrainne = User.builder().username("userAdminTrainee")
        .password(passwordEncoder.encode("passworda")).roles(ApplicationUserRoles.ADMINTRAINEE.name()).build();

    return new InMemoryUserDetailsManager(userEmployee, userAdmin, userAdminTrainne);
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
    configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
