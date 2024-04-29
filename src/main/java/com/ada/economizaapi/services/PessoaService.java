package com.ada.economizaapi.services;

import com.ada.economizaapi.entities.Pessoa;
import com.ada.economizaapi.entities.Pessoa;
import com.ada.economizaapi.exceptions.EntidadeNaoExisteException;
import com.ada.economizaapi.repositories.LocalizacaoRepository;
import com.ada.economizaapi.repositories.PessoaRepository;
import com.ada.economizaapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class PessoaService extends ServicoAbstrato<Pessoa, Long, PessoaRepository> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public PessoaService(PessoaRepository repository) {
        super(repository);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        if (pessoa.getLocalizacao() != null && pessoa.getLocalizacao().getId() == null) {
            localizacaoRepository.save(pessoa.getLocalizacao());
        }
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoa) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntidadeNaoExisteException();
        }
        if (pessoa.getLocalizacao() != null && pessoa.getLocalizacao().getId() == null) {
            localizacaoRepository.save(pessoa.getLocalizacao());
        }

        Pessoa pessoaExistente = this.findById(id)
                .orElseThrow(EntidadeNaoExisteException::new);

        copyProperties(pessoa, pessoaExistente, "id", "localizacao");

        if (pessoa.getLocalizacao() != null && pessoaExistente.getLocalizacao() != null) {
            copyProperties(pessoa.getLocalizacao(), pessoaExistente.getLocalizacao(), "id");
        }

        return pessoaRepository.save(pessoaExistente);
    }
}
