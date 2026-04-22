package org.example;

public class Cancion extends Contenido {
    private String artista;
    private String album;

    public Cancion(String codigo, String titulo, int duracion, String artista, String album) {
        super(codigo, titulo, duracion);
        this.artista = artista;
        this.album = album;
    }

    @Override
    public void reproducir() {
        System.out.println("Canción: " + titulo +  " — " + artista);
    }
}
