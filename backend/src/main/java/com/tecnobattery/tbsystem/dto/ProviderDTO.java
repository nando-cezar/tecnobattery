package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProviderDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String cnpj;
  private String name;
  private String fantasyName;
  private String phone;
  private String email;
  private AddressDTO address;
  private Set<ManagementBatteryDTO> managementBatterys = new HashSet<>();
  private Set<ManagementBoardDTO> managementBoards = new HashSet<>();
  private Set<ManagementLoaderDTO> managementLoaders = new HashSet<>();

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFantasyName() {
    return this.fantasyName;
  }

  public void setFantasyName(String fantasyName) {
    this.fantasyName = fantasyName;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public AddressDTO getAddress() {
    return this.address;
  }

  public void setAddress(AddressDTO address) {
    this.address = address;
  }

  public Set<ManagementBatteryDTO> getManagementBatterys() {
    return this.managementBatterys;
  }

  public void setManagementBatterys(Set<ManagementBatteryDTO> managementBatterys) {
    this.managementBatterys = managementBatterys;
  }

  public Set<ManagementBoardDTO> getManagementBoards() {
    return this.managementBoards;
  }

  public void setManagementBoards(Set<ManagementBoardDTO> managementBoards) {
    this.managementBoards = managementBoards;
  }

  public Set<ManagementLoaderDTO> getManagementLoaders() {
    return this.managementLoaders;
  }

  public void setManagementLoaders(Set<ManagementLoaderDTO> managementLoaders) {
    this.managementLoaders = managementLoaders;
  }
}
