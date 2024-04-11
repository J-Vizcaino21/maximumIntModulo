package com.example.maximumintmodulo.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class RequestMaximumModulo {
    @NotNull(message = "maximumNumber cannot be null")
    @PositiveOrZero(message = "maximumNumber should be positive or zero")
    private Integer maximumNumber;
    @NotNull(message = "modulo cannot be null")
    @PositiveOrZero(message = "modulo should be positive or zero")
    private Integer modulo;
    @NotNull(message = "remainder cannot be null")
    @PositiveOrZero (message = "remainder should be positive or zero")
    private Integer remainder;

    public RequestMaximumModulo() {

    }
}
