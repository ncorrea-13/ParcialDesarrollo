package org.example.parcialuno.dto;

import lombok.Data;

@Data
public class DtoDnaOutput {

    //DTO de la salida a mostrar

    // Devuelve true si es mutante. False si no lo es
    private boolean mutante;

    public DtoDnaOutput(boolean mutante) {
        this.mutante = mutante;
    }
}
