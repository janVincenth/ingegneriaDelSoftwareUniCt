import java.time.LocalDate;
import java.time.LocalTime;

public class GestionePagamento {

    public GestionePagamento(){

    }

    public boolean richiediApprovazione(Transazione transazione){
        transazione.setDataTransazione(LocalDate.now());
        transazione.setOraTransazione(LocalTime.now());

        //if verificaCarta()...

        transazione.setConvalidata(true);
        transazione.setApprovata(true);

        return true;
    }
}
