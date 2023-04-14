package com.github.anderson.vendas;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@SpringBootApplication
@Configuration
public class VendasApplication {

    @Bean
    public CommandLineRunner init (@Autowired ClienteRepository repository){
        return args -> {

            repository.salvar(new Cliente("Anderson"));
            repository.salvar(new Cliente("Maria"));

            repository.obterTodos().forEach(System.out::println);

            repository.atualizar(new Cliente(1, "Anderson Silva"));
            repository.obterTodos().forEach(System.out::println);

            repository.deletar(2);
            repository.obterTodos().forEach(System.out::println);





        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
