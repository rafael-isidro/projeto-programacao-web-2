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
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    @OneToMany(mappedBy = "mercado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List

            <ProdutoPreco> produtoPrecos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void addProdutoPreco(ProdutoPreco produtoPreco) {
        produtoPrecos.add(produtoPreco);
        produtoPreco.setMercado(this);
    }

    public void removeProdutoPreco(ProdutoPreco produtoPreco) {
        produtoPrecos.remove(produtoPreco);
        produtoPreco.setMercado(null);
    }

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

    @Override
    public String toString() {
        return "Mercado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", localizacao=" + localizacao +
                '}';
    }
}




