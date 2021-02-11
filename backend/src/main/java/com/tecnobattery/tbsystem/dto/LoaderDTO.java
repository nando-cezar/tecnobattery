package com.tecnobattery.tbsystem.dto;

import java.util.Objects;

public class LoaderDTO {

  private Long id;
  private String brand;
  private String model;
  private Integer power;
  private Integer voltage;
  private Integer width;
  private Integer height;
  private Integer length;
  private String imageUrl;

  public LoaderDTO() {
  }

  public LoaderDTO(Long id, String brand, String model, Integer power, Integer voltage, Integer width, Integer height,
      Integer length, String imageUrl) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.power = power;
    this.voltage = voltage;
    this.width = width;
    this.height = height;
    this.length = length;
    this.imageUrl = imageUrl;
  }

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

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof LoaderDTO)) {
      return false;
    }
    LoaderDTO loaderDTO = (LoaderDTO) o;
    return Objects.equals(id, loaderDTO.id) && Objects.equals(brand, loaderDTO.brand)
        && Objects.equals(model, loaderDTO.model) && Objects.equals(power, loaderDTO.power)
        && Objects.equals(voltage, loaderDTO.voltage) && Objects.equals(width, loaderDTO.width)
        && Objects.equals(height, loaderDTO.height) && Objects.equals(length, loaderDTO.length)
        && Objects.equals(imageUrl, loaderDTO.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, model, power, voltage, width, height, length, imageUrl);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", brand='" + getBrand() + "'" + ", model='" + getModel() + "'" + ", power='"
        + getPower() + "'" + ", voltage='" + getVoltage() + "'" + ", width='" + getWidth() + "'" + ", height='"
        + getHeight() + "'" + ", length='" + getLength() + "'" + ", imageUrl='" + getImageUrl() + "'" + "}";
  }

}
