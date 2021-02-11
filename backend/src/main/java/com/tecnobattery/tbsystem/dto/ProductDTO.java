package com.tecnobattery.tbsystem.dto;

import java.util.Objects;

public class ProductDTO {

  private Long id;
  private String name;
  private Integer power;
  private Integer capacity;
  private Integer voltage;
  private Double price;
  private String description;
  private String imageUrl;

  public ProductDTO() {
  }

  public ProductDTO(Long id, String name, Integer power, Integer capacity, Integer voltage, Double price,
      String description, String imageUrl) {
    this.id = id;
    this.name = name;
    this.power = power;
    this.capacity = capacity;
    this.voltage = voltage;
    this.price = price;
    this.description = description;
    this.imageUrl = imageUrl;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPower() {
    return this.power;
  }

  public void setPower(Integer power) {
    this.power = power;
  }

  public Integer getCapacity() {
    return this.capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public Integer getVoltage() {
    return this.voltage;
  }

  public void setVoltage(Integer voltage) {
    this.voltage = voltage;
  }

  public Double getPrice() {
    return this.price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    if (!(o instanceof ProductDTO)) {
      return false;
    }
    ProductDTO productDTO = (ProductDTO) o;
    return Objects.equals(id, productDTO.id) && Objects.equals(name, productDTO.name)
        && Objects.equals(power, productDTO.power) && Objects.equals(capacity, productDTO.capacity)
        && Objects.equals(voltage, productDTO.voltage) && Objects.equals(price, productDTO.price)
        && Objects.equals(description, productDTO.description) && Objects.equals(imageUrl, productDTO.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, power, capacity, voltage, price, description, imageUrl);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", power='" + getPower() + "'"
        + ", capacity='" + getCapacity() + "'" + ", voltage='" + getVoltage() + "'" + ", price='" + getPrice() + "'"
        + ", description='" + getDescription() + "'" + ", imageUrl='" + getImageUrl() + "'" + "}";
  }

}
