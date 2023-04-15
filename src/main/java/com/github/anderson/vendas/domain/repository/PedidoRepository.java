package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.entity.Pedido;
import com.github.anderson.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
