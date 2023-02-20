import java.time.LocalDate;
import java.util.Date;

public class CartaPagamento {
    String numeroCarta; //correggi DCD
    LocalDate scadenza;
    String CVV;
    String nomeCognomeIntestatario;
    String circuito;
    Transazione transazione;

    public CartaPagamento(float importo, String circuito, String nomeCognomeIntestatario, String numeroCarta, LocalDate scadenza, String CVV){
        this.numeroCarta=numeroCarta;
        this.scadenza=scadenza;
        this.CVV=CVV;
        this.nomeCognomeIntestatario=nomeCognomeIntestatario;
        this.circuito=circuito;
        transazione=new Transazione(importo); //vince: per cliente ho definito una funzione crea cartam qui mi sembra evitabile

    }
}
