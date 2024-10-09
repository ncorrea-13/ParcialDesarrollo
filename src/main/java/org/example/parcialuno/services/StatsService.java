package org.example.parcialuno.services;

import org.example.parcialuno.dto.DtoStats;
import org.example.parcialuno.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    // Servicio para obtener las estadísticas
    public DtoStats getStats() {

        double countMutantDna = dnaRepository.countMutantDna();
        double countHumanDna = dnaRepository.countHumanDna();
        double ratio;
        if (countHumanDna > 0) {
            ratio = countMutantDna / countHumanDna;
        } else {
            ratio = 0;
        }
        DtoStats stats = new DtoStats(countMutantDna, countHumanDna, ratio);

        return stats;
    }
}
