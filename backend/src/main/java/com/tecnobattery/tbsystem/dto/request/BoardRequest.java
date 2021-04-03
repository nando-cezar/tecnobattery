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
public class BoardRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotBlank(message = "Marca se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private final String brand;
  @NotBlank(message = "Modelo se encontra em branco ou inválido.")
  @Size(max = 60, message = "Marca deve possuir no máximo 60 caracteres.")
  private final String model;
  @NotNull(message = "Potência é obrigatório em watts.")
  @Range(min = 1, max = 1000, message = "A potência varia entre 1w e 1000w.")
  private final Integer power;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 100, message = "A tensão varia entre 1v e 100v.")
  private final Integer voltage;
  @NotNull(message = "Largura é obrigatório em mm.")
  @Range(min = 10, max = 300, message = "A largura varia entre 10mm e 300mm.")
  private final Integer width;
  @NotNull(message = "Altura é obrigatório em mm.")
  @Range(min = 10, max = 100, message = "A altura varia entre 10mm e 100mm.")
  private final Integer height;
  @NotNull(message = "Profundidade é obrigatório em mm.")
  @Range(min = 10, max = 300, message = "A profundidade varia entre 10mm e 300mm.")
  private final Integer length;
  @NotNull(message = "Peso é obrigatório em grama.")
  @Range(min = 10, max = 2000, message = "O peso varia entre 10g e 2000g.")
  private final Integer weight;
  @NotBlank(message = "URL da imagem se encontra em branco ou inválido.")
  private final String imageUrl;

}
