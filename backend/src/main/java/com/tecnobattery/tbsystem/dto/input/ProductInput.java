package com.tecnobattery.tbsystem.dto.input;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class ProductInput implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  @Size(max = 20, message = "Nome deve possuir no máximo 20 caracteres.")
  private String name;
  @NotNull(message = "Potência é obrigatório em watts.")
  @Range(min = 1, max = 100000, message = "A potência varia entre 1w e 100000w.")
  private Integer power;
  @NotNull(message = "Capacidade é obrigatório em mA.")
  @Range(min = 100, max = 20000, message = "A capacidade varia entre 100mA e 20000mA.")
  private Integer capacity;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 10000, message = "A tensão varia entre 1v e 10000v.")
  private Integer voltage;
  @NotNull(message = "Preço é obrigatório.")
  private Double price;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Nome deve possuir no máximo 255 caracteres.")
  private String description;
  @NotBlank(message = "URL da imagem se encontra em branco ou inválido.")
  private String imageUrl;

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

}
