package com.github.anderson.vendas.domain.repository;

import com.github.anderson.vendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.login = :login")
    Optional<Usuario> findByLogin(String login);
}
