package com.duoc.proyecto.service;

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<Pelicula> obtenerTodas() {
        return repository.findAll();
    }

    public Pelicula obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Pelicula guardar(Pelicula p) {
        return repository.save(p);
    }
}
