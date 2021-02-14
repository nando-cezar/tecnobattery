package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String cnpj;
  private String name;
  private String fantasyName;
  private String phone;
  private String email;
  @OneToOne(cascade = CascadeType.ALL)
  private Address address;

  public Client() {
  }

  public Client(Long id, String cnpj, String name, String fantasyName, String phone, String email, Address address) {
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

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Client)) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(id, client.id) && Objects.equals(name, client.name)
        && Objects.equals(fantasyName, client.fantasyName) && Objects.equals(cnpj, client.cnpj)
        && Objects.equals(phone, client.phone) && Objects.equals(email, client.email)
        && Objects.equals(address, client.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fantasyName, cnpj, phone, email, address);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", fantasyName='" + getFantasyName() + "'"
        + ", cnpj='" + getCnpj() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'" + ", address='"
        + getAddress() + "'" + "}";
  }

}
