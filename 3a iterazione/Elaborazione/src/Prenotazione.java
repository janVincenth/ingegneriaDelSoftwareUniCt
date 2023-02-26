import java.time.LocalDate;

public class Prenotazione {

    String numeroPrenotazione;
    LocalDate data;
    float importo;
    Cliente cliente; //puntatore
    DocumentoIdentita documentoIdentita; // puntatore
    RicorrenzaDiVolo ricorrenzaDiVolo; // puntatore

    public Prenotazione(){

    }
    public void associaClienteAPrenotazione(String codiceFiscale){

    }
    public LocalDate getDataPrenotazione(){
        return data;

    }
    public Cliente getCliente(){
        return cliente;

    }
    public DocumentoIdentita getDocumentoIdentita(){
        return documentoIdentita;

    }

    public void setNumeroPrenotazione(String numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setDocumentoIdentita(DocumentoIdentita documentoIdentita) {
        this.documentoIdentita = documentoIdentita;
    }

    public void setRicorrenzaDiVolo(RicorrenzaDiVolo ricorrenzaDiVolo) {
        this.ricorrenzaDiVolo = ricorrenzaDiVolo;
    }

    public String getNumeroPrenotazione() {
        return numeroPrenotazione;
    }

    public float getImporto() {
        return importo;
    }

    public RicorrenzaDiVolo getRicorrenza(){
        return ricorrenzaDiVolo;

    }


    public void setCartaPagamento(CartaPagamento cartaPagamento) {
    }
}
