import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartaImbarcoTest {
    static  CartaImbarco cartaImbarco;

    @BeforeAll
    static void setup(){
        cartaImbarco = new CartaImbarco();
    }


    @Test
    void CartaImbarcoTest() {
        assertEquals(String.valueOf(0), String.valueOf(cartaImbarco.getNumeroCarta()));
    }
}