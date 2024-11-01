package org.example.bibliotecaAA.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private int anioPublicacion;

    @OneToMany(mappedBy = "libro")
    private Set<Alquilan> alquilan;

    // Getters and setters
}
