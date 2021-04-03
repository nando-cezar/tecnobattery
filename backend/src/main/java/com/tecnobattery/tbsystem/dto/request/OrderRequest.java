package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class OrderRequest implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private final Long id;
  @NotNull(message = "Cliente é obrigatório.")
  private final Long clientId;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Nome deve possuir no máximo 255 caracteres.")
  private final String description;
  @NotNull(message = "Preço é obrigatório.")
  private final Double price;
  @Valid
  @NotNull(message = "Produto é obrigatório.")
  private final Set<ProductRequest> products = new HashSet<>();
  @Valid
  @NotNull(message = "Usuário é obrigatório.")
  private final Set<UserRequest> users = new HashSet<>();

}
