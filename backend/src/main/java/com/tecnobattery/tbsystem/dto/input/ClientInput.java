package com.tecnobattery.tbsystem.dto.input;

public class ClientInput {

  private String cnpj;
  private String name;
  private String fantasyName;
  private String phone;
  private String email;

  private String postalCode;
  private String publicPlace;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;

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

  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPublicPlace() {
    return this.publicPlace;
  }

  public void setPublicPlace(String publicPlace) {
    this.publicPlace = publicPlace;
  }

  public String getComplement() {
    return this.complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getNeighborhood() {
    return this.neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return this.state;
  }

  public void setState(String state) {
    this.state = state;
  }

}
