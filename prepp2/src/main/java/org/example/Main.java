package org.example;

public class Main {

    public static void main(String[] args) {

        // ===== SINGLETON =====
        SonicWave app = SonicWave.getInstance();

        Usuario premium = new Usuario("U1", "Ana", Usuario.TipoSuscripcion.PREMIUM);
        Usuario free    = new Usuario("U2", "Luis", Usuario.TipoSuscripcion.FREE);

        app.iniciarSesion(premium);


        // ===== FACTORY =====
        ContenidoFactory cancionF = new CancionFactory();
        ContenidoFactory libroF   = new AudioLibroFactory();

        Contenido c1 = cancionF.crearContenido("C1", "Song", 200, "Artista", "Album");
        Contenido c2 = libroF.crearContenido("A1", "Libro", 1000, "Autor", "Narrador");


        // ===== COMPOSITE =====
        Playlist lista = new Playlist("Mi lista");
        lista.agregar(new ContenidoIndividual(c1));
        lista.agregar(new ContenidoIndividual(c2));

        System.out.println("Duración total: " + lista.getDuracion());


        // ===== DECORATOR =====
        IReproductor r = new ReverbEfecto(new ReproductorBase());


        // ===== PROXY =====
        IReproductor proxy = new ProxyReproductor(r, free);


        // ===== PRUEBA =====
        System.out.println("\nIntento usuario FREE:");
        proxy.reproducir(c2); // audiolibro → bloqueado

        System.out.println("\nReproduce canción:");
        proxy.reproducir(c1);
    }
}
