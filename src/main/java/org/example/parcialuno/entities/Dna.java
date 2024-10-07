package org.example.parcialuno.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secuencia;

    //Devuelve true si es mutante. False si no lo es
    private boolean mutante;

    public Dna(String secuencia, boolean mutante){
        this.secuencia = secuencia;
        this.mutante = mutante;
    }
}
