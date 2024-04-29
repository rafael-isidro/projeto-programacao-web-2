package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.ProdutoPreco;
import com.ada.economizaapi.repositories.ProdutoPrecoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoPrecoService extends ServicoAbstrato<ProdutoPreco, Long, ProdutoPrecoRepository>{

    public ProdutoPrecoService(ProdutoPrecoRepository repository) {
        super(repository);
    }
}
