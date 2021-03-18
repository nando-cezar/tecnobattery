package com.tecnobattery.tbsystem.security.config;

import java.util.concurrent.TimeUnit;

import com.tecnobattery.tbsystem.security.enumerated.ApplicationUserRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

  private final PasswordEncoder passwordEncoder;

  @Autowired
  public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*
     * http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
     * );
     */
    http.csrf().disable();
    http.authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll().anyRequest().authenticated();
    http.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/main", true).passwordParameter("password")
        .usernameParameter("username");
    http.rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).key("key")
        .rememberMeParameter("remember-me");
    http.logout().logoutUrl("/logout").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
        .clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID", "remember-me")
        .logoutSuccessUrl("/login");
  }

  @Override
  @Bean
  protected UserDetailsService userDetailsService() {

    UserDetails userEmployee = User.builder().username("userEmployee").password(passwordEncoder.encode("passworde"))
        .authorities(ApplicationUserRoles.EMPLOYEE.getGrantedAuthorities()).build();

    UserDetails userAdmin = User.builder().username("userAdmin").password(passwordEncoder.encode("passworda"))
        .authorities(ApplicationUserRoles.ADMIN.getGrantedAuthorities()).build();

    UserDetails userAdminTrainne = User.builder().username("userAdminTrainee")
        .password(passwordEncoder.encode("passworda"))
        .authorities(ApplicationUserRoles.ADMINTRAINEE.getGrantedAuthorities()).build();

    return new InMemoryUserDetailsManager(userEmployee, userAdmin, userAdminTrainne);
  }
}
