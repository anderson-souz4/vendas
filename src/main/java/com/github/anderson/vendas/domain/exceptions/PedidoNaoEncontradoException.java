package com.github.anderson.vendas.domain.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException() {
        super("Pedido não encontrado na base de dados.");
    }

}
