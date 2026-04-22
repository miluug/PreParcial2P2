import static org.junit.jupiter.api.Assertions.*;

import org.example.*;
import org.junit.jupiter.api.Test;

public class ProxyTest {

    @Test
    public void usuarioPremiumPuedeReproducirTodo() {
        Usuario u = new Usuario("1", "Premium", Usuario.TipoSuscripcion.PREMIUM);
        IReproductor proxy = new ProxyReproductor(new ReproductorBase(), u);

        Contenido libro = new Audiolibro("1", "Libro", 1000, "Autor", "Narrador");

        assertDoesNotThrow(() -> proxy.reproducir(libro));
    }

    @Test
    public void usuarioFreeNoPuedeReproducirAudiolibro() {
        Usuario u = new Usuario("2", "Free", Usuario.TipoSuscripcion.FREE);
        ProxyReproductor proxy = new ProxyReproductor(new ReproductorBase(), u);

        Contenido libro = new Audiolibro("1", "Libro", 1000, "Autor", "Narrador");

        proxy.reproducir(libro);
        assertFalse(ProxyReproductor.ValidadorAcceso.puedeReproducir(u, libro));
    }

    @Test
    public void usuarioFreeTieneLimiteDeSaltos() {
        Usuario u = new Usuario("2", "Free", Usuario.TipoSuscripcion.FREE);
        ProxyReproductor proxy = new ProxyReproductor(new ReproductorBase(), u);

        proxy.saltar();
        proxy.saltar();
        proxy.saltar();

        assertFalse(proxy.puedeSaltar());
    }
}