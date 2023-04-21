package com.github.anderson.vendas.rest.controller;

import com.github.anderson.vendas.domain.entity.Usuario;
import com.github.anderson.vendas.domain.services.impl.UsuarioServiceImpl;
import com.github.anderson.vendas.rest.controller.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioDTO salvar(@RequestBody @Valid Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        usuarioService.salvar(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }
}
