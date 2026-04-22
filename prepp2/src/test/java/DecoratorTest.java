import static org.junit.jupiter.api.Assertions.*;

import org.example.*;
import org.junit.jupiter.api.Test;

public class DecoratorTest {

    @Test
    public void debeReproducirConEfectos() {
        Contenido c = new Cancion("1", "Ayer y Hoy", 100, "A", "B");

        IReproductor r = new EqEfecto(
                new ReverbEfecto(
                        new ReproductorBase()
                )
        );

        assertDoesNotThrow(() -> r.reproducir(c));
    }
}