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

    public static int controlloVoucher(Voucher voucherDaControllare){ //-1 se non emesso dalla compagnia, 1 se valido per sconto su prenotazione, 2 se valido per scelta posto, -2 se scaduto, -3 se già utilizzato

        if(voucherDaControllare == null) return -1; //voucher non emesso dalla compagnia
        else if (!voucherDaControllare.getDataScadenzaVoucher().isAfter(LocalDate.now())) return -2; //Voucher scaduto
        else if (voucherDaControllare.utilizzato) return -3; //voucher già utilizzato
        else if (voucherDaControllare.getTipologia() == "scontoAcquistoBiglietto") return 1; //Voucher valido per sconto prenotazione
        else if (voucherDaControllare.getTipologia() == "voucherScegliPosto") return 2; //Voucher valido sceltaPosto
        else return -5; //errore generico imprevisto
    }





        /*if(voucherDaControllare != null){ // il voucher è stato emesso dalla compagnia
            if(!voucherDaControllare.utilizzato){ // il voucher proposto non è ancora stato utilizzato
                if(voucherDaControllare.getTipologia() == "scontoAcquistoBiglietto"){ // il voucher proposto è valido per l'acquisto di un biglietto
                    if(voucherDaControllare.getDataScadenzaVoucher().isAfter(LocalDate.now())){
                        float importoScontato = p.getImporto() - voucherDaControllare.getImporto();
                        if(importoScontato > 0){

                        }
                        else { // importoScontato < 0, prenotazione effettuata
                            System.out.println("In seguito all'applicazione del voucher da te proposto, l'importo da pagare è stato azzerato. La prenotazione è andata a buon fine. Ti aspettiamo a bordo!");
                            voucherDaControllare.setUtilizzato(true);
                        }
                    }
                    else {

                    }
                }
                else{
                    System.out.println("Il voucher proposto non è utilizzabile in fase di acquisto di un biglietto. Si prega di riprovare inserendo un codice voucher valido.");
                }
            }
            else{
                System.out.println("Il voucher proposto è già stato utilizzato. Si prega di riprovare inserendo un codice voucher valido.");
                return -3;
            }
        }
        else {
            System.out.println("Il codice voucher inserito non corrisponde a nessun voucher emesso dalla compagnia. Si prega di riprovare inserendo un codice voucher valido.");
            return -1;
        }*/


}
