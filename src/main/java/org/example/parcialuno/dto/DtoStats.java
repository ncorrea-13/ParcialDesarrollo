package org.example.parcialuno.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DtoStats {

    @JsonProperty("count_mutant_dna")
    private double countMutantDna;

    @JsonProperty("count_human_dna")
    private double countHumanDna;

    private double ratio;
}
