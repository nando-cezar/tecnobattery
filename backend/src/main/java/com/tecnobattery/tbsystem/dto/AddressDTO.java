package com.tecnobattery.tbsystem.dto;

import java.util.Objects;

public class AddressDTO {

  private Long id;
  private String postalCode;
  private String publicPlace;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;

  public AddressDTO() {
  }

  public AddressDTO(Long id, String postalCode, String publicPlace, String complement, String neighborhood, String city,
      String state) {
    this.id = id;
    this.postalCode = postalCode;
    this.publicPlace = publicPlace;
    this.complement = complement;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof AddressDTO)) {
      return false;
    }
    AddressDTO addressDTO = (AddressDTO) o;
    return Objects.equals(id, addressDTO.id) && Objects.equals(postalCode, addressDTO.postalCode)
        && Objects.equals(publicPlace, addressDTO.publicPlace) && Objects.equals(complement, addressDTO.complement)
        && Objects.equals(neighborhood, addressDTO.neighborhood) && Objects.equals(city, addressDTO.city)
        && Objects.equals(state, addressDTO.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, postalCode, publicPlace, complement, neighborhood, city, state);
  }

}
