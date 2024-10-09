package org.example.parcialuno.services;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean validarADN(String[] dna) {
        boolean res1 = validarCuadradoADN(dna);
        boolean res2 = validarLetrasADN(dna);
        boolean res3 = validarLetrasATGC(dna);
        boolean res4 = validarADNUnicaLetra(dna);

        return res1 && res2 && res3 && res4;
    }

    // valida que las letras sean solamente A, T, G y C
    public boolean validarLetrasATGC(String[] dna) {
        boolean resultado = IntStream.range(0, dna.length)
                .allMatch(i -> dna[i].matches("[ATGC]+"));

        return resultado;
    }

    public boolean validarCuadradoADN(String[] dna) {
        int tamanio = dna.length;
        boolean resultado = Arrays.stream(dna).allMatch(row -> row.length() == tamanio);
        return resultado;
    }

    public boolean validarLetrasADN(String[] dna) {
        boolean resultado = Arrays.stream(dna).noneMatch(row -> row.matches(".*\\d+.*"));
        return resultado;
    }

    public boolean validarADNUnicaLetra(String[] dna) {
        boolean resultado = Arrays.stream(dna)
                .noneMatch(row -> row.chars().allMatch(ch -> ch == dna[0].charAt(0)));
        return resultado;
    }

}