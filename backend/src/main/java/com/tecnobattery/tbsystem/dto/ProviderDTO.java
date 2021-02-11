package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.Provider;

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

  public ProviderDTO() {
  }

  public ProviderDTO(Long id, String cnpj, String name, String fantasyName, String phone, String email,
      AddressDTO address, Set<ManagementBatteryDTO> managementBatterys, Set<ManagementBoardDTO> managementBoards,
      Set<ManagementLoaderDTO> managementLoaders) {
    this.id = id;
    this.cnpj = cnpj;
    this.name = name;
    this.fantasyName = fantasyName;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.managementBatterys = managementBatterys;
    this.managementBoards = managementBoards;
    this.managementLoaders = managementLoaders;
  }

  public ProviderDTO(Provider entity) {
    this.id = entity.getId();
    this.cnpj = entity.getCnpj();
    this.name = entity.getName();
    this.fantasyName = entity.getFantasyName();
    this.phone = entity.getPhone();
    this.email = entity.getEmail();
    this.address = entity.getAddress();
    this.managementBatterys = entity.getManagementBatterys();
    this.managementBoards = entity.getManagementBoards();
    this.managementLoaders = entity.getManagementLoaders();
  }

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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ProviderDTO)) {
      return false;
    }
    ProviderDTO providerDTO = (ProviderDTO) o;
    return Objects.equals(id, providerDTO.id) && Objects.equals(cnpj, providerDTO.cnpj)
        && Objects.equals(name, providerDTO.name) && Objects.equals(fantasyName, providerDTO.fantasyName)
        && Objects.equals(phone, providerDTO.phone) && Objects.equals(email, providerDTO.email)
        && Objects.equals(address, providerDTO.address)
        && Objects.equals(managementBatterys, providerDTO.managementBatterys)
        && Objects.equals(managementBoards, providerDTO.managementBoards)
        && Objects.equals(managementLoaders, providerDTO.managementLoaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cnpj, name, fantasyName, phone, email, address, managementBatterys, managementBoards,
        managementLoaders);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", cnpj='" + getCnpj() + "'" + ", name='" + getName() + "'"
        + ", fantasyName='" + getFantasyName() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'"
        + ", address='" + getAddress() + "'" + ", managementBatterys='" + getManagementBatterys() + "'"
        + ", managementBoards='" + getManagementBoards() + "'" + ", managementLoaders='" + getManagementLoaders() + "'"
        + "}";
  }

}
