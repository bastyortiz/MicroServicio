package com.duoc.proyecto.controller;

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.repository.PeliculaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/peliculas") 
public class PeliculaController {

    private final PeliculaRepository repository;

    public PeliculaController(PeliculaRepository repository) {
        this.repository = repository;
    }

    @GetMapping 
    public List<Pelicula> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}") 
    public Pelicula getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}