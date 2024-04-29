package com.ada.economizaapi.controllers;

import com.ada.economizaapi.services.PessoaService;
import com.ada.economizaapi.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Pessoa> findById(@PathVariable Long id) {
            return pessoaService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Pessoa post(@RequestBody Pessoa pessoa) {
            return pessoaService.save(pessoa);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
            return pessoaService.update(id, pessoa);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
            pessoaService.deleteById(id);
    }
}
