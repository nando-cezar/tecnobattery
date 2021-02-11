package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.Objects;

import com.tecnobattery.tbsystem.entities.Battery;

public class BatteryDTO implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  private String brand;
  private String model;
  private Integer capacity;
  private Integer voltage;
  private Integer diameter;
  private Integer height;
  private String imageUrl;

  public BatteryDTO() {
  }

  public BatteryDTO(Long id, String brand, String model, Integer capacity, Integer voltage, Integer diameter,
      Integer height, String imageUrl) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.capacity = capacity;
    this.voltage = voltage;
    this.diameter = diameter;
    this.height = height;
    this.imageUrl = imageUrl;
  }

  public BatteryDTO(Battery entity) {
    this.id = entity.getId();
    this.brand = entity.getBrand();
    this.model = entity.getModel();
    this.capacity = entity.getCapacity();
    this.voltage = entity.getVoltage();
    this.diameter = entity.getDiameter();
    this.height = entity.getHeight();
    this.imageUrl = entity.getImageUrl();
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

  public Integer getDiameter() {
    return this.diameter;
  }

  public void setDiameter(Integer diameter) {
    this.diameter = diameter;
  }

  public Integer getHeight() {
    return this.height;
  }

  public void setHeight(Integer height) {
    this.height = height;
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
    if (!(o instanceof BatteryDTO)) {
      return false;
    }
    BatteryDTO batteryDTO = (BatteryDTO) o;
    return Objects.equals(id, batteryDTO.id) && Objects.equals(brand, batteryDTO.brand)
        && Objects.equals(model, batteryDTO.model) && Objects.equals(capacity, batteryDTO.capacity)
        && Objects.equals(voltage, batteryDTO.voltage) && Objects.equals(diameter, batteryDTO.diameter)
        && Objects.equals(height, batteryDTO.height) && Objects.equals(imageUrl, batteryDTO.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, model, capacity, voltage, diameter, height, imageUrl);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", brand='" + getBrand() + "'" + ", model='" + getModel() + "'"
        + ", capacity='" + getCapacity() + "'" + ", voltage='" + getVoltage() + "'" + ", diameter='" + getDiameter()
        + "'" + ", height='" + getHeight() + "'" + ", imageUrl='" + getImageUrl() + "'" + "}";
  }

}