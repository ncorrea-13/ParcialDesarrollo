package org.example.parcialuno.services;

import org.example.parcialuno.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    // Servicio para obtener las estadísticas
    public Map<String, Object> getStats() {
        double countMutantDna = dnaRepository.countMutantDna();
        double countHumanDna = dnaRepository.countHumanDna();
        double ratio;
        if (countHumanDna > 0) {
            ratio = countMutantDna / countHumanDna;
        } else {
            ratio = 0;
        }
        Map<String, Object> stats = new HashMap<>();
        stats.put("count_mutant_dna", countMutantDna);
        stats.put("count_human_dna", countHumanDna);
        stats.put("ratio", ratio);

        return stats;
    }
}
