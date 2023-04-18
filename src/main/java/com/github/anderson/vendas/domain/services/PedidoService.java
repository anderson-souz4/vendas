package com.github.anderson.vendas.domain.services;

import com.github.anderson.vendas.domain.entity.Pedido;
import com.github.anderson.vendas.rest.controller.dto.PedidoDTO;
import org.springframework.stereotype.Service;

public interface PedidoService {

    Pedido salvar(PedidoDTO pedido);
}