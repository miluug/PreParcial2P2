package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public abstract class Contenido {

    protected String codigo;
    protected String titulo;
    protected int duracion;

    public abstract void reproducir();

}
