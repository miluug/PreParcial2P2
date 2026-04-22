import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import org.example.SonicWave;
import org.junit.Test;

public class SonicWaveTest {

        @Test
        public void debeRetornarLaMismaInstancia() {
            SonicWave s1 = SonicWave.getInstance();
            SonicWave s2 = SonicWave.getInstance();

            assertSame(s1, s2);
        }

        @Test
        public void noDebeSerNull() {
            SonicWave s = SonicWave.getInstance();
            assertNotNull(s);
        }
}
