package com.ada.economizaapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "mercado")
    private List<ProdutoPreco> produtoPrecos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mercado mercado = (Mercado) o;
        return id != null && id.equals(mercado.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public ProdutoPreco getProdutoPreco(Produto produto) {
        for (ProdutoPreco produtoPreco : produtoPrecos) {
            if (produtoPreco.getProduto().equals(produto)) {
                return produtoPreco;
            }
        }
        return null;
    }
}

