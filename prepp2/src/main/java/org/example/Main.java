package org.example;
import org.example.*;

public class Main {

    public static void main(String[] args) {

        // ===== SINGLETON =====
        SonicWave global = SonicWave.getInstance();

        Usuario carolina = new Usuario("U001", "Carolina", Usuario.TipoSuscripcion.PREMIUM);
        Usuario juan     = new Usuario("U002", "Juan",     Usuario.TipoSuscripcion.FREE);

        global.iniciarSesion(carolina);

        // ===== FACTORY METHOD =====
        ContenidoFactory cancionF    = new CancionFactory();
        ContenidoFactory podcastF    = new PodcastFactory();
        ContenidoFactory audiolibroF = new AudioLibroFactory();

        Contenido c1 = cancionF.crearContenido("C01", "Feeling Good",    230, "Nina Simone", "I Put a Spell");
        Contenido c2 = cancionF.crearContenido("C02", "Hotel California", 391, "Eagles",      "Hotel California");
        Contenido c3 = podcastF.crearContenido("P01", "El Método Lenny",  1800, "Lenny",      "45");
        Contenido c4 = audiolibroF.crearContenido("A01", "Cien Años de Soledad", 75000, "García Márquez", "J. Serrat");

        // ===== COMPOSITE =====
        Playlist favoritas = new Playlist("Favoritas");
        favoritas.agregar(new ContenidoIndividual(c1));
        favoritas.agregar(new ContenidoIndividual(c2));

        Playlist aprender = new Playlist("Aprendizaje");
        aprender.agregar(new ContenidoIndividual(c3));
        aprender.agregar(new ContenidoIndividual(c4));

        Playlist miSemana = new Playlist("Mi semana");
        miSemana.agregar(favoritas);   // playlist anidada
        miSemana.agregar(aprender);    // playlist anidada

        miSemana.mostrar("");
        System.out.println("Duración total: " + miSemana.getDuracion() + " segundos");

        // ===== DECORATOR + PROXY =====
        IReproductor paraCarolina = construirReproductor(carolina, true, true, false);
        IReproductor paraJuan     = construirReproductor(juan,     true, false, true);

        System.out.println("\n--- Carolina (PREMIUM) reproduce un audiolibro ---");
        paraCarolina.reproducir(c4);

        System.out.println("\n--- Juan (FREE) intenta un audiolibro (bloqueado) ---");
        paraJuan.reproducir(c4);

        System.out.println("\n--- Juan (FREE) escucha una canción (con anuncio) ---");
        paraJuan.reproducir(c1);
    }

    static IReproductor construirReproductor(Usuario u, boolean eq, boolean reverb, boolean d8) {

        IReproductor r = new ReproductorBase();

        if (eq)     r = new EqEfecto(r);
        if (reverb) r = new ReverbEfecto(r);
        if (d8)     r = new Efecto8d(r);

        return new ProxyReproductor(r, u);
    }
}