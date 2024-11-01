package org.example.bibliotecaAA.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Alquilan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_LIBRO")
    private Libro libro;

    // Getters and setters
}
