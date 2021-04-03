package com.tecnobattery.tbsystem.auth.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserRole;
import com.tecnobattery.tbsystem.entities.Email;
import com.tecnobattery.tbsystem.entities.Telephone;

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
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private boolean isEnabled;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "tb_user_telephone", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "telephone_id"))
  private Set<Telephone> telephones = new HashSet<>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "tb_user_email", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "email_id"))
  private Set<Email> emails = new HashSet<>();

  public User(ApplicationUserRole role, String password, String username, boolean isAccountNonExpired,
      boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled, Set<Telephone> telephones,
      Set<Email> emails) {
    this.role = role;
    this.password = password;
    this.username = username;
    this.isAccountNonExpired = isAccountNonExpired;
    this.isAccountNonLocked = isAccountNonLocked;
    this.isCredentialsNonExpired = isCredentialsNonExpired;
    this.isEnabled = isEnabled;
    this.telephones = telephones;
    this.emails = emails;
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
