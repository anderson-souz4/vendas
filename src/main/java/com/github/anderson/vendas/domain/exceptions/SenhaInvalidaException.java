package com.github.anderson.vendas.domain.exceptions;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {

        super("Senha inválida");
    }
}
