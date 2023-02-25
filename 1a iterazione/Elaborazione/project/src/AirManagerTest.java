import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class AirManagerTest {
    static AirManager airManager;
    static Prenotazione prenotazioneDaTestare;
    static Cliente cl;


    @BeforeAll
    static void setup() {
       // airManager = AirManager.getInstance();
       prenotazioneDaTestare = new Prenotazione();
       // cl = new Cliente("Mario", "Rossi", "RSSMRA06L09F205J", p);
       // cl.getDocumentoIdentità().setCodiceDocumento("AX123A12");
    }


    @Test
    void cancellazioneEffettivaPrenotazioneTest() {
        //ottimizzare chiamata prenotazioni
        ArrayList<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
        prenotazioneDaTestare.setNumeroPrenotazione("1000");
        prenotazioni.add(prenotazioneDaTestare);
        assertEquals(1,prenotazioni.size());
        AirManager.cancellazioneEffettivaPrenotazione(prenotazioneDaTestare, prenotazioni);
        assertEquals(0,prenotazioni.size());
    }

    @Test
    void verificaCondizioniRimborsoTest() {
        Volo voloTest = new Volo("abc");
        float prezzoTest = 100F;

        LocalDate dataTest = LocalDate.of(2000,02,28);
        RicorrenzaDiVolo ricorrenzaTest = new RicorrenzaDiVolo(dataTest,"CTA", "FCO", voloTest,60,prezzoTest);
        float importoOriginale = ricorrenzaTest.getPrezzo();
        int sconto = AirManager.verificaCondizioniRimborso(ricorrenzaTest.getDataPartenza());
        assertEquals(0, sconto);

        dataTest = LocalDate.of(2023,02,28);
        ricorrenzaTest = new RicorrenzaDiVolo(dataTest,"CTA", "FCO", voloTest,60,prezzoTest);
        sconto = AirManager.verificaCondizioniRimborso(ricorrenzaTest.getDataPartenza());
        assertEquals(25, sconto);
        assertEquals(25,AirManager.calcolaImportoRimborsato(importoOriginale,sconto)); //nome metodo da rivedere

        dataTest = LocalDate.of(2023,10,25);
        ricorrenzaTest = new RicorrenzaDiVolo(dataTest, "CTA", "FCO", voloTest,60,prezzoTest);
        sconto = AirManager.verificaCondizioniRimborso(ricorrenzaTest.getDataPartenza());
        //assertEquals(50, sconto);
    }

    @Test
    void calcolaImportoRimborsatoTest() {

        assertEquals(25,AirManager.calcolaImportoRimborsato(100,25)); //nome metodo da rivedere
    }

    /* da sfruttare dopo eventuale refactoring di creazione Cliente, Documento, Contatti e Carta,
       sfruttati in effettuaPrenotazione(), nella classe AirManager */
    /*
    @Test
    void verificaCorrispondenzaDocumento() {
        assertTrue(AirManager.verificaCorrispondenzaDocumento(cl.getDocumentoIdentità().getCodiceDocumento(), "AX123A12"));
    }
    */

    @Test
    void verificaCorrispondenzaEmailTest() {
        String emailTest = "mario_rossi@gmail.com";
        Contatti contatti = new Contatti(emailTest);

        assertTrue(AirManager.verificaCorrispondenzaEmail(emailTest, contatti.getEmail()));
    }

    /* da sfruttare dopo eventuale refactoring di creazione Cliente, Documento, Contatti e Carta,
       sfruttati in effettuaPrenotazione(), nella classe AirManager */
    /*

    /*
    @Test
    void aggiornaCartaImbarcoTest() {
        CartaImbarco cartaImbarco= new CartaImbarco();
        // in class CartaImbarcoTest, in test method CartaImbarcoTest, è stata già verificato la correttezza del costruttore, tramite test dedicato
        AirManager.aggiornaCartaImbarcoCliente(cartaImbarco, "Mario", "Rossi","0123456", (short)65);
        assertNotEquals("0", cartaImbarco.getNumeroCarta());
    }
    */

    @Test
    void mostraVoliTest(){
        Map<String, String> aeroporti;
        aeroporti = new HashMap<>();
        aeroporti.put("CTA","FONTANA ROSSA (Catania)");
        aeroporti.put("FCO","FIUMICINO (Roma)");
        aeroporti.put("FLR","PERETOLA (Firenze)");

        assertEquals(3,AirManager.mostraVoli(aeroporti)); //per ogni aeroporto inserito devo avere una riga nella lista visualizzata a video
        aeroporti.put("ABC",null);
        assertEquals(-2,AirManager.mostraVoli(aeroporti)); //ad ogni codice IATa deve corrispondere una denominazione aeroporto
        aeroporti.put(null,null);
        assertEquals(-1,AirManager.mostraVoli(aeroporti)); //ad ogni codice IATa deve corrispondere una denominazione aeroporto

    }
}



