package org.example.parcialuno.dto;

import java.util.List;

public class DtoDna {

    //El DTO permite encapsular el JSON enviado
    private List<String> dna;

    public List<String> getDna() {
        return dna;
    }

    public void setDna(List<String> dna) {
        this.dna = dna;
    }
}
