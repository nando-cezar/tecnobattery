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

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  @Size(max = 20, message = "Nome deve possuir no máximo 20 caracteres.")
  private final String name;
  @NotNull(message = "Potência é obrigatório em watts.")
  @Range(min = 1, max = 100000, message = "A potência varia entre 1w e 100000w.")
  private final Integer power;
  @NotNull(message = "Capacidade é obrigatório em mA.")
  @Range(min = 100, max = 20000, message = "A capacidade varia entre 100mA e 20000mA.")
  private final Integer capacity;
  @NotNull(message = "Tensão é obrigatório em volts.")
  @Range(min = 1, max = 10000, message = "A tensão varia entre 1v e 10000v.")
  private final Integer voltage;
  @NotNull(message = "Preço é obrigatório.")
  private final Double price;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Nome deve possuir no máximo 255 caracteres.")
  private final String description;
  @NotBlank(message = "URL da imagem se encontra em branco ou inválido.")
  private final String imageUrl;

  @Override
  public String toString() {
    return String.valueOf(getId());
  }

}
