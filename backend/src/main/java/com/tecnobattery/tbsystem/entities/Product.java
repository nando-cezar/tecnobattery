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
@Table(name = "tb_product")
public class Product implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer power;
  private Integer capacity;
  private Integer voltage;
  private Double price;
  private String description;
  private String imageUrl;

  public Product(String name, Integer power, Integer capacity, Integer voltage, Double price, String description,
      String imageUrl) {
    this.name = name;
    this.power = power;
    this.capacity = capacity;
    this.voltage = voltage;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
  }

}
