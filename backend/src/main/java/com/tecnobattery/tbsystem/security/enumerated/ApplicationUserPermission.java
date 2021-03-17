package com.tecnobattery.tbsystem.security.enumerated;

public enum ApplicationUserPermission {

  GLOBAL_READ("global:read"), GLOBAL_WRITE("global:write");

  private final String permission;

  ApplicationUserPermission(String permission) {
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }
}
