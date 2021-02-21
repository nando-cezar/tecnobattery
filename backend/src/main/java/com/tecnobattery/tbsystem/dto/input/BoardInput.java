package com.tecnobattery.tbsystem.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class BoardInput {

  private Long id;
  @NotBlank(message = "Marca se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private String brand;
  @NotBlank(message = "Modelo se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private String model;
  @NotNull(message = "Potência é obrigatório em watts.")
  @Range(min = 1, max = 1000, message = "A potência varia entre 1w e 1000w.")
  private Integer power;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 100, message = "A tensão varia entre 1v e 100v.")
  private Integer voltage;
  @NotNull(message = "Largura é obrigatório em mm.")
  @Range(min = 10, max = 300, message = "A largura varia entre 10mm e 300mm.")
  private Integer width;
  @NotNull(message = "Altura é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "A altura varia entre 10mm e 100mm.")
  private Integer height;
  @NotNull(message = "Profundidade é obrigatório em mm.")
  @Range(min = 10, max = 300, message = "A profundidade varia entre 10mm e 300mm.")
  private Integer length;
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
