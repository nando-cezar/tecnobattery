package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.tecnobattery.tbsystem.entities.Client;

public class ClientDTO implements Serializable {

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
  private Set<OrderServiceDTO> orderServices = new HashSet<>();

  public ClientDTO() {
  }

  public ClientDTO(Long id, String cnpj, String name, String fantasyName, String phone, String email,
      AddressDTO address, Set<OrderServiceDTO> orderServices) {
    this.id = id;
    this.cnpj = cnpj;
    this.name = name;
    this.fantasyName = fantasyName;
    this.phone = phone;
    this.email = email;
    this.address = address;
    this.orderServices = orderServices;
  }

  public ClientDTO(Client entity) {
    this.id = entity.getId();
    this.cnpj = entity.getCnpj();
    this.name = entity.getName();
    this.fantasyName = entity.getFantasyName();
    this.phone = entity.getPhone();
    this.email = entity.getEmail();
    this.address = entity.getAddress();
    this.orderServices = entity.getOrderServices();
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

  public Set<OrderServiceDTO> getOrderServices() {
    return this.orderServices;
  }

  public void setOrderServices(Set<OrderServiceDTO> orderServices) {
    this.orderServices = orderServices;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof ClientDTO)) {
      return false;
    }
    ClientDTO clientDTO = (ClientDTO) o;
    return Objects.equals(id, clientDTO.id) && Objects.equals(cnpj, clientDTO.cnpj)
        && Objects.equals(name, clientDTO.name) && Objects.equals(fantasyName, clientDTO.fantasyName)
        && Objects.equals(phone, clientDTO.phone) && Objects.equals(email, clientDTO.email)
        && Objects.equals(address, clientDTO.address) && Objects.equals(orderServices, clientDTO.orderServices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cnpj, name, fantasyName, phone, email, address, orderServices);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", cnpj='" + getCnpj() + "'" + ", name='" + getName() + "'"
        + ", fantasyName='" + getFantasyName() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'"
        + ", address='" + getAddress() + "'" + ", orderServices='" + getOrderServices() + "'" + "}";
  }

}
