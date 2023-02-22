import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MappaPostiASedereTest {
    MappaPostiASedere mappa = new MappaPostiASedere((short)90, false);
    @BeforeEach  void setup() {
        mappa.setPostiOccupati((short)60);
    }
    @Test
    void definisciPostoTest() {
        assertEquals((short)61, mappa.definisciPosto());
        mappa.setPostiOccupati((short)61);
        assertEquals((short)62, mappa.definisciPosto());
        mappa.setPostiOccupati((short)62);
        assertEquals((short)87, mappa.getNumeroPostiDisponibili());
    }
}