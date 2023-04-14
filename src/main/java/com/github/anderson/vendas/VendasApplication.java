package com.github.anderson.vendas;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.repository.ClienteRepository;
import com.github.anderson.vendas.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class VendasApplication {

    @Bean
    public CommandLineRunner init (@Autowired ClienteService service){
        return args -> {

            service.salvar(new Cliente("Anderson"));
            service.salvar(new Cliente("Maria"));

            service.obterTodos().forEach(System.out::println);

            Cliente maria = service.obterPorNome("Maria");
            System.out.println("Foi a busca de Maria: " + maria);
            service.atualizar(new Cliente(1, "Anderson Silva"));
            service.obterTodos().forEach(System.out::println);

            service.deletar(2);
            service.obterTodos().forEach(System.out::println);





        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
