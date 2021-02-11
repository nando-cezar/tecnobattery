package com.tecnobattery.tbsystem.dto;

import java.io.Serializable;
import java.util.Objects;

import com.tecnobattery.tbsystem.entities.Board;

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
  private String imageUrl;

  public BoardDTO() {
  }

  public BoardDTO(Long id, String brand, String model, Integer power, Integer voltage, Integer width, Integer height,
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

  public BoardDTO(Board entity) {
    this.id = entity.getId();
    this.brand = entity.getBrand();
    this.model = entity.getModel();
    this.power = entity.getPower();
    this.voltage = entity.getVoltage();
    this.width = entity.getWidth();
    this.height = entity.getHeight();
    this.length = entity.getLength();
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
    if (!(o instanceof BoardDTO)) {
      return false;
    }
    BoardDTO boardDTO = (BoardDTO) o;
    return Objects.equals(id, boardDTO.id) && Objects.equals(brand, boardDTO.brand)
        && Objects.equals(model, boardDTO.model) && Objects.equals(power, boardDTO.power)
        && Objects.equals(voltage, boardDTO.voltage) && Objects.equals(width, boardDTO.width)
        && Objects.equals(height, boardDTO.height) && Objects.equals(length, boardDTO.length)
        && Objects.equals(imageUrl, boardDTO.imageUrl);
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
