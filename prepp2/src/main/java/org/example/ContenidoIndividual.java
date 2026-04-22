package org.example;

public class ContenidoIndividual implements Componente{
    private Contenido contenido;

    public ContenidoIndividual(Contenido contenido) {
        this.contenido = contenido;
    }
    @Override
    public int getDuracion(){
        return contenido.getDuracion();
    }
    @Override
    public void mostrar(String indent){
        System.out.println(indent + contenido.getTitulo() + " ( " + contenido.getDuracion() + "s) ");
    }
}
