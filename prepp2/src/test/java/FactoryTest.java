import static org.junit.Assert.assertTrue;

import org.example.*;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void debeCrearCancion() {
        ContenidoFactory factory = new CancionFactory();
        Contenido c = factory.crearContenido("1", "Love", 200, "C", "Peace");
        assertTrue(c instanceof Cancion);
    }

    @Test
    public void debeCrearPodcast() {
        ContenidoFactory factory = new PodcastFactory();
        Contenido c = factory.crearContenido("2", "Luz y Gravedad", 300, "Kelly Martinez", "10");
        assertTrue(c instanceof Podcast);
    }

    @Test
    public void debeCrearAudiolibro() {
        ContenidoFactory factory = new AudioLibroFactory();
        Contenido c = factory.crearContenido("3", "El Principe", 1000, "Nicolas Maquiavelo", "Luis Ramirez");
        assertTrue(c instanceof Audiolibro);
    }
}
