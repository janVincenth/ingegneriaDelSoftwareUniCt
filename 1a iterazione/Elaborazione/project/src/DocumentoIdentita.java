import java.util.Date;

public class DocumentoIdentita {
    String codiceDocumento;
    Date scadenza;

    public DocumentoIdentita(String codiceDocumento, Date scadenza){
        this.codiceDocumento=codiceDocumento;
        this.scadenza=scadenza;

    }

    public String getCodiceDocumento(){
        return codiceDocumento;

    }
}
