package org.example.parcialuno.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DtoStats {

    //DTO de estadísticas a mostrar

    private double countMutantDna;

    private double countHumanDna;

    private double ratio;
}
