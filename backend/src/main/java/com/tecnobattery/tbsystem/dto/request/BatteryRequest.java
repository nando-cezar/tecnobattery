package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class BatteryRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotBlank(message = "Marca se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private final String brand;
  @NotBlank(message = "Modelo se encontra em branco ou inválido.")
  @Size(max = 60)
  private final String model;
  @NotNull(message = "Capacidade é obrigatório em mA.")
  @Range(min = 100, max = 20000, message = "A capacidade varia entre 100mA e 20000mA.")
  private final Integer capacity;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 10, message = "A tensão varia entre 1v e 10v.")
  private final Integer voltage;
  @NotNull(message = "Diâmetro é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "O diâmetro varia entre 10mm e 100mm.")
  private final Integer diameter;
  @NotNull(message = "Altura é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "A altura varia entre 10mm e 100mm.")
  private final Integer height;
  @NotNull(message = "Peso é obrigatório em grama.")
  @Range(min = 10, max = 2000, message = "O peso varia entre 10g e 2000g.")
  private final Integer weight;
  @NotBlank(message = "URL da imagem se encontra em branco ou inválido.")
  private final String imageUrl;

}
