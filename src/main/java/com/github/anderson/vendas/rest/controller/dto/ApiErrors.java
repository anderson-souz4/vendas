package com.github.anderson.vendas.rest.controller.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErrors {

    private List<String> errors;

    public ApiErrors(String messageErro) {
        this.errors = Arrays.asList(messageErro);
    }

}
