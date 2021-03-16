package com.tecnobattery.tbsystem.security.enumerated;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.tecnobattery.tbsystem.security.enumerated.ApplicationUserPermission.*;

public enum ApplicationUserRoles {
  EMPLOYEE(Sets.newHashSet()), ADMIN(Sets.newHashSet(EMPLOYEE_READ, EMPLOYEE_WRITE)),
  ADMINTRAINEE(Sets.newHashSet(EMPLOYEE_READ));

  private final Set<ApplicationUserPermission> permissions;

  ApplicationUserRoles(Set<ApplicationUserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<ApplicationUserPermission> getPermissions() {
    return permissions;
  }
}
