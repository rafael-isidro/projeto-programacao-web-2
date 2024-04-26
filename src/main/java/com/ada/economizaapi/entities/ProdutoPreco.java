package com.ada.economizaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPreco {

    private Long id;
    private Produto produto;
    private Mercado mercado;
    private Double preco;
    private LocalDate dataAtualizacao;

}
