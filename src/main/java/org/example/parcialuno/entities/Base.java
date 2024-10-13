package org.example.parcialuno.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Base implements Serializable {

    //Entidad genérica por si se necestian más entidades a futuro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
