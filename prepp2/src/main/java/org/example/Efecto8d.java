package org.example;

public class Efecto8d extends EfectoDecorator{
    public Efecto8d (IReproductor envuelto){
        super(envuelto);
    }

    @Override
    public void reproducir(Contenido c) {
        super.reproducir(c);
        System.out.println("Efecto 8D aplicado");
    }
}
