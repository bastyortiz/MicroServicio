package com.duoc.proyecto.controller;

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.service.PeliculaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public CollectionModel<EntityModel<Pelicula>> getAll() {
        List<EntityModel<Pelicula>> peliculas = peliculaService.obtenerTodas().stream()
                .map(pelicula -> EntityModel.of(pelicula,
                        linkTo(methodOn(PeliculaController.class).getById(pelicula.getId())).withSelfRel(),
                        linkTo(methodOn(PeliculaController.class).getAll()).withRel("peliculas")))
                .collect(Collectors.toList());

        Link selfLink = linkTo(methodOn(PeliculaController.class).getAll()).withSelfRel();

        return CollectionModel.of(peliculas, selfLink);
    }

    @GetMapping("/{id}")
    public EntityModel<Pelicula> getById(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.obtenerPorId(id);
        
        return EntityModel.of(pelicula,
                linkTo(methodOn(PeliculaController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(PeliculaController.class).getAll()).withRel("peliculas"));
    }

    @PostMapping
    public ResponseEntity<com.duoc.proyecto.controller.dto.PeliculaResponse> crear(@RequestBody Pelicula pelicula) {
        Pelicula peliculaGuardada = peliculaService.guardar(pelicula);
        com.duoc.proyecto.controller.dto.PeliculaResponse response = 
            new com.duoc.proyecto.controller.dto.PeliculaResponse("Pelicula creada correctamente", peliculaGuardada);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
