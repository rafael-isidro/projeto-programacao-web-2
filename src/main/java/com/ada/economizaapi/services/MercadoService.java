package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Mercado;
import com.ada.economizaapi.exceptions.EntidadeNaoExisteException;
import com.ada.economizaapi.repositories.LocalizacaoRepository;
import com.ada.economizaapi.repositories.MercadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class MercadoService extends ServicoAbstrato<Mercado, Long, MercadoRepository> {

    public MercadoService(MercadoRepository repository) {
        super(repository);
    }

    @Autowired
    private MercadoRepository mercadoRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Override
    public Mercado save(Mercado mercado) {
        if (mercado.getLocalizacao() != null && mercado.getLocalizacao().getId() == null) {
            localizacaoRepository.save(mercado.getLocalizacao());
        }
        return mercadoRepository.save(mercado);
    }

    @Override
    public Mercado update(Long id, Mercado mercado) {
        if (!mercadoRepository.existsById(id)) {
            throw new EntidadeNaoExisteException();
        }
        if (mercado.getLocalizacao() != null && mercado.getLocalizacao().getId() == null) {
            localizacaoRepository.save(mercado.getLocalizacao());
        }

        Mercado mercadoExistente = this.findById(id)
                .orElseThrow(EntidadeNaoExisteException::new);

        copyProperties(mercado, mercadoExistente, "id", "localizacao");

        if (mercado.getLocalizacao() != null && mercadoExistente.getLocalizacao() != null) {
            copyProperties(mercado.getLocalizacao(), mercadoExistente.getLocalizacao(), "id");
        }

        return mercadoRepository.save(mercadoExistente);
    }
}
