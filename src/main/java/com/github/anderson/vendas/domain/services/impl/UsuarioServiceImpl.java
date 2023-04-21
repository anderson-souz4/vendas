package com.github.anderson.vendas.domain.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!username.equals("anderson")) {
            throw new UsernameNotFoundException("Usuário não encontrado na base de dados");
        }

        return User
                .builder()
                .username("anderson")
                .password(encoder.encode("123"))
                .roles("USER", "ADMIN")
                .build();
    }
}
