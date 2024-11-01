package org.example.bibliotecaAA.repository;

import org.example.bibliotecaAA.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
