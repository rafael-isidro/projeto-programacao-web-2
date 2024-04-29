package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Mercado;
import com.ada.economizaapi.repositories.MercadoRepository;
import org.springframework.stereotype.Service;

@Service
public class MercadoService extends ServicoAbstrato<Mercado, Long, MercadoRepository>{

    public MercadoService(MercadoRepository repository) {
        super(repository);
    }
}
