package org.example.parcialuno.services;

import java.util.List;
import java.util.Optional;

import org.example.parcialuno.entities.Dna;
import org.example.parcialuno.repositories.DnaRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.stream.IntStream;

@Service
public class MutantService {
    protected DnaRepository dnaRepository;

    // Constructor que llama al servicio
    public MutantService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    // Método pedido por Magneto
    public boolean isMutant(String[] dna) throws Exception {
        // Validación de las letras
        boolean validar = validarLetrasADN(dna);

        if (!validar) {
            throw new IllegalArgumentException("DNA must only contain the characters A, T, G, C.");
        }

        // Verificación de que no sea mutante
        boolean isMutant = verificarMutante(dna);
        return isMutant;
    }

    // valida que las letras sean solamente A, T, G y C
    private boolean validarLetrasADN(String[] dna) {
        boolean resultado = IntStream.range(0, dna.length)
                .allMatch(i -> dna[i].matches("[ATGC]+"));

        return resultado;
    }

    // Método de verificación del mutante
    private boolean verificarMutante(String[] dna) {
        int n = dna.length;
        int count = 0;

        // Metodos que verifican la existencia del mutágeno
        count += verificacionHorizontal(dna, n);
        count += verificacionVertical(dna, n);
        count += verificacionDiagonalDerecha(dna, n);
        count += verificacionDiagonalIzquierda(dna, n);

        // Retorna falso si no hay mutágeno, verdadero si por lo menos en alguna de las
        // formas lo es
        return count > 1;
    }

    private int verificacionVertical(String[] dna, int n) {
        int cant = IntStream.range(0, n)
                .map(i -> verificacionSecuencia(IntStream.range(0, n)
                        .mapToObj(j -> dna[j].charAt(i))
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString()))
                .sum();
        return cant;
    }

    private int verificacionHorizontal(String[] dna, int n) {
        int cant = IntStream.range(0, n)
                .map(i -> verificacionSecuencia(dna[i]))
                .sum();
        return cant;
    }

    private int verificacionDiagonalDerecha(String[] dna, int n) {
        int cant = IntStream.range(0, n)
                .map(i -> verificacionSecuencia(IntStream.range(0, n - i)
                        .mapToObj(j -> dna[j].charAt(j + i))
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString()))
                .sum();

        return cant;
    }

    private int verificacionDiagonalIzquierda(String[] dna, int n) {
        int cant = IntStream.range(0, n)
                .map(i -> verificacionSecuencia(IntStream.range(0, n - i)
                        .mapToObj(j -> dna[j + i].charAt(j))
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString()))
                .sum();

        return cant;
    }

    //Método que realiza una verificación más simplificada de la secuencia
    //Está construido para no meter este mismo código en todos los otros métodos
    private int verificacionSecuencia(String sequence) {
        return (int) IntStream.range(0, sequence.length() - 3)
                .filter(i -> sequence.substring(i, i + 4).equals(sequence.substring(i, i + 1).repeat(4)))
                .count();
    }

    @Transactional
    public List<Dna> findAll() throws Exception {
        try {
            List<Dna> entities = dnaRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Dna findById(Long id) throws Exception {
        try {
            Optional<Dna> entitie = dnaRepository.findById(id);
            return entitie.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Dna save(String[] string, boolean isMutant) throws Exception {
        Dna dna = new Dna(String.join(",", string), isMutant);
        try {
            dna = dnaRepository.save(dna);
            return dna;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
