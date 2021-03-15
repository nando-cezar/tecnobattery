package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class BatteryRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Marca se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private String brand;
  @NotBlank(message = "Modelo se encontra em branco ou inválido.")
  @Size(max = 60)
  private String model;
  @NotNull(message = "Capacidade é obrigatório em mA.")
  @Range(min = 100, max = 20000, message = "A capacidade varia entre 100mA e 20000mA.")
  private Integer capacity;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 10, message = "A tensão varia entre 1v e 10v.")
  private Integer voltage;
  @NotNull(message = "Diâmetro é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "O diâmetro varia entre 10mm e 100mm.")
  private Integer diameter;
  @NotNull(message = "Altura é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "A altura varia entre 10mm e 100mm.")
  private Integer height;
  @NotNull(message = "Peso é obrigatório em grama.")
  @Range(min = 10, max = 2000, message = "O peso varia entre 10g e 2000g.")
  private Integer weight;
  @NotBlank(message = "URL da imagem se encontra em branco ou inválido.")
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
