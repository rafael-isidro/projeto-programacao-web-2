package com.ada.economizaapi.services;

import com.ada.economizaapi.exceptions.EntidadeJaExisteException;
import com.ada.economizaapi.exceptions.EntidadeNaoExisteException;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class ServicoAbstrato<E, ID, R extends JpaRepository<E, ID>> {

    private final R repository;

    public ServicoAbstrato(R repository) {
        this.repository = repository;
    }

    public boolean exists(E entity) {
        return this.repository.exists(Example.of(entity));
    }

    public boolean existsById(ID id) {
        return this.repository.existsById(id);
    }

    public E save(E entity) {
        if (this.exists(entity)) {
            throw new EntidadeJaExisteException();
        }
        return this.repository.save(entity);
    }

    public List<E> saveAll(Iterable<? extends E> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Optional<E> findById(ID id) {
        return this.repository.findById(id);
    }

    public List<E> findAll() {
        return this.repository.findAll();
    }

    public E update(E entity) {
        if (!this.exists(entity)) {
            throw new EntidadeNaoExisteException();
        }
        return this.repository.save(entity);
    }

    public E update(ID id, E entity) {
        if (!this.existsById(id)) {
            throw new EntidadeNaoExisteException();
        }
        return this.repository.save(entity);
    }

    public void delete(E entity) {
        this.repository.delete(entity);
    }

    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }

}
