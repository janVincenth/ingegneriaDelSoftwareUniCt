import java.time.LocalDate;
import java.util.Scanner;

public class Cliente {
    Scanner scanner;
    String Nome;
    String Cognome;
    String codiceFiscale;

    Contatti contatti;
    CartaImbarco cartaImbarco; //puntatore
    DocumentoIdentita documentoIdentità;


    public Cliente(String Nome, String Cognome, String codiceFiscale, Prenotazione prenotazione){
        scanner= new Scanner(System.in);
        this.Nome=Nome;
        this.Cognome=Cognome;
        this.codiceFiscale=codiceFiscale;

        CartaImbarco cartaImbarco = new CartaImbarco();
        cartaImbarco.setCliente(this);
        this.cartaImbarco = cartaImbarco;

        creaDocumento();
        creaContatti();
        creaCarta();

    }

    private void creaContatti() {
        System.out.println("Quale è il tuo indirizzo e-mail?");
        String email = scanner.nextLine();
        contatti=new Contatti(email);

    }

    private void creaDocumento() {
        System.out.println("Adesso puoi digitare il codice del tuo documento per favore?");
        String codiceDocumento = scanner.nextLine();
        System.out.println("Quando scade il tuo documento?"); //vince: al momento non formatto la data, ma poi dovrò formattarla - importante controllare anche se non è scaduto
        LocalDate scadenzaDocumento = LocalDate.parse(scanner.nextLine());
        documentoIdentità=new DocumentoIdentita(codiceDocumento,scadenzaDocumento);

    }

    private void creaCarta(){
        System.out.println("Grazie "+Nome+", adesso possiamo procedere con il pagamento :)\nAl momento puoi effettuare il pagamento esclusivamente tramite carta, quindi, puoi cortesemente digitare il codice di 16 cifre impresso sulla tua carta di pagamento?");
        String codiceCarta= scanner.nextLine(); //correggere tipo su DCD
        System.out.println("Quando scade la carta?");
        LocalDate scadenzaCarta = LocalDate.parse(scanner.nextLine()); //da formattare e controllare che non sia scaduta
        System.out.println("Digita il codice CVV di 3 cifre per favore, puoi trovarlo sul retro della carta ;)");
        String CVV = scanner.nextLine();
        System.out.println("Il titolare di questa carta sei tu? -> y/n");
        String seiTitolareQuestion = scanner.nextLine();
        String nomeCognomeTitolare;
        if (seiTitolareQuestion.equalsIgnoreCase("y")) nomeCognomeTitolare=Nome.concat(" "+Cognome);
        else {System.out.println("Inserisci nome e cognome del titolare, per favore");
            nomeCognomeTitolare=scanner.nextLine();
        }
        System.out.println("Scegli un circuito tra quelli disponibili\n1. VISA\n2. MASTERCARD");
        int circuitoQuestion= Integer.parseInt(scanner.nextLine());
        String circuito;
        if (circuitoQuestion==1) circuito="VISA"; else circuito="MASTERCARD";
        CartaPagamento cartaPagamento = new CartaPagamento(20,circuito,nomeCognomeTitolare,codiceCarta,scadenzaCarta,CVV);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Contatti getContatti(){
        return this.contatti;
    }

    public void setContatti(Contatti contatti) {
        this.contatti = contatti;
    }

    public CartaImbarco getCartaImbarco(){
        return cartaImbarco;
    }

    public void setCartaImbarco(CartaImbarco cartaImbarco) {
        this.cartaImbarco = cartaImbarco;
    }

    public DocumentoIdentita getDocumentoIdentità() {
        return documentoIdentità;
    }

    public void setDocumentoIdentità(DocumentoIdentita documentoIdentità) {
        this.documentoIdentità = documentoIdentità;
    }

}
