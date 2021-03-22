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
@Table(name = "tb_battery")
public class Battery implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private String model;
  private Integer capacity;
  private Integer voltage;
  private Integer diameter;
  private Integer height;
  private Integer weight;
  private String imageUrl;

  public Battery(String brand, String model, Integer capacity, Integer voltage, Integer diameter, Integer height,
      Integer weight, String imageUrl) {
    this.brand = brand;
    this.model = model;
    this.capacity = capacity;
    this.voltage = voltage;
    this.diameter = diameter;
    this.height = height;
    this.weight = weight;
    this.imageUrl = imageUrl;
  }

}
