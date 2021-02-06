package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -2516530140242266515L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String fantasyName;
  private String cnpj;
  private String phone;
  private String email;

  @ManyToMany
  @JoinTable(name = "tb_client_request", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "request_id"))
  private Set<Request> requests = new HashSet<>();

  public Client() {
  }

  public Client(Long id, String name, String fantasyName, String cnpj, String phone, String email) {
    this.id = id;
    this.name = name;
    this.fantasyName = fantasyName;
    this.cnpj = cnpj;
    this.phone = phone;
    this.email = email;
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

  public Set<Request> getRequests() {
    return this.requests;
  }

  public void setRequests(Set<Request> requests) {
    this.requests = requests;
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
        && Objects.equals(requests, client.requests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, fantasyName, cnpj, phone, email, requests);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", fantasyName='" + getFantasyName() + "'"
        + ", cnpj='" + getCnpj() + "'" + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'"
        + ", requests='" + getRequests() + "'" + "}";
  }

}
