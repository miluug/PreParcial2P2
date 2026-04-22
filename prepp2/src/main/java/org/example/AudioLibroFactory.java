package org.example;

public class AudioLibroFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String codigo, String titulo, int duracion, String autor, String narrador) {
        return new Audiolibro(codigo, titulo, duracion, autor, narrador);
    }
}