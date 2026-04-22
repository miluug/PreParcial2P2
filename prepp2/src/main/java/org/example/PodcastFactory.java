package org.example;

public class PodcastFactory extends ContenidoFactory {
    @Override
    public Contenido crearContenido(String codigo, String titulo, int duracion, String presentador, String numEp) {
        return new Podcast(codigo, titulo, duracion, presentador, Integer.parseInt(numEp));
    }
}