package com.tecnobattery.tbsystem.auth.enumerated;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tecnobattery.tbsystem.auth.enumerated.ApplicationUserPermission.*;

public enum ApplicationUserRole {
  EMPLOYEE(Sets.newHashSet()), ADMIN(Sets.newHashSet(GLOBAL_WRITE, GLOBAL_READ)),
  ADMINTRAINEE(Sets.newHashSet(GLOBAL_READ));

  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<ApplicationUserPermission> getPermissions() {
    return permissions;
  }

  public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
    Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
    permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return permissions;
  }
}
