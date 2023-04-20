package com.github.anderson.vendas.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    @NotNull(message = "Informe o código do cliente")
    private Integer cliente;
    @NotNull(message = "Informe o total do pedido")
    private BigDecimal total;

    private List<ItemPedidoDTO> items;
}
