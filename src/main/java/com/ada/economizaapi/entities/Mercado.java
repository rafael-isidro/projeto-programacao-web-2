package com.ada.economizaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mercado {

    private Long id;
    private String nome;
    private Localizacao localizacao;
    private List<ProdutoPreco> produtoPreco = new ArrayList<>();

}
