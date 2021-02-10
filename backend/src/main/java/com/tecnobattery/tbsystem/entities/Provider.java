package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_provider")
public class Provider implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String fantasyName;
  private String cnpj;
  private String phone;
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;
  @OneToMany(mappedBy = "provider")
  private Set<ManagementBattery> managementBatterys = new HashSet<>();
  @OneToMany(mappedBy = "provider")
  private Set<ManagementBoard> managementBoards = new HashSet<>();
  @OneToMany(mappedBy = "provider")
  private Set<ManagementLoader> managementLoaders = new HashSet<>();

  public Provider() {
  }

  public Provider(Long id, String name, String fantasyName, String cnpj, String phone, String email, Address address) {
    this.id = id;
    this.name = name;
    this.fantasyName = fantasyName;
    this.cnpj = cnpj;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public String getCnpj() {
    return this.cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
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

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Set<ManagementBattery> getManagementBatterys() {
    return this.managementBatterys;
  }

  public void setManagementBatterys(Set<ManagementBattery> managementBatterys) {
    this.managementBatterys = managementBatterys;
  }

  public Set<ManagementBoard> getManagementBoards() {
    return this.managementBoards;
  }

  public void setManagementBoards(Set<ManagementBoard> managementBoards) {
    this.managementBoards = managementBoards;
  }

  public Set<ManagementLoader> getManagementLoaders() {
    return this.managementLoaders;
  }

  public void setManagementLoaders(Set<ManagementLoader> managementLoaders) {
    this.managementLoaders = managementLoaders;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Provider)) {
      return false;
    }
    Provider provider = (Provider) o;
    return Objects.equals(id, provider.id) && Objects.equals(name, provider.name)
        && Objects.equals(fantasyName, provider.fantasyName) && Objects.equals(cnpj, provider.cnpj)
        && Objects.equals(phone, provider.phone) && Objects.equals(email, provider.email)
        && Objects.equals(address, provider.address) && Objects.equals(managementBatterys, provider.managementBatterys)
        && Objects.equals(managementBoards, provider.managementBoards)
        && Objects.equals(managementLoaders, provider.managementLoaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fantasyName, cnpj, phone, email, address, managementBatterys, managementBoards,
        managementLoaders);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", fantasyName='" + getFantasyName() + "'"
        + ", cnpj='" + getCnpj() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'" + ", address='"
        + getAddress() + "'" + ", managementBatterys='" + getManagementBatterys() + "'" + ", managementBoards='"
        + getManagementBoards() + "'" + ", managementLoaders='" + getManagementLoaders() + "'" + "}";
  }

}
