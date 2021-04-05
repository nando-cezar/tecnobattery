package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class CategoryRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotBlank(message = "Nome se encontra em branco ou inválido.")
  @Size(max = 100, message = "Nome deve possuir no máximo 100 caracteres.")
  private final String name;
}
