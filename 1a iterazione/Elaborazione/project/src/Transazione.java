import java.sql.Time;
import java.util.Date;

public class Transazione {
    int idTransazione;
    Date dataTransazione;
    Time oraTransazione;
    boolean validazione;
    boolean autorizzazione;
    float importo;

    CartaPagamento cartaPagamento;

    public int Transazione(float importo){
        idTransazione=1000; //vedi definizione
        dataTransazione=new Date(); //giornata odierna
        oraTransazione=null; //ora attuale
        validazione=false;
        autorizzazione=false;
        this.importo=importo;
        return idTransazione;
    }
}
