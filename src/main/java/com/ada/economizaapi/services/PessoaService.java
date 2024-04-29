package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Pessoa;
import com.ada.economizaapi.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends ServicoAbstrato<Pessoa, Long, PessoaRepository>{

    public PessoaService(PessoaRepository repository) {
        super(repository);
    }
}
