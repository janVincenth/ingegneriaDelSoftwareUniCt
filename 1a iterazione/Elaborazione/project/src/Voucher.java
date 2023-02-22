import java.util.Date;

public class Voucher {
    String voucherID;
    Date scadenzaVoucher;

    float importo;

    public Voucher(float importoRimborsato){
        this.importo=importoRimborsato;
        voucherID= String.valueOf(((Math.random() * 10000000)));
        //scadenza?
    }


}
