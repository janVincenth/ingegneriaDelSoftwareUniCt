import java.time.LocalDate;
import java.util.Date;

public class DocumentoIdentita {
    String codiceDocumento;
    LocalDate scadenza;

    public DocumentoIdentita(String codiceDocumento, LocalDate scadenza){
        this.codiceDocumento=codiceDocumento;
        this.scadenza=scadenza;

    }

    public String getCodiceDocumento(){
        return codiceDocumento;

    }

    public void setCodiceDocumento(String codiceDocumento) {
        this.codiceDocumento = codiceDocumento;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }
}
