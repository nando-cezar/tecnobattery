package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;

public class BoardDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
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

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getPower() {
    return this.power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public Integer getVoltage() {
    return this.voltage;
  }

  public void setVoltage(Integer voltage) {
    this.voltage = voltage;
  }

  public Integer getWidth() {
    return this.width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return this.height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getLength() {
    return this.length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public Integer getWeight() {
    return this.weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
