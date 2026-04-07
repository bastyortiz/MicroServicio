package com.duoc.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "PELICULAS")
public class Pelicula {
    @Id
    private Long id;
    private String titulo;
    
    @Column(name = "ANIO") 
    private int año;
    
    private String director;
    private String genero;
    private String sinopsis;

    public Pelicula() {}

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
}