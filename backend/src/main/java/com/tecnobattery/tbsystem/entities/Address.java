package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
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

  public Address(String postalCode, String publicPlace, String complement, String neighborhood, String city,
      String state) {
    this.postalCode = postalCode;
    this.publicPlace = publicPlace;
    this.complement = complement;
    this.neighborhood = neighborhood;
    this.city = city;
    this.state = state;
  }

}
