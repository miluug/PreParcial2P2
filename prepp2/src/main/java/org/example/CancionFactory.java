package org.example;

public class CancionFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String codigo, String titulo, int duracion, String artista, String album) {
        return new Cancion(codigo, titulo, duracion, artista, album);
    }
}