package com.tecnobattery.tbsystem.dto.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class StockRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final Long id;
    @NotNull(message = "Fornecedor é obrigatório.")
    private final Long providerId;
    @NotNull(message = "Matéria-prima é obrigatório.")
    private final Long feedstockId;
    @NotBlank(message = "Quantidade inválida.")
    @Max(9999)
    @Min(1)
    private final Integer amount;

}
