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
@Table(name = "tb_board")
public class Board implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String brand;
  private String model;
  private Integer power;
  private Integer voltage;
  private Integer width;
  private Integer height;
  private Integer length;
  private Integer weight;
  private String imageUrl;

  public Board(String brand, String model, Integer power, Integer voltage, Integer width, Integer height,
      Integer length, Integer weight, String imageUrl) {
    this.brand = brand;
    this.model = model;
    this.power = power;
    this.voltage = voltage;
    this.width = width;
    this.height = height;
    this.length = length;
    this.weight = weight;
    this.imageUrl = imageUrl;
  }

}
