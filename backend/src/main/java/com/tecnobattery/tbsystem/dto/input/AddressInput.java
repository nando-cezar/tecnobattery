package com.tecnobattery.tbsystem.dto.input;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddressInput implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "CEP se encontra em branco ou inválido.")
    @Size(max = 9, message = "CEP deve possuir no máximo 9 caracteres.")
    private String postalCode;
    @NotBlank(message = "Logradouro se encontra em branco ou inválido.")
    @Size(max = 255, message = "Logradouro deve possuir no máximo 255 caracteres.")
    private String publicPlace;
    @NotBlank(message = "Complemento se encontra em branco ou inválido.")
    @Size(max = 255, message = "Complemento deve possuir no máximo 255 caracteres.")
    private String complement;
    @NotBlank(message = "Bairro se encontra em branco ou inválido.")
    @Size(max = 100, message = "Bairro deve possuir no máximo 255 caracteres.")
    private String neighborhood;
    @NotBlank(message = "Cidade se encontra em branco ou inválido.")
    @Size(max = 100, message = "Cidade deve possuir no máximo 255 caracteres.")
    private String city;
    @NotBlank(message = "Estado se encontra em branco ou inválido.")
    @Size(max = 100, message = "Estado deve possuir no máximo 255 caracteres.")
    private String state;

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPublicPlace() {
        return this.publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getComplement() {
        return this.complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
