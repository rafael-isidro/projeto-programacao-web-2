package com.ada.economizaapi.repositories;

import com.ada.economizaapi.entities.ProdutoPreco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPrecoRepository extends JpaRepository<ProdutoPreco, Long> {
}
