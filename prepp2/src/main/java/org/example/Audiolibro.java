package org.example;

public class Audiolibro extends Contenido {
    private String autor;
    private String narrador;

    public Audiolibro(String codigo, String titulo, int duracion, String autor, String narrador) {
        super(codigo, titulo, duracion);
        this.autor = autor;
        this.narrador = narrador;
    }

    @Override
         public void reproducir(){
            System.out.println("AudioLibro: "+titulo+ " --- "+autor + "--- Narrado por: " + narrador);
        }
    }

