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



        creaContatti();
        creaDocumento();

        creaCarta(prenotazione);

        CartaImbarco cartaImbarco = new CartaImbarco();
        cartaImbarco.setCliente(this);
        this.cartaImbarco = cartaImbarco;
    }

    private void creaContatti() {
        String email;
        boolean ripetiInserimento=true;
        do{
            System.out.println("Quale è il tuo indirizzo e-mail?");
            email = scanner.nextLine();
            if (email.contains("@") && (email.contains(".net") || email.contains(".it") || email.contains(".com"))) ripetiInserimento=false;
        }while(ripetiInserimento);




        contatti=new Contatti(email);

    }

    private void creaDocumento() {
        String codiceDocumento;

        do{
            System.out.println("Adesso puoi digitare il codice del tuo documento per favore? (9 caratteri)");
            codiceDocumento = scanner.nextLine();
        }while(codiceDocumento.length()!=9);

        LocalDate scadenzaDocumento;
        do {
            System.out.println("Quando scade il tuo documento? (devi inserisce un documento non ancora scaduto)"); //vince: al momento non formatto la data, ma poi dovrò formattarla - importante controllare anche se non è scaduto
            scadenzaDocumento = AirManager.inserisciData(scanner);
        }while(scadenzaDocumento.isBefore(LocalDate.now()));


        documentoIdentità=new DocumentoIdentita(codiceDocumento,scadenzaDocumento);

    }

    private void creaCarta(Prenotazione p){
        /*
        float importoScontato = 0;
        boolean voucherValido = false;

        System.out.println("Vuoi utilizzare un voucher in tuo possesso per ottenere uno sconto sul prezzo del biglietto?\n1. Sì\n2.");
        int option = scanner.nextInt();

        if (option == 1) { // il cliente vuole utilizzare un voucher in suo possesso


            System.out.println("Inserisci un codice voucher valido: ");

            String codiceVoucherInput = scanner.nextLine(); // occorre inserire 1001
            // System.out.println(codiceVoucherDigitato); // stampa di debug
            Voucher voucherTrovatoInArchivio = AirManager.voucherEmessi.get(codiceVoucherInput);

            if(Voucher.controlloVoucher(voucherTrovatoInArchivio) != 1){ // 1 -> voucher valido per questo acquisto
                System.out.println("Voucher non valido. Ripetere l'operazione...");
                voucherValido = false;
                AirManager.pause(scanner);
            }
            else { // se il voucher utilizzato è valido per questo acquisto, calcolo il nuovo importo, comprensivo dello sconto
                importoScontato = p.getImporto() - voucherTrovatoInArchivio.getImporto();
                voucherValido = true;
            }

            if (importoScontato <= 0) {
                System.out.println("In seguito all'applicazione del voucher da te proposto, l'importo da pagare è stato azzerato. La prenotazione è andata a buon fine. Ti aspettiamo a bordo!");
                voucherTrovatoInArchivio.setUtilizzato(true);
            } else { // importoScontato < 0, prenotazione effettuata

            }

        }
        else if (option == 2){ // option 2: cliente non vuole usare voucher
        */
            String codiceCarta;
            boolean nonSoloNumeri=true;
            do {
                System.out.println("Grazie " + Nome + ", adesso possiamo procedere con il pagamento :)\nAl momento puoi effettuare il pagamento esclusivamente tramite carta, quindi, puoi cortesemente digitare il codice di 16 cifre impresso sulla tua carta di pagamento?");
                codiceCarta = scanner.nextLine(); //correggere tipo su DCD
                if(AirManager.isNumeric(codiceCarta.substring(0,9))) nonSoloNumeri=false; else nonSoloNumeri=true;
                if(AirManager.isNumeric(codiceCarta.substring(9,16))) nonSoloNumeri=false; else nonSoloNumeri=true;
            }while(codiceCarta.length()!=16 || nonSoloNumeri);

            LocalDate scadenzaCarta;
        do {
            System.out.println("Quando scade la carta? (inserire una carta non scaduta)");
            scadenzaCarta = AirManager.inserisciData(scanner);

            scadenzaCarta = AirManager.inserisciData(scanner);
        }while(scadenzaCarta.isBefore(LocalDate.now()));
            String CVV;
            do {
                System.out.println("Digita il codice CVV di 3 cifre per favore, puoi trovarlo sul retro della carta ;)");
                CVV = scanner.nextLine();
            }while(CVV.length()!=3 || !AirManager.isNumeric(CVV));
            String seiTitolareQuestion;
            boolean controlloTitolare=true;
            do {
                System.out.println("Il titolare di questa carta sei tu? -> y/n");
                seiTitolareQuestion = scanner.nextLine().toLowerCase();
                if(seiTitolareQuestion.equals("y") || seiTitolareQuestion.equals("n")) controlloTitolare=false;
            }while(controlloTitolare);

            String nomeCognomeTitolare;
            if (seiTitolareQuestion.equalsIgnoreCase("y")) nomeCognomeTitolare=Nome.concat(" "+Cognome);
            else {System.out.println("Inserisci nome e cognome del titolare, per favore");
                nomeCognomeTitolare=scanner.nextLine();
            }
            int circuitoQuestion=0;
            String circuito;
            String buffer;
            do {
                System.out.println("Scegli un circuito tra quelli disponibili\n1. VISA\n2. MASTERCARD");
                buffer=scanner.nextLine();
                if (AirManager.isNumeric(buffer)) circuitoQuestion=Integer.parseInt(buffer);



            }while(circuitoQuestion<1 || circuitoQuestion>2);

        if (circuitoQuestion == 1) circuito = "VISA";
        else circuito = "MASTERCARD";

            CartaPagamento cartaPagamento = new CartaPagamento(20,circuito,nomeCognomeTitolare,codiceCarta,scadenzaCarta,CVV);
            p.setCartaPagamento(cartaPagamento);
            Transazione transazioneGenerata = cartaPagamento.getTransazione();
            if(new ServizioPagamento_Adapter().richiediApprovazione(transazioneGenerata))
                System.out.println("Il pagamento è andato a buon fine. La prenotazione è stata registrata"); //vince: aggiornare DCD





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
