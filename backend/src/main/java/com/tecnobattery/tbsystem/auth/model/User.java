package com.tecnobattery.tbsystem.auth.model;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserRoles;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
  private ApplicationUserRoles role;
  private String password;
  private String username;
  private String email;
  private String phoneNumber;
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private boolean isEnabled;

  public User() {
  }

  public User(Long id, ApplicationUserRoles role, String password, String username, String email, String phoneNumber,
      boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
    this.id = id;
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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ApplicationUserRoles getRole() {
    return this.role;
  }

  public void setRole(ApplicationUserRoles role) {
    this.role = role;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public boolean isIsAccountNonExpired() {
    return this.isAccountNonExpired;
  }

  public boolean getIsAccountNonExpired() {
    return this.isAccountNonExpired;
  }

  public void setIsAccountNonExpired(boolean isAccountNonExpired) {
    this.isAccountNonExpired = isAccountNonExpired;
  }

  public boolean isIsAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  public boolean getIsAccountNonLocked() {
    return this.isAccountNonLocked;
  }

  public void setIsAccountNonLocked(boolean isAccountNonLocked) {
    this.isAccountNonLocked = isAccountNonLocked;
  }

  public boolean isIsCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  public boolean getIsCredentialsNonExpired() {
    return this.isCredentialsNonExpired;
  }

  public void setIsCredentialsNonExpired(boolean isCredentialsNonExpired) {
    this.isCredentialsNonExpired = isCredentialsNonExpired;
  }

  public boolean isIsEnabled() {
    return this.isEnabled;
  }

  public boolean getIsEnabled() {
    return this.isEnabled;
  }

  public void setIsEnabled(boolean isEnabled) {
    this.isEnabled = isEnabled;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(id, user.id) && Objects.equals(role, user.role) && Objects.equals(password, user.password)
        && Objects.equals(username, user.username) && Objects.equals(email, user.email)
        && Objects.equals(phoneNumber, user.phoneNumber) && isAccountNonExpired == user.isAccountNonExpired
        && isAccountNonLocked == user.isAccountNonLocked && isCredentialsNonExpired == user.isCredentialsNonExpired
        && isEnabled == user.isEnabled;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, role, password, username, email, phoneNumber, isAccountNonExpired, isAccountNonLocked,
        isCredentialsNonExpired, isEnabled);
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

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", role='" + getRole() + "'" + ", password='" + getPassword() + "'"
        + ", username='" + getUsername() + "'" + ", email='" + getEmail() + "'" + ", phoneNumber='" + getPhoneNumber()
        + "'" + ", isAccountNonExpired='" + isIsAccountNonExpired() + "'" + ", isAccountNonLocked='"
        + isIsAccountNonLocked() + "'" + ", isCredentialsNonExpired='" + isIsCredentialsNonExpired() + "'"
        + ", isEnabled='" + isIsEnabled() + "'" + "}";
  }

}
