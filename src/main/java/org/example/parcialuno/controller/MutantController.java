package org.example.parcialuno.controller;

import lombok.AllArgsConstructor;

import org.example.parcialuno.dto.DtoDnaInput;
import org.example.parcialuno.dto.DtoDnaOutput;
import org.example.parcialuno.services.MutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/mutant")
@AllArgsConstructor
public class MutantController {

    @Autowired
    private MutantService mutantService;

    // LLamado para obtener todos los ADN
    @GetMapping("")
    public ResponseEntity<?> getAll() throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mutantService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    // LLamado para obtener un ADN específico
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(mutantService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, porfavor intente más tarde\" \"}");
        }
    }

    // LLamado para el servicio de isMutant
    @PostMapping("")
    public ResponseEntity<?> isMutant(@RequestBody DtoDnaInput dnaRequest) throws Exception {
        // Creación del arreglo pasado desde el JSON
        String[] dna = dnaRequest.getDna().toArray(new String[0]);

        // Corroboración de que no sea mutante
        boolean isMutant = mutantService.isMutant(dna);

        mutantService.save(dna, isMutant);
        DtoDnaOutput output = new DtoDnaOutput(isMutant);

        if (isMutant) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(output);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"error\":\"Error\" \"}");
            }
        } else {
            try {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(output);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("{\"error\":\"Error\" \"}");
            }
        }
    }

}
