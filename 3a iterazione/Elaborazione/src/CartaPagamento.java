import java.time.LocalDate;
import java.util.Date;

public class CartaPagamento {
    String numeroCarta;
    LocalDate scadenza;
    String CVV;
    String nomeCognomeIntestatario;
    String circuito;
    Transazione transazione;



    public CartaPagamento(float importo, String circuito, String nomeCognomeIntestatario, String numeroCarta, LocalDate scadenza, String CVV){
        this.numeroCarta = numeroCarta;
        this.scadenza = scadenza;
        this.CVV  =CVV;
        this.nomeCognomeIntestatario = nomeCognomeIntestatario;
        this.circuito = circuito;

        transazione = new Transazione(this, importo); //vince: per cliente ho definito una funzione crea cartam qui mi sembra evitabile
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getNomeCognomeIntestatario() {
        return nomeCognomeIntestatario;
    }

    public void setNomeCognomeIntestatario(String nomeCognomeIntestatario) {
        this.nomeCognomeIntestatario = nomeCognomeIntestatario;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public Transazione getTransazione() {
        return transazione;
    }

    public void setTransazione(Transazione transazione) {
        this.transazione = transazione;
    }
}
