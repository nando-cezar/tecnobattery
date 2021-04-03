package com.tecnobattery.tbsystem.dto.response;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserRole;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserResponse implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private ApplicationUserRole role;
  private String password;
  private String username;
  private Set<TelephoneResponse> telephones = new HashSet<>();
  private Set<EmailResponse> emails = new HashSet<>();
  private boolean isAccountNonExpired;
  private boolean isAccountNonLocked;
  private boolean isCredentialsNonExpired;
  private boolean isEnabled;

}
