import java.time.LocalDate;
import java.time.LocalTime;


public class Transazione {
    String idTransazione;
    LocalDate dataTransazione;
    LocalTime oraTransazione;
    boolean convalidata;
    boolean approvata;
    float importo;
    CartaPagamento cartaPagamento;


    public Transazione(CartaPagamento cartaPagamento, float importo){
        this.idTransazione = String.valueOf(Math.random() * 10000000);
        this.dataTransazione = null;
        this.oraTransazione = null;
        this.convalidata = false;
        this.approvata = false;
        this.importo = importo;
        this.cartaPagamento = cartaPagamento;
   }

    public String getIdTransazione() {
        return idTransazione;
    }

    public void setIdTransazione(String idTransazione) {
        this.idTransazione = idTransazione;
    }

    public LocalDate getDataTransazione() {
        return dataTransazione;
    }

    public void setDataTransazione(LocalDate dataTransazione) {
        this.dataTransazione = dataTransazione;
    }

    public LocalTime getOraTransazione() {
        return oraTransazione;
    }

    public void setOraTransazione(LocalTime oraTransazione) {
        this.oraTransazione = oraTransazione;
    }

    public boolean isConvalidata() {
        return convalidata;
    }

    public void setConvalidata(boolean validata) {
        this.convalidata = validata;
    }

    public boolean isApprovata() {
        return approvata;
    }

    public void setApprovata(boolean approvata) {
        this.approvata = approvata;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public CartaPagamento getCartaPagamento() {
        return cartaPagamento;
    }

    public void setCartaPagamento(CartaPagamento cartaPagamento) {
        this.cartaPagamento = cartaPagamento;
    }
}
