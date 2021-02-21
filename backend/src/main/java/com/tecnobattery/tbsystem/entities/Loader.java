package com.tecnobattery.tbsystem.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;;

@Entity
@Table(name = "tb_loader")
public class Loader implements Serializable {

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

  public Loader() {
  }

  public Loader(Long id, String brand, String model, Integer power, Integer voltage, Integer width, Integer height,
      Integer length, Integer weight, String imageUrl) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Loader)) {
      return false;
    }
    Loader loader = (Loader) o;
    return Objects.equals(id, loader.id) && Objects.equals(brand, loader.brand) && Objects.equals(model, loader.model)
        && Objects.equals(power, loader.power) && Objects.equals(voltage, loader.voltage)
        && Objects.equals(width, loader.width) && Objects.equals(height, loader.height)
        && Objects.equals(length, loader.length) && Objects.equals(weight, loader.weight)
        && Objects.equals(imageUrl, loader.imageUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, model, power, voltage, width, height, length, weight, imageUrl);
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", brand='" + getBrand() + "'" + ", model='" + getModel() + "'" + ", power='"
        + getPower() + "'" + ", voltage='" + getVoltage() + "'" + ", width='" + getWidth() + "'" + ", height='"
        + getHeight() + "'" + ", length='" + getLength() + "'" + ", weight='" + getWeight() + "'" + ", imageUrl='"
        + getImageUrl() + "'" + "}";
  }

}
