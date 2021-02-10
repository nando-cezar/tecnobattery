package com.tecnobattery.tbsystem.dto;

import java.util.Objects;

public class ClientDTO {

  private Long id;
  private String cnpj;
  private String name;
  private String fantasyName;
  private String phone;
  private String email;
  private AddressDTO address;

  public ClientDTO() {
  }

  public ClientDTO(Long id, String cnpj, String name, String fantasyName, String phone, String email,
      AddressDTO address) {
    this.id = id;
    this.cnpj = cnpj;
    this.name = name;
    this.fantasyName = fantasyName;
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
        && Objects.equals(address, clientDTO.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cnpj, name, fantasyName, phone, email, address);
  }

}
