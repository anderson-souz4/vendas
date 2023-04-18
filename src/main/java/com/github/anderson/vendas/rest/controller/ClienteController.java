package com.github.anderson.vendas.rest.controller;


import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.obterClientePorId(id));
    }


    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }


}
