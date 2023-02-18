import java.util.Date;

public class Prenotazione {

    String numeroPrenotazione;
    Date Data;
    Float importo;

    Cliente Cliente; //puntatore
    DocumentoIdentita documentoIdentita; // puntatore
    RicorrenzaDiVolo ricorrenzaDiVolo; // puntatore

    public Prenotazione(){

    }
    public void associaClienteAPrenotazione(String codiceFiscale){

    }
    public Date getDataPrenotazione(){
        return Data;

    }
    public Cliente getcliente(){
        return Cliente;

    }
    public DocumentoIdentita getDocumentoIdentita(){
        return documentoIdentita;

    }

    public void setNumeroPrenotazione(String numeroPrenotazione) {
        this.numeroPrenotazione = numeroPrenotazione;
    }

    public void setData(Date data) {
        Data = data;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
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

    public Float getImporto() {
        return importo;
    }

    public RicorrenzaDiVolo getRicorrenza(){
        return ricorrenzaDiVolo;

    }



}
