package org.example.parcialuno.repositories;

import org.springframework.stereotype.Repository;
import org.example.parcialuno.entities.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    // Método para contar las secuencias de ADN que son mutantes
    @Query("SELECT COUNT(*) FROM Dna d WHERE d.mutante = true")
    long countMutantDna();

    // Método para contar las secuencias de ADN que no son mutantes
    @Query("SELECT COUNT(*) FROM Dna d WHERE d.mutante = false")
    long countHumanDna();
}
