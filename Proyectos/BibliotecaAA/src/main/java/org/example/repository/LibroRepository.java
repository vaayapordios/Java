package org.example.bibliotecaAA.repository;

import org.example.bibliotecaAA.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
