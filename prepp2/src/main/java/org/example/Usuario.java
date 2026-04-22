package org.example;


import lombok.Getter;

@Getter
public class Usuario {
    public enum TipoSuscripcion {FREE, PREMIUM}

    private String id;
    private String nombre;
    private TipoSuscripcion suscripcion;

    public Usuario(String id, String nombre, TipoSuscripcion suscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.suscripcion = suscripcion;
    }

    public boolean esPremium() {
        return suscripcion == TipoSuscripcion.PREMIUM;
    }


    public static IReproductor construirReproductor(Usuario u, boolean eq, boolean reverb,
                                                    boolean d8) {
        IReproductor r = new ReproductorBase();
        if (eq) r = new EqEfecto(r);
        if (reverb) r = new ReverbEfecto(r);
        if (d8) r = new Efecto8d(r);
        // Envolvemos con el Proxy para control de acceso
        return new ProxyReproductor(r, u);
    }
}