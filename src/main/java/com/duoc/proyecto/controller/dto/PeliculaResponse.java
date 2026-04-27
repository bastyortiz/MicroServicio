package com.duoc.proyecto.controller.dto;

import com.duoc.proyecto.model.Pelicula;

public class PeliculaResponse {
    private String mensaje;
    private Pelicula pelicula;

    public PeliculaResponse(String mensaje, Pelicula pelicula) {
        this.mensaje = mensaje;
        this.pelicula = pelicula;
    }

    public String getMensaje() { return mensaje; }
    public Pelicula getPelicula() { return pelicula; }
}