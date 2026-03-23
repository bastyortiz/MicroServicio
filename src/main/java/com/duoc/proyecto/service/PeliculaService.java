package com.duoc.proyecto.service;

import com.duoc.proyecto.model.Pelicula; 
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaService {
    private List<Pelicula> lista = new ArrayList<>();

    public PeliculaService() {
        lista.add(new Pelicula(1L, "Inception", 2010, "Christopher Nolan", "Sci-Fi", "Sueños dentro de sueños."));
        lista.add(new Pelicula(2L, "The Matrix", 1999, "Lana Wachowski", "Acción", "La realidad es una simulación."));
        lista.add(new Pelicula(3L, "Interstellar", 2014, "Christopher Nolan", "Sci-Fi", "Viaje a través de un agujero de gusano."));
        lista.add(new Pelicula(4L, "Gladiator", 2000, "Ridley Scott", "Acción", "Un general romano busca venganza."));
        lista.add(new Pelicula(5L, "Parasite", 2019, "Bong Joon-ho", "Drama", "Una familia pobre se infiltra en una rica."));
    }

    public List<Pelicula> obtenerTodas() {
        return lista;
    }

    public Pelicula obtenerPorId(Long id) {
        return lista.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}