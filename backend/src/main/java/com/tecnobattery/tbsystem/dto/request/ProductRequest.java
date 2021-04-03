package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
