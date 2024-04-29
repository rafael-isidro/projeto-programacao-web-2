package com.ada.economizaapi.controllers;

import com.ada.economizaapi.services.MercadoService;
import com.ada.economizaapi.entities.Mercado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

    @Autowired
    MercadoService mercadoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Mercado> findAll() {
            return mercadoService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Optional<Mercado> findById(@PathVariable Long id) {
            return mercadoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Mercado post(@RequestBody Mercado mercado) {
            return mercadoService.save(mercado);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Mercado update(@PathVariable Long id, @RequestBody Mercado mercado) {
            return mercadoService.update(id, mercado);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
           mercadoService.deleteById(id);
    }
}
