package com.duoc.proyecto.controller; // Ajustado a tu ruta

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.service.PeliculaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Long id) {
        return peliculaService.obtenerPorId(id);
    }
}