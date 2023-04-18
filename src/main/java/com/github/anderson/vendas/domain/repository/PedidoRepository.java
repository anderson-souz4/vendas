package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.entity.Pedido;
import com.github.anderson.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

    @Query("select p from Pedido p join fetch p.cliente join fetch p.itens where p.id = :id")
    Optional<Pedido> findByIdFetchItens(Integer id);

}
