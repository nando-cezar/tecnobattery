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
public class AddressRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "CEP se encontra em branco ou inválido.")
    @Size(max = 9, message = "CEP deve possuir no máximo 9 caracteres.")
    private final String postalCode;
    @NotBlank(message = "Logradouro se encontra em branco ou inválido.")
    @Size(max = 255, message = "Logradouro deve possuir no máximo 255 caracteres.")
    private final String publicPlace;
    @NotBlank(message = "Complemento se encontra em branco ou inválido.")
    @Size(max = 255, message = "Complemento deve possuir no máximo 255 caracteres.")
    private final String complement;
    @NotBlank(message = "Bairro se encontra em branco ou inválido.")
    @Size(max = 100, message = "Bairro deve possuir no máximo 255 caracteres.")
    private final String neighborhood;
    @NotBlank(message = "Cidade se encontra em branco ou inválido.")
    @Size(max = 100, message = "Cidade deve possuir no máximo 255 caracteres.")
    private final String city;
    @NotBlank(message = "Estado se encontra em branco ou inválido.")
    @Size(max = 100, message = "Estado deve possuir no máximo 255 caracteres.")
    private final String state;

}
