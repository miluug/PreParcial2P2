package org.example;

public class Podcast extends Contenido {
    private String presentador;
    private int numeroEpisodio;

    public Podcast(String codigo, String titulo, int duracion, String presentador, int ep) {
        super(codigo, titulo, duracion);
        this.presentador = presentador;
        this.numeroEpisodio = ep;
    }

    @Override
    public void reproducir() {
        System.out.println("Podcast: " + titulo + "ep. " + numeroEpisodio);
    }
}

