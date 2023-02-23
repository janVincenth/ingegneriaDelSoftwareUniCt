import java.time.LocalDate;

public class Voucher {
    String voucherID;
    LocalDate dataScadenzaVoucher;
    //successivamente si renderà necessario l'aggiunta di un ulteriore attributo, di tipo boolean,
    // per stabilire se il voucher sia stato o meno utilizzato
    float importo;

    public Voucher(float importoRimborsato){
        this.importo=importoRimborsato;
        voucherID= String.valueOf(Math.random() * 10000000);
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
}
