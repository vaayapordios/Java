package org.example.bibliotecaAA.service;

import org.example.bibliotecaAA.model.Alquilan;
import org.example.bibliotecaAA.repository.AlquilanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilanService {
    private final AlquilanRepository alquilanRepository;

    public AlquilanService(AlquilanRepository alquilanRepository) {
        this.alquilanRepository = alquilanRepository;
    }

    public List<Alquilan> getAllAlquilan() {
        return alquilanRepository.findAll();
    }

    public Optional<Alquilan> getAlquilanById(Long id) {
        return alquilanRepository.findById(id);
    }

    public Alquilan saveAlquilan(Alquilan alquilan) {
        return alquilanRepository.save(alquilan);
    }

    public void deleteAlquilan(Long id) {
        alquilanRepository.deleteById(id);
    }
}
