package com.ada.economizaapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ListaCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lista_compra_produto",
            joinColumns = @JoinColumn(name = "lista_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaCompra that = (ListaCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Mercado mercadoMaisEconomico(List<Mercado> mercados){
        Mercado mercadoMaisBarato = null;
        double menorValor = Double.MAX_VALUE;

        for(Mercado mercado : mercados){
            double valorTotal = 0;
            for(Produto produto : produtos){
                ProdutoPreco produtoPreco = mercado.getProdutoPreco(produto);
                if(produtoPreco != null){
                    valorTotal += produtoPreco.getPreco();
                }
            }
            if(valorTotal < menorValor){
                menorValor = valorTotal;
                mercadoMaisBarato = mercado;
            }
        }
        return mercadoMaisBarato;
    }
}

