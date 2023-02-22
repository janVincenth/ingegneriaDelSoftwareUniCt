import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

class AirManagerTest {
    static AirManager airManager = AirManager.getInstance();

    @BeforeAll
    void setup() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        //airManager.creaArrayPrenotazioni();
        try {
            AirManager.effettuaPrenotazione(scanner);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Prenotazione p = new Prenotazione();
        //Cliente cliente = new Cliente("Mario", "Rossi", "QWERTY00A12A123A", p);
    }


    @Test
    void getPrenotazione() {
        ArrayList<Prenotazione> prenotazioni = airManager.getPrenotazioni();
        assertEquals(prenotazioni.size(), 0);
    }

    /*
    @Test
    void contattiNotNull() {
        assertNotNull(cliente.);
    }
    */
}