import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AirManagerTest {
    static AirManager airManager = AirManager.getInstance();

    @BeforeAll
    static void setup() {

    }


    @Test
    void cancellazioneEffettivaPrenotazione() {
        //ottimizzare chiamata prenotazioni
        ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
        Prenotazione prenotazioneDaTestare = new Prenotazione();
        prenotazioneDaTestare.setNumeroPrenotazione("1000");
        prenotazioni.add(prenotazioneDaTestare);
        assertEquals(1,prenotazioni.size());
        //int dimensionePrecedenteListaPrenotazioni = prenotazioni.size();
        AirManager.cancellazioneEffettivaPrenotazione(prenotazioneDaTestare, prenotazioni);
        assertEquals(0,prenotazioni.size());

    }

    @Test
    void verificaRimborso() {
        Volo voloTest = new Volo("abc");
        float prezzoTest=100F;
        LocalDate dataTest= LocalDate.of(2023,02,28);
        RicorrenzaDiVolo ricorrenzaTest = new RicorrenzaDiVolo(dataTest,"CTA", "FCO", voloTest,60,prezzoTest);
        float importoOriginale = ricorrenzaTest.getPrezzo();
        int Sconto = AirManager.verificaCondizioniRimborso(ricorrenzaTest.getDataPartenza());
        assertEquals(25,Sconto);
        assertEquals(25,AirManager.calcolaImportoRimborsato(importoOriginale,Sconto)); //nome metodo da rivedere
    }

    @Test
    void calcolaImportoRimborsatoTest() {

        assertEquals(25,AirManager.calcolaImportoRimborsato(100,25)); //nome metodo da rivedere
    }
}



