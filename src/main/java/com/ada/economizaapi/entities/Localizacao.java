package com.ada.economizaapi.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Objects;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coordenadas", nullable = false)
    @NotBlank
    private String coordenadas;

    public Localizacao(String coordenadas) {
        this.coordenadas = coordenadas;
    }
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localizacao that = (Localizacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
