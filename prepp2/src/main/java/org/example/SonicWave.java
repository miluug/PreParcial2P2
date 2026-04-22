package org.example;

public class SonicWave {
    private Contenido contenidoActual;
    private static SonicWave instance;
    private Usuario usuarioActivo;

    private SonicWave (){

    }
    public static SonicWave getInstance(){
        if(instance == null){
            instance = new SonicWave();
        }
        return instance;
    }

    public void iniciarSesion(Usuario u) {
        this.usuarioActivo = u;
        System.out.println("Sesión iniciada: " + u.getNombre()+ "(" + u.getSuscripcion() + ")");
    }

    public Usuario getUsuarioActual() {
        return usuarioActivo;
    }
    public void reproducir(Contenido c) {
        this.contenidoActual = c;
        c.reproducir();
    }
}
