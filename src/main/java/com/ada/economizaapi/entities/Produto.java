package com.ada.economizaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private String marca;
    private String descricao;
    private List<ProdutoPreco> produtoPrecos = new ArrayList<>();

}
