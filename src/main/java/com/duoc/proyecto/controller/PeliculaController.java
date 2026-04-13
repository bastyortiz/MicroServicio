package com.duoc.proyecto.controller;

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> getAll() {
        return peliculaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Pelicula getById(@PathVariable Long id) {
        return peliculaService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> crear(@RequestBody Pelicula pelicula) {
        Pelicula peliculaGuardada = peliculaService.guardar(pelicula);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", "Pelicula creada correctamente");
        response.put("pelicula", peliculaGuardada);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
