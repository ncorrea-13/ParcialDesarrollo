package org.example.parcialuno.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DtoDnaInput {

    // El DTO permite encapsular el JSON enviado
    private List<String> dna;

    @JsonCreator
    public DtoDnaInput(@JsonProperty("dna") List<String> dna) {
        this.dna = dna;
    }
}
