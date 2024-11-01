package org.example.bibliotecaAA.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private Set<Alquilan> alquilan;

    // Getters and setters
}
