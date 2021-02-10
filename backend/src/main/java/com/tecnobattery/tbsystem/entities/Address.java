package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String postalCode;
  private String publicPlace;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;

  public Address() {
  }

  public Address(Long id, String postalCode, String publicPlace, String complement, String neighborhood, String city,
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
    if (!(o instanceof Address)) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(id, address.id) && Objects.equals(postalCode, address.postalCode)
        && Objects.equals(publicPlace, address.publicPlace) && Objects.equals(complement, address.complement)
        && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(city, address.city)
        && Objects.equals(state, address.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, postalCode, publicPlace, complement, neighborhood, city, state);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", postalCode='" + getPostalCode() + "'" + ", publicPlace='"
        + getPublicPlace() + "'" + ", complement='" + getComplement() + "'" + ", neighborhood='" + getNeighborhood()
        + "'" + ", city='" + getCity() + "'" + ", state='" + getState() + "'" + "}";
  }

}
