
import static org.junit.jupiter.api.Assertions.*;

import org.example.Cancion;
import org.example.ContenidoIndividual;
import org.example.Playlist;
import org.junit.jupiter.api.Test;

    public class CompositeTest {

        @Test
        public void debeCalcularDuracionConSubPlaylists() {
            Playlist padre = new Playlist("Padre");

            Playlist hija = new Playlist("Hija");
            hija.agregar(new ContenidoIndividual(new Cancion("1", "S1", 100, "A", "B")));
            hija.agregar(new ContenidoIndividual(new Cancion("2", "S2", 200, "A", "B")));

            padre.agregar(hija);
            padre.agregar(new ContenidoIndividual(new Cancion("3", "S3", 300, "A", "B")));

            assertEquals(600, padre.getDuracion());
        }
    }
