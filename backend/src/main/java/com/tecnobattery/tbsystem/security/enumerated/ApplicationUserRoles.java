package com.tecnobattery.tbsystem.security.enumerated;

import com.google.common.collect.Sets;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.tecnobattery.tbsystem.security.enumerated.ApplicationUserPermission.*;

public enum ApplicationUserRoles {
  EMPLOYEE(Sets.newHashSet()), ADMIN(Sets.newHashSet(GLOBAL_READ, GLOBAL_WRITE)),
  ADMINTRAINEE(Sets.newHashSet(GLOBAL_READ));

  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
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
