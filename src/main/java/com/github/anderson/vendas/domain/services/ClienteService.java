package com.github.anderson.vendas.domain.services;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deletar(Cliente cliente) {
        repository.delete(cliente);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }

    public Cliente atualizar(Cliente cliente) {
        if (!repository.findById(cliente.getId()).isPresent()) {
            throw new RuntimeException("Cliente não encontrado");
        }
        return repository.save(cliente);
    }

    public List<Cliente> obterTodos() {
        return repository.findAll();
    }


    public Cliente obterPorNome(String nome){
        System.out.println("Buscando pelo nome: " + nome);
        return repository.findByNomeLike(nome);
    }






}
