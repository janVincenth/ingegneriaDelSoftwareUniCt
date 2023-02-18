import java.util.Date;

public class CartaPagamento {
    String numeroCarta; //correggi DCD
    Date scadenza;
    short CVV;
    String nomeCognomeIntestatario;
    String circuito;

    public CartaPagamento(float importo, String circuito, String nomeCognomeIntestatario, String numeroCarta, Date scadenza, short CVV){
        this.numeroCarta=numeroCarta;
        this.scadenza=scadenza;
        this.CVV=CVV;
        this.nomeCognomeIntestatario=nomeCognomeIntestatario;
        this.circuito=circuito;

    }
}
