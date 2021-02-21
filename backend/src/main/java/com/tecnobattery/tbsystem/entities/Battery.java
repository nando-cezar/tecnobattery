package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
  @NotBlank
  @Size(max = 60)
  private String brand;
  @NotBlank
  @Size(max = 60)
  private String model;
  private Integer capacity;
  private Integer voltage;
  private Integer diameter;
  private Integer height;
  @NotBlank
  private String imageUrl;

  public Battery() {
  }

  public Battery(Long id, String brand, String model, Integer capacity, Integer voltage, Integer diameter,
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
    if (!(o instanceof Battery)) {
      return false;
    }
    Battery battery = (Battery) o;
    return Objects.equals(id, battery.id) && Objects.equals(brand, battery.brand)
        && Objects.equals(model, battery.model) && Objects.equals(capacity, battery.capacity)
        && Objects.equals(voltage, battery.voltage) && Objects.equals(diameter, battery.diameter)
        && Objects.equals(height, battery.height) && Objects.equals(imageUrl, battery.imageUrl);
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
