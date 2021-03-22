package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  private Long id;
  @NotNull(message = "Cliente é obrigatório.")
  private Long clientId;
  @NotBlank(message = "Descrição se encontra em branco ou inválido.")
  @Size(max = 255, message = "Nome deve possuir no máximo 255 caracteres.")
  private String description;
  @NotNull(message = "Preço é obrigatório.")
  private Double price;
  @NotNull(message = "Produto é obrigatório.")
  private List<ProductRequest> products = new ArrayList<>();
  @NotNull(message = "Usuário é obrigatório.")
  private Set<UserRequest> users = new HashSet<>();

}
