package com.tecnobattery.tbsystem.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClientInput {

  private Long id;
  @NotBlank(message = "CNPJ se encontra em branco ou inválido.")
  @Size(max = 18, message = "CNPJ deve possuir no máximo 18 caracteres.")
  private String cnpj;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  private String name;
  @NotBlank(message = "Nome Fantasia se encontra em branco ou inválido.")
  private String fantasyName;
  @NotBlank(message = "Telefone se encontra em branco ou inválido.")
  @Size(max = 14, message = "Marca deve possuir no máximo 14 caracteres.")
  private String phone;
  @NotBlank(message = "E-mail se encontra em branco ou inválido.")
  @Email(message = "E-mail inválido.")
  private String email;
  @NotBlank(message = "CEP se encontra em branco ou inválido.")
  @Size(max = 9, message = "CEP deve possuir no máximo 9 caracteres.")
  private String postalCode;
  @NotBlank(message = "Logradouro se encontra em branco ou inválido.")
  @Size(max = 255, message = "Logradouro deve possuir no máximo 255 caracteres.")
  private String publicPlace;
  @NotBlank(message = "Complemento se encontra em branco ou inválido.")
  @Size(max = 255, message = "Complemento deve possuir no máximo 255 caracteres.")
  private String complement;
  @NotBlank(message = "Bairro se encontra em branco ou inválido.")
  @Size(max = 100, message = "Bairro deve possuir no máximo 255 caracteres.")
  private String neighborhood;
  @NotBlank(message = "Cidade se encontra em branco ou inválido.")
  @Size(max = 100, message = "Cidade deve possuir no máximo 255 caracteres.")
  private String city;
  @NotBlank(message = "Estado se encontra em branco ou inválido.")
  @Size(max = 100, message = "Estado deve possuir no máximo 255 caracteres.")
  private String state;

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
