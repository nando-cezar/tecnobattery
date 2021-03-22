package com.tecnobattery.tbsystem.auth.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserRole;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_user")
public class User implements UserDetails {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  private ApplicationUserRole role;
  private String password;
  private String username;
  private String email;
  private String phoneNumber;
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private boolean isEnabled;

  public User(ApplicationUserRole role, String password, String username, String email, String phoneNumber,
      boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
    this.role = role;
    this.password = password;
    this.username = username;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.isAccountNonExpired = isAccountNonExpired;
    this.isAccountNonLocked = isAccountNonLocked;
    this.isCredentialsNonExpired = isCredentialsNonExpired;
    this.isEnabled = isEnabled;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.role.getGrantedAuthorities();
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.isEnabled;
  }

}
