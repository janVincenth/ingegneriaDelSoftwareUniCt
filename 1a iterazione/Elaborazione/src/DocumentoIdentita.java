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
}
