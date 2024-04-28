package com.ada.economizaapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long id;
    private String nome;
    private Localizacao localizacao;
    private Double custoPorDistancia;

}
