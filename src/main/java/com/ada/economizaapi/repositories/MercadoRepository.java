package com.ada.economizaapi.repositories;

import com.ada.economizaapi.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Long> {
}
