package com.project.xmen.api.controller;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class XmenModel {
    @ApiModelProperty(notes = "Ejemplo de ADN.")
    @NotEmpty
    @NotBlank(message = "El ADN no puede ser nulo.")

    private String [] adn;

    public String[] getAdn() {
        return adn;
    }

    public void setAdn(String[] adn) {
        this.adn = adn;
    }

}
