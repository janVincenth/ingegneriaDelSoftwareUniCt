import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MappaPostiASedereTest {
    MappaPostiASedere mappa;
    @BeforeEach  void setup() {
        mappa = new MappaPostiASedere((short)90, false);

    }

    @Test
    void setPostiOccupatiTest(){
        mappa.setPostiOccupati((short)60);
        assertTrue(mappa.getPostiOccupati().get((short)60));
        assertEquals(90-1, mappa.getNumeroPostiDisponibili());
    }

    @Test
    void definisciPostoEconomyTest() {
        assertEquals((short)60, mappa.definisciPosto()); // quando tutti i posti a sedere sono liberi, il primo proposto è il 60
        mappa.setPostiOccupati((short)61); // occupo il posto 61
        assertEquals((short)60, mappa.definisciPosto()); //il 60 è rimasto ancora libero, quindi in ordine propongo proprio quello, prima di proporre il 62
        mappa.setPostiOccupati((short)62);
        assertEquals((short)88, mappa.getNumeroPostiDisponibili());
        mappa.setPostiOccupati((short)60); // occupo il posto 60
        mappa.getPostiOccupati().put((short)62, false); // libero il posto 62
        assertNotEquals((short)63, mappa.definisciPosto()); // non proporrò come posto il 63...
        assertEquals((short)62, mappa.definisciPosto()); // ... ma il 62, che è stato appena liberato


    }

    @Test
    void definisciPostoSecondaClasseTest() {
        int numeroTotalePosti = mappa.getPostiOccupati().size();
        // assegno tutti e 30 i posti in classe Economy
        for(int i=(numeroTotalePosti/3*2); i < numeroTotalePosti; i++) {
            mappa.setPostiOccupati((short)i);
        }

        assertEquals(60, mappa.getNumeroPostiDisponibili()); // ho assegnato 30 posti, quindi ne rimangono 90-30=60
        assertEquals((short)30, mappa.definisciPosto()); // se i posti in classe Economy sono tutti occupati, il primo posto proposto sarà il primo posto disponibile della Seconda classe, cioè il 30
        mappa.setPostiOccupati((short)31); // occupo il posto 31
        assertEquals((short)30, mappa.definisciPosto()); //il 30 è rimasto ancora libero, quindi in ordine propongo proprio quello, prima di proporre il 32
        mappa.setPostiOccupati((short)32);
        assertEquals((short)58, mappa.getNumeroPostiDisponibili());
        mappa.setPostiOccupati((short)30); // occupo il posto 30
        mappa.getPostiOccupati().put((short)32, false); // libero il posto 32
        assertNotEquals((short)33, mappa.definisciPosto()); // non proporrò come posto il 33...
        assertEquals((short)32, mappa.definisciPosto()); // ... ma il 32, che è stato appena liberato
    }

    @Test
    void definisciPostoPrimaClasseTest() {
        int numeroTotalePosti = mappa.getPostiOccupati().size();
        // assegno sia tutti i 30 posti in classe Economy sia tutti i 30 posti in Seconda classe
        for(int i=(numeroTotalePosti/3); i < numeroTotalePosti; i++) {
            mappa.setPostiOccupati((short)i);
        }

        assertEquals(30, mappa.getNumeroPostiDisponibili()); // ho assegnato 60 (30+30) posti, quindi ne rimangono 90-60=30
        assertEquals((short)0, mappa.definisciPosto()); // se i posti in classe Economy sono tutti occupati, il primo posto proposto sarà il primo posto disponibile della Prima classe, cioè il posto 0
        mappa.setPostiOccupati((short)1); // occupo il posto 1
        assertEquals((short)0, mappa.definisciPosto()); //il posto 0 è rimasto ancora libero, quindi in ordine propongo proprio quello, prima di proporre il 2
        mappa.setPostiOccupati((short)2);
        assertEquals((short)28, mappa.getNumeroPostiDisponibili());
        mappa.setPostiOccupati((short)0); // occupo il posto 0
        mappa.getPostiOccupati().put((short)2, false); // libero il posto 2
        assertNotEquals((short)3, mappa.definisciPosto()); // non proporrò come posto il 3...
        assertEquals((short)2, mappa.definisciPosto()); // ... ma il 2, che è stato appena liberato
    }
}