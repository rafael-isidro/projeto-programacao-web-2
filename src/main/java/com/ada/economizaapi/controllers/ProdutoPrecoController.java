package com.ada.economizaapi.controllers;

import com.ada.economizaapi.entities.ProdutoPreco;
import com.ada.economizaapi.services.ProdutoPrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto-preco")

public class ProdutoPrecoController {

    @Autowired
    ProdutoPrecoService produtoPrecoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<ProdutoPreco> findAll() {
        return this.produtoPrecoService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ProdutoPreco create(@RequestBody ProdutoPreco produtoPreco) {
        return this.produtoPrecoService.save(produtoPreco);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ProdutoPreco update(@PathVariable Long id, @RequestBody ProdutoPreco produtoPreco) {
        return this.produtoPrecoService.update(id, produtoPreco);
    }
}
