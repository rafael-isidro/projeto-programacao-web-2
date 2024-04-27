package com.ada.economizaapi.services;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class ServicoAbstrato<E, R extends JpaRepository<E, Long>> {

    private R repository;

    public ServicoAbstrato(R repository) {
        this.repository = repository;
    }

    public abstract boolean exists(E entity);

    public E save(E entity) {
        return this.repository.save(entity);
    }

    public List<E> saveAll(Iterable<? extends E> entities) {
        return StreamSupport.stream(entities.spliterator(), false)
                .map(this::save)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
