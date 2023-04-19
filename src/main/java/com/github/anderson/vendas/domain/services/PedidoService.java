package com.github.anderson.vendas.domain.services;

import com.github.anderson.vendas.domain.entity.Pedido;
import com.github.anderson.vendas.domain.enums.StatusPedido;
import com.github.anderson.vendas.rest.controller.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedido);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
