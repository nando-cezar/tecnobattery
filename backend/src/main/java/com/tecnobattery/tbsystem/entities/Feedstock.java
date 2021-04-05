package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "tb_feedstock")
public class Feedstock implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private String model;
  @ManyToOne
  private Category category;
  private Integer capacity;
  private Integer voltage;
  private Integer power;
  private Integer diameter;
  private Integer height;
  private Integer width;
  private Integer length;
  private Integer weight;
  private String imageUrl;
  private String description;

  public Feedstock(String brand, String model, Integer capacity, Integer voltage, Integer power, Integer diameter,
      Integer height, Integer width, Integer length, Integer weight, String imageUrl, String description) {
    this.brand = brand;
    this.model = model;
    this.capacity = capacity;
    this.voltage = voltage;
    this.power = power;
    this.diameter = diameter;
    this.height = height;
    this.width = width;
    this.length = length;
    this.weight = weight;
    this.imageUrl = imageUrl;
    this.description = description;
  }

}
