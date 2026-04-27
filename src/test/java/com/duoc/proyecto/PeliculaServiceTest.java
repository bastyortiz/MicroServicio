package com.duoc.proyecto;

import com.duoc.proyecto.model.Pelicula;
import com.duoc.proyecto.service.PeliculaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.duoc.proyecto.repository.PeliculaRepository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PeliculaServiceTest {

    @MockBean
    private PeliculaRepository repository;

    @Autowired
    private PeliculaService service;

    @Test
    void testBuscarPorId() {
        Pelicula peliculaMock = new Pelicula();
        peliculaMock.setId(1L);
        peliculaMock.setTitulo("Matrix");
        peliculaMock.setAño(1999);
        peliculaMock.setDirector("Wachowski");
        peliculaMock.setGenero("Ciencia Ficcion");
        peliculaMock.setSinopsis("Hackeo en Matrix");

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(peliculaMock));

        Pelicula resultado = service.obtenerPorId(1L);

        assertNotNull(resultado);
        assertEquals("Matrix", resultado.getTitulo());
        assertEquals(1999, resultado.getAño());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGuardarPelicula() {
        Pelicula peliculaNueva = new Pelicula();
        peliculaNueva.setTitulo("Gladiator");
        peliculaNueva.setAño(2000);
        peliculaNueva.setDirector("Ridley Scott");
        peliculaNueva.setGenero("Accion");
        peliculaNueva.setSinopsis("Luchando por libertad");

        Pelicula peliculaGuardada = new Pelicula();
        peliculaGuardada.setId(2L);
        peliculaGuardada.setTitulo("Gladiator");
        peliculaGuardada.setAño(2000);
        peliculaGuardada.setDirector("Ridley Scott");
        peliculaGuardada.setGenero("Accion");
        peliculaGuardada.setSinopsis("Luchando por libertad");

        when(repository.save(peliculaNueva)).thenReturn(peliculaGuardada);

        Pelicula resultado = service.guardar(peliculaNueva);

        assertNotNull(resultado);
        assertEquals("Gladiator", resultado.getTitulo());
        assertNotNull(resultado.getId());
        verify(repository, times(1)).save(peliculaNueva);
    }
}