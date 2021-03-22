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
public class CommentResquest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long id;
  @NotBlank(message = "Título se encontra em branco ou inválido.")
  @Size(max = 100, message = "Título deve possuir no máximo 100 caracteres.")
  private String title;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Descrição deve possuir no máximo 255 caracteres.")
  private String description;

}
