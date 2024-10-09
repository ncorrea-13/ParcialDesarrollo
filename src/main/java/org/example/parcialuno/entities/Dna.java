package org.example.parcialuno.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table
@Data
@AllArgsConstructor
public class Dna extends Base {

    private String ADN;

    // Devuelve true si es mutante. False si no lo es
    private boolean mutante;

}
