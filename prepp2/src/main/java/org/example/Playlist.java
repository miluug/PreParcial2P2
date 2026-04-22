package org.example;

import java.util.LinkedList;

public class Playlist implements Componente {
    public String nombre;
    public LinkedList<Componente> hijos = new LinkedList<>();

    public Playlist(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Componente c) {
        hijos.add(c);
    }

    public void quitar(Componente c) {
        hijos.remove(c);
    }

    @Override
    public int getDuracion() {
        int total = 0;
        for (Componente c : hijos) {
            total += c.getDuracion();
        }
        return total;
    }
    @Override
    public void mostrar(String indent) {
        System.out.println(indent + "Playlist: " + nombre);
        for (Componente c : hijos) {
            c.mostrar(indent + " ");
        }
    }
}
