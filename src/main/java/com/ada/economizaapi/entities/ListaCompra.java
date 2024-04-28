package com.ada.economizaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaCompra {

    private Long id;
    private Pessoa pessoa;
    private List<Produto> produtos = new ArrayList<>();

    public Mercado mercadoMaisEconomico() {
        if (produtos.isEmpty()) {
            return null;
        }

        Mercado mercadoMaisEconomico = produtos.get(0).getMelhorPreco().getMercado();
        for (Produto produto : produtos) {
            if (produto.getMelhorPreco().getPreco() < mercadoMaisEconomico.getMelhorPreco().getPreco()) {
                mercadoMaisEconomico = produto.getMelhorPreco().getMercado();
            }
        }

        return mercadoMaisEconomico;
    }
}

