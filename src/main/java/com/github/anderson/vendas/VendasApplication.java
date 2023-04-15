package com.github.anderson.vendas;

import com.github.anderson.vendas.domain.entity.Cliente;
import com.github.anderson.vendas.domain.entity.Pedido;
import com.github.anderson.vendas.domain.repository.ClienteRepository;
import com.github.anderson.vendas.domain.repository.PedidoRepository;
import com.github.anderson.vendas.domain.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@Configuration
public class VendasApplication {

    @Bean
    public CommandLineRunner init (@Autowired ClienteService service, @Autowired ClienteRepository clienteRepository ,@Autowired PedidoRepository pedidoRepository){
        return args -> {

            System.out.println("Salvando clientes");
            Cliente fulano = new Cliente("Anderson");
            service.salvar(fulano);

            Pedido pedido = new Pedido();
            pedido.setCliente(service.obterPorNome("Anderson"));
            pedido.setDataPedido(LocalDate.now());
            pedido.setTotal(BigDecimal.valueOf(100));

            pedidoRepository.save(pedido);

            System.out.println("--------------" );

//            Cliente cliente = clienteRepository.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

            pedidoRepository.findByCliente(fulano).forEach(System.out::println);






        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
