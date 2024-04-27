package com.ada.economizaapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    private String descricao;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProdutoPreco> produtoPrecos = new ArrayList<>();

    public void addProdutoPreco(ProdutoPreco produtoPreco) {
        produtoPrecos.add(produtoPreco);
        produtoPreco.setProduto(this);
    }

    public void removeProdutoPreco(ProdutoPreco produtoPreco) {
        produtoPrecos.remove(produtoPreco);
        produtoPreco.setProduto(null);
    }
}
