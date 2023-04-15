package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.ItemPedido;
import com.github.anderson.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
