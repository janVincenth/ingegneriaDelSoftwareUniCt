import java.time.LocalDate;

public class Voucher {
    String voucherID;
    boolean utilizzato;
    String tipologia; // "scontoAcquistoBiglietto" oppure "sceltaPostoCheckIn"
    LocalDate dataScadenzaVoucher;
    float importo;

    public Voucher(float importoRimborsato, String tipologia){
        this.voucherID= String.valueOf(Math.random() * 10000000);
        this.utilizzato = false;
        this.tipologia = tipologia;
        this.importo=importoRimborsato;
        LocalDate dataScadenza = LocalDate.now().plusDays(180);
        this.dataScadenzaVoucher = dataScadenza;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public LocalDate getDataScadenzaVoucher() {
        return dataScadenzaVoucher;
    }

    public void setDataScadenzaVoucher(LocalDate dataScadenzaVoucher) {
        this.dataScadenzaVoucher = dataScadenzaVoucher;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public boolean isUtilizzato() {
        return utilizzato;
    }

    public void setUtilizzato(boolean utilizzato) {
        this.utilizzato = utilizzato;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
}
