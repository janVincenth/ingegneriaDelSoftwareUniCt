import java.time.LocalDate;

public class ServizioPagamento_Adapter implements GestionePagamenti{

    @Override
    public boolean richiediApprovazione(Transazione transazione) {

        if(transazione.getCartaPagamento().getScadenza().isBefore(LocalDate.now())) return false; //carta scaduta
        else return true;
    }
}
