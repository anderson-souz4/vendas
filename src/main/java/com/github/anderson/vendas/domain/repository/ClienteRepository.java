package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByNomeLike(String nome);


}
