package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Produto;
import com.ada.economizaapi.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends ServicoAbstrato<Produto, Long, ProdutoRepository>{

    public ProdutoService(ProdutoRepository repository) {
        super(repository);
    }
}
