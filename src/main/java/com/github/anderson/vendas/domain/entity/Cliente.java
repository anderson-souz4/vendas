package com.github.anderson.vendas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100)
    @NotEmpty(message = "Campo nome obrigatório")
    private String nome;

    @NotEmpty(message = "Campo CPF obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;
}
