import java.time.Duration;
import java.time.Period;
import java.util.*;
import java.time.LocalDate;

public class AirManager {
    //aggiungere metodi getters & setters
    private static AirManager airManager;

    //collezioni
    private static ArrayList<Volo> voli;
    private static ArrayList<RicorrenzaDiVolo> ricorrenze;
    private static ArrayList<Prenotazione> prenotazioni;
    private static Map <String, Voucher> voucherEmessi;
    private static Map<String, String> aeroporti;


    public static void main(String[] args) throws InterruptedException {
        init();
        AirManager airManager = getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Benvenuto in Air-Manager!\nStai utilizzando il software come impiegato o come cliente?");

        String[] userOptions = {"1. Cliente", "2. Impiegato"};
        printMenu(userOptions);

        int user = Integer.parseInt(scanner.nextLine());

        if(user==1) { //utilizzo da parte di un cliente
            routineCliente(scanner);
        }
        else if(user==2) { //utilizzo da parte di un impiegato
            routineImpiegato(scanner);
        }
        else System.out.println("Il valore inserito non è valido. Ritenta.");

    } //fine main

    private static void routineCliente(Scanner scanner) throws InterruptedException {
        String[] clientOptions = {"1. Effettuare una prenotazione (Acquisto biglietto)",
                "2. Cancellare una prenotazione",
                "3. Effettuare il check-in",
                "4. Esci da Air-Manager"
        };
        int option = 0;
        while(option != 4) {
            System.out.println("\nSpecifica il numero dell'operazione che desideri effettuare fra le seguenti: ");
            printMenu(clientOptions);

            option = Integer.parseInt(scanner.nextLine()); //alternativamente, posso usare System.nextInt()

            switch(option) {
                case 1:
                    effettuaPrenotazione(scanner);
                    break;
                case 2:
                    cancellaPrenotazione(scanner);
                    break;
                case 3:
                    effettuaCheckIn(scanner);
                    break;
                case 4: {
                    System.out.println("\nGrazie per aver utilizzato Air-Manager!");
                    System.exit(0);
                }
            }
        }
    }
public static int mostraVoli(Map<String, String> aeroporti){ //vince: passo il parametro locale cosicché da poter testare il metodo esternamente
    System.out.println("\nEcco la lista degli aeroporti:");
    int sentinella=0; //conta i voli visualizzati e si accerta che ad ogni codice IATA sia associato un aeroporto, e viceversa
    Iterator<Map.Entry<String, String>> iteratorAeroporti = aeroporti.entrySet().iterator();
    while(iteratorAeroporti.hasNext()) {
        Map.Entry<String, String> demoAeroporto = iteratorAeroporti.next();
        if (demoAeroporto.getKey() != null && demoAeroporto.getValue() != null) {
            System.out.println("Codice IATA: " + demoAeroporto.getKey() + " - Denominazione: " + demoAeroporto.getValue());
            sentinella++;
        }else if (demoAeroporto.getKey() == null && demoAeroporto.getValue() == null){
            sentinella= -1; //elemento della mappa vuoto, condizione non critica ma sgradita
            break;
        }
        else {
            sentinella=-2; //elemento della mappa non valido -> chiave null e valore diverso da null, o viceversa
            break;
        }
    }
    return sentinella;
}
    public static void pause(Scanner scanner){

        System.out.println("Premi INVIO per continuare...");
        scanner.nextLine();
    }

    private static void init(){
        aeroporti = new HashMap<>();
        aeroporti.put("CTA","FONTANA ROSSA (Catania)");
        aeroporti.put("FCO","FIUMICINO (Roma)");
        aeroporti.put("FLR","PERETOLA (Firenze)");
    }
    private static void effettuaPrenotazione(Scanner scanner) throws InterruptedException {
        Prenotazione prenotazione = new Prenotazione();
        prenotazioni = new ArrayList<Prenotazione>();

        String aeroportoPartenza;
        String aeroportoDestinazione;
        LocalDate dataPartenza;

        //INIZIALIZZO LA COLLEZIONE CON AEROPORTI PRE-SELEZIONATI

        //INIZIALIZZO LA COLLEZIONE CON RICORRENZE PRE-SCELTE
        ricorrenze = new ArrayList<RicorrenzaDiVolo>();
        RicorrenzaDiVolo ricorrenza1v1= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"CTA","FCO",voli.get(0),80,50F),
                ricorrenza2v1= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"CTA","FLR",voli.get(0),88,53F),
                ricorrenza1v2= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"FLR","CTA",voli.get(1),90,70F),
                ricorrenza2v2= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"FLR","FCO",voli.get(1),92,75F),
                ricorrenza1v3= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"FCO","FLR",voli.get(2),20,40F),
                ricorrenza2v3= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"FCO","CTA",voli.get(2),21,38F);

        final short numeroPostiDisponibili = (short)90;
        MappaPostiASedere mappaAssociata1 = new MappaPostiASedere(numeroPostiDisponibili, false);
        MappaPostiASedere mappaAssociata2 = new MappaPostiASedere(numeroPostiDisponibili, false);
        MappaPostiASedere mappaAssociata3 = new MappaPostiASedere(numeroPostiDisponibili, false);
        MappaPostiASedere mappaAssociata4 = new MappaPostiASedere(numeroPostiDisponibili, false);
        MappaPostiASedere mappaAssociata5 = new MappaPostiASedere(numeroPostiDisponibili, false);
        MappaPostiASedere mappaAssociata6 = new MappaPostiASedere(numeroPostiDisponibili, false);
        ricorrenza1v1.setMappaAssociata(mappaAssociata1);
        ricorrenza2v1.setMappaAssociata(mappaAssociata2);
        ricorrenza1v2.setMappaAssociata(mappaAssociata3);
        ricorrenza2v2.setMappaAssociata(mappaAssociata4);
        ricorrenza1v3.setMappaAssociata(mappaAssociata5);
        ricorrenza2v3.setMappaAssociata(mappaAssociata6);

        ricorrenze.add(ricorrenza1v1);
        ricorrenze.add(ricorrenza2v1);
        ricorrenze.add(ricorrenza1v2);
        ricorrenze.add(ricorrenza2v2);
        ricorrenze.add(ricorrenza1v3);
        ricorrenze.add(ricorrenza2v3);


        System.out.println("\nPer favore, scegli un aeroporto di partenza digitando il codice IATA corrispondente:"); //da implementare una lista di aeroporti da cui scegliere tramite elenco puntato

        /**************************
         * vince deve assicurarsi che si match la chiave
         **************************/
        mostraVoli(aeroporti);

        aeroportoPartenza= scanner.nextLine().toUpperCase();
        System.out.println("\nBene, partirai da: " +aeroporti.get(aeroportoPartenza) +". \nAdesso cortesemente digita il codice IATA dell'aeroporto di arrivo"); //come sopra

        /**************************
         * vince oltre ad assicurarmi che si match una chiave, nella selezione delle destinazioni non devo mostrare lo stesso aeroporto scelto come partenza
         **************************/

        mostraVoli(aeroporti);
        aeroportoDestinazione= scanner.nextLine().toUpperCase();
        System.out.println("\nOttimo, il tuo viaggio inizierà da " +aeroporti.get(aeroportoPartenza) +"e finirà a "+aeroporti.get(aeroportoDestinazione)+ "\nIn che giorno vuoi partire? Per favore, inserisci la data di partenza nel formato gg-mm-aaaa"); //come sopra

/**************************
 * vince implementare un controllo data inserita
 **************************/

		dataPartenza =  LocalDate.parse(scanner.nextLine());



        System.out.println("\nEcco i voli disponibili: "); //vince: gergo voli usato volutamente
        for(int i=0; i<ricorrenze.size();i++){
            if(ricorrenze.get(i).getAeroportoPartenza().equals(aeroportoPartenza) && ricorrenze.get(i).getAeroportoArrivo().equals(aeroportoDestinazione) && ricorrenze.get(i).getDataPartenza().equals(dataPartenza))
                System.out.println(i+". Volo: "+ricorrenze.get(i).getVoloAssociato().getNumeroVolo()+", con tempo di percorrenza pari a "+ricorrenze.get(i).getDurataNominale()+" minuti. Prezzo in € "+ricorrenze.get(i).getPrezzo());

        }
        //vince: ho appena mostrato la lista dei voli che matchano le preferenze, adesso devo fare selezionare il volo di preferenza.
        // nb vince: l'indice delle opzioni di volo non parte da 1
        System.out.println("Effettua una scelta ");
        int ricorrenzaScelta=Integer.parseInt(scanner.nextLine());

        System.out.println("Fantastico! Andiamo avanti, adesso ho bisogno di sapere come ti chiami?");
        String nome = scanner.nextLine();
        System.out.println("Quale è il tuo cognome?");
        String cognome = scanner.nextLine();
        System.out.println("Adesso ho bisogno del tuo codice fiscale per favore, puoi digitarlo sotto");
        String codiceFiscale = scanner.nextLine();



        Cliente cliente = new Cliente(nome, cognome, codiceFiscale, prenotazione); //vince: passo prenotazione perchè è cliente che deve settare su di essa il documento, dopo averlo creato
        prenotazione.setData(LocalDate.now());

        prenotazione.setImporto(ricorrenze.get(ricorrenzaScelta).getPrezzo()); //20 cast in float F
        prenotazione.setCliente(cliente);
        prenotazione.setNumeroPrenotazione("1000");
        DocumentoIdentita documentoDaAssociareAPrenotazione=cliente.getDocumentoIdentità();
        prenotazione.setDocumentoIdentita(documentoDaAssociareAPrenotazione);
        prenotazione.setRicorrenzaDiVolo(ricorrenze.get(ricorrenzaScelta)); //scelta corrisponde alla ricorrenza selezionata

        prenotazioni.add(prenotazione);
        simulAttesa();
        System.out.println("Il pagamento è andato a buon fine. La prenotazione è stata registrata"); //vince: aggiornare DCD
        pause(scanner);

    }

    private static void cancellaPrenotazione(Scanner scanner) throws InterruptedException {
        System.out.println("Bentornato, per effettuare il rimborso ho bisogno di chiederti alcuni dati.");
        Prenotazione prenotazioneTrovata;
        String emailSuPrenotazione=null;
        do{
        System.out.println("Per iniziare, quale è il numero della prenotazione?");
        String numeroPrenotazione = scanner.nextLine().toLowerCase();
        prenotazioneTrovata= getPrenotazione(numeroPrenotazione);


            if (prenotazioneTrovata!=null) emailSuPrenotazione=prenotazioneTrovata.getCliente().getContatti().getEmail();
            else System.out.println("Spiacente, non ho trovato nessuna prenotazione con il codice inserito.");
        } while(prenotazioneTrovata==null);

        String numeroCartaImbarco = prenotazioneTrovata.getCliente().getCartaImbarco().getNumeroCarta();
        if(numeroCartaImbarco.equals(String.valueOf(0))) { //non è stato ancora effettuato il check-in per questa prenotazione
            System.out.println("Non è ancora stato effettuato il check-in per questa prenotazione, pertanto è possibile procedere con la cancellazione.");
            System.out.println("Qual è l'indirizzo email che hai comunicato quando hai fatto le prenotazione?");
            String emailComunicataAdesso = scanner.nextLine();

            simulAttesa();
            if (verificaCorrispondenzaEmail(emailComunicataAdesso, emailSuPrenotazione)) //vince: implementare mail fake
                System.out.println("L'email inserita risulta verificata. Adesso per favore inserisci il codice del tuo documento di identità");
            else System.exit(0); //implementare correzione su errore
            String codiceComunicatoAdesso = scanner.nextLine();
            String codiceSuPrenotazione = prenotazioneTrovata.getDocumentoIdentita().codiceDocumento;
            simulAttesa();
            if (verificaCorrispondenzaDocumento(codiceSuPrenotazione, codiceComunicatoAdesso))
                System.out.println("Il codice che hai inserito è stato verificato");
            int rimborsoPercentuale = verificaCondizioniRimborso(prenotazioneTrovata.getRicorrenza().getDataPartenza());
            cancellazioneEffettivaPrenotazione(prenotazioneTrovata, prenotazioni);
            float importoRimborsato = calcolaImportoRimborsato(prenotazioneTrovata.getImporto(), rimborsoPercentuale);
            if (importoRimborsato > 0){
                Voucher voucher = new Voucher(importoRimborsato);
                voucherEmessi.put(voucher.getVoucherID(), voucher);
            }
            System.out.println("Importo rimborsato: €" + importoRimborsato);
            pause(scanner);
        }
        else { //è giù stato effettuato il check-in per questa prenotazione
            System.out.println("È già stato effettuato il check-in per questa prenotazione, pertanto non può essere cancellata.");
        }
    }

    public static float calcolaImportoRimborsato(float importo, int sconto) {

        return importo*((float)sconto/100);
    }


    public static void cancellazioneEffettivaPrenotazione(Prenotazione prenotazioneDaCancellare, List<Prenotazione> listaPrenotazioni){
        for(int i=0;i<listaPrenotazioni.size();i++){
            if(listaPrenotazioni.get(i).getNumeroPrenotazione().equals(prenotazioneDaCancellare.getNumeroPrenotazione()))
                listaPrenotazioni.remove(i);
                System.out.println("\nLa prenotazione è stata cancellata con successo.");
        }
    }

    public ArrayList<Prenotazione> getPrenotazioni(){
        return prenotazioni;
    }

    public static int verificaCondizioniRimborso(LocalDate dataVolo) {
        //verificare errore dello steccato

        if(Period.between(LocalDate.now(),dataVolo).getDays()>=3 && Period.between(LocalDate.now(),dataVolo).getDays()<30){
            System.out.println("Hai diritto ad un rimborso del 25%, riceverai un voucher tramite email, grazie per la preferenza.");
            return 25;
        }
        else if(Period.between(LocalDate.now(),dataVolo).getDays()>=30){
            System.out.println("Hai diritto ad un rimborso del 50%,riceverai un voucher tramite email, grazie per la preferenza.");
            return 50;
        }
        else{ System.out.println("Non hai diritto ad alcun rimborso, spiacenti."); return 0;}
    }

    public static void simulAttesa() throws InterruptedException {
        System.out.println("Un attimo, sto verificando...");
        Thread.currentThread().sleep(3000);
    }
	
	private static void effettuaCheckIn(Scanner scanner) {
		System.out.println("Benvenuto nella procedura di check-in! Si prega di inserire il numero della prenotazione per cui effettuare il check-in");
		String numeroPrenotazioneInput = scanner.nextLine().toLowerCase();

		Prenotazione p = getPrenotazione(numeroPrenotazioneInput);
		if (p == null) //al momento non è data la possibilità di provare più volte consecutivamente, per semplicità
			System.out.println("Non è stata trovata alcuna prenotazione avente il numero prenotazione inserito.");
		else {
			System.out.println("È stata trovata una prenotazione avente il seguente codice: " + numeroPrenotazioneInput.toUpperCase());
			Cliente cl = p.getCliente();
			if(!cl.getCartaImbarco().getNumeroCarta().equals(String.valueOf(0))){
				System.out.println("È già stato effettuato il check-in per questa prenotazione. Air-Manager augura buon viaggio!");
			}
			else { // check-in non ancora effettuato
                System.out.print("\nSi prega di inserire il codice del proprio documento d'identità: \n");
                String codiceDocumento = scanner.nextLine().toLowerCase();
                String codiceDocumentoPrenotazione = p.getDocumentoIdentita().getCodiceDocumento().toLowerCase();
                //per la corrente iterazione (Iterazione 1) non si sta ancora considerando il security check
                //System.out.println(codiceDocumentoPrenotazione + "" + codiceDocumento);
                //if (!codiceDocumentoPrenotazione.equals(codiceDocumento))
                if (!verificaCorrispondenzaDocumento(codiceDocumentoPrenotazione, codiceDocumento)) {
                    System.out.println("Il codice documento fornito non corrisponde a quello associato alla prenotazione indicata.");
                }
                else {
                    System.out.println("Codice documento valido. Si prega di inserire la mail utilizzata in fase di prenotazione:");
                    String email = scanner.nextLine().toLowerCase();
                    String emailPrenotazione = cl.getContatti().getEmail().toLowerCase();
                    //if (!emailPrenotazione.equals(email)) {
                    if (!verificaCorrispondenzaEmail(emailPrenotazione, email)) {
                        System.out.println("L'email fornita non corrisponde a quella associata alla prenotazione indicata.");
                    }
                    else {
                        System.out.println("Email valida.");

                        //determino posto da proporre al cliente
                        MappaPostiASedere mappaPrenotazione = p.getRicorrenza().getMappaAssociata();

                        if (mappaPrenotazione.getNumeroPostiDisponibili() > 0) { //è ancora presente almeno un posto a sedere libero (no overbooking)
                            short numeroPostoProposto = mappaPrenotazione.definisciPosto();

                            System.out.println("\nAir-Manager ti propone il seguente posto a sedere: " + (short) (numeroPostoProposto + 1) + "\nAccetti?\n1. Sì\n2. No");
                            int option = scanner.nextInt();
                            if (option == 1) { // scenario principale
                                mappaPrenotazione.setPostiOccupati(numeroPostoProposto);
                                System.out.println("\nBene, viaggerai al posto numero " + (short) (numeroPostoProposto + 1) + "\n");

                                String numeroCartaImbarco = String.valueOf((int) (Math.random() * 10000000)); // generatore casuale di numeroCartaImbarco
                                String nome = cl.getNome();
                                String cognome = cl.getCognome();
                                CartaImbarco cartaImbarco = cl.getCartaImbarco();

                                aggiornaCartaImbarcoCliente(cartaImbarco, nome, cognome, numeroCartaImbarco, numeroPostoProposto);
                                System.out.println(cartaImbarco); //mostro a schermo i dettagli della carta d'imbarco emessa
                                pause(scanner);
                            } else if (option == 2) {
                                System.out.println("Posto rifiutato (scenario alternativo non ancora implementato nella corrente iterazione (iterazione 1)");
                            } else System.out.println("Opzione non valida");
                        }
                        // non è più presente almeno un posto a sedere libero (overbooking)
                        else
                            System.out.println("Non sono più presenti posti a sedere disponibili per questo volo, pertanto non è possibile portare a termine il check-in e generare una carta d’imbarco. Si prega di recarsi al box assistenza");
                    } // chiusura else email valida
                } // chiusura else codice documento valido
            }
        }
	}

    public static void aggiornaCartaImbarcoCliente(CartaImbarco cartaImbarco, String nome, String cognome, String numeroCartaImbarco, short numeroPostoProposto) {
        cartaImbarco.getCliente().setNome(nome);
        cartaImbarco.getCliente().setCognome(cognome);
        cartaImbarco.setNumeroCarta(numeroCartaImbarco);
        cartaImbarco.setPostoASedere(numeroPostoProposto);
    }

    public static boolean verificaCorrispondenzaDocumento(String documentoPrenotazione, String documentoInput){
        if(documentoInput.equals(documentoPrenotazione)) return true;
        else return false;
    }

    public static boolean verificaCorrispondenzaEmail(String emailPrenotazione, String emailInput){
        if(emailPrenotazione.equals(emailInput)) return true;
        else return false;

    }

    private static void routineImpiegato(Scanner scanner) {
        String[] employedOptions = {"1. Gestire scheda anagrafica prodotto",
                "2. Effettua carico di magazzino per approvvigionamento aeromobile",
                "3. Stampare lista dei prodotti in sottoscorta",
                "4. Esci da Air-Manager"
        };

        System.out.println("\nSpecifica il numero dell'operazione che desideri effettuare fra le seguenti: ");
        printMenu(employedOptions);

        int option = Integer.parseInt(scanner.nextLine());

        switch(option) {
            case 1:
                System.out.println('1');
                // gestisciSchedaAnagraficaProdotto();
                break;
            case 2:
                System.out.println('2');
                // effettuaCaricoMagazzino();
                break;
            case 3:
                //code block
                System.out.println('3');
                //stampaListaProdottiInSottoscorta();
                break;
            case 4: {
                System.out.println("\nGrazie per aver utilizzato Air-Manager!");
                System.exit(0);
            }
        }

    }

    public static void creaVoli(){ //passo parametro locale per rendere testabile il metodo
        for(int i=0; i<(aeroporti.size()*(aeroporti.size()-1)/2);i++){
            voli.add(new Volo("AA012"+i)); // ai fini dimostrativi si generano voli aventi codifica uguale nei primi 5 caratteri, e il 6 varierà in funzione dell'indice i
        }
    }

    private AirManager() {
        this.voucherEmessi = new HashMap<String, Voucher>();
        this.voli = new ArrayList<Volo>();
        creaVoli();
        //creo voli di esempio e li aggiungo alla lista dei voli

        /*v1 = new Volo("AZ4697");
        v2 = new Volo("FR1209");
        v3 = new Volo("AZ1406");
        voli.add(v1);
        voli.add(v2);
        voli.add(v3);*/

        //creo ricorrenze di esempio e li aggiungo a ciascun volo
        // vince: demo ricorrenze



        //creo prenotazioni di esempio e le aggiungo alla lista delle prenotazioni
	    /*
	    p1 = new Prenotazione();
	    p1.numeroPrenotazione.setNumeroPrenotazione("ABCDEF012345");
	    p1.data.setData(LocalDate.of(2023, 1, 10));
	    p1.importo.setImporto(50);
	    p2 = new Prenotazione();
	    p2.numeroPrenotazione.setNumeroPrenotazione("GHILMN012345");
	    p2.data.setData(LocalDate.of(2020, 9, 9));
	    p2.importo.setImporto(50);
	    prenotazioni.add(p1);
	    prenotazioni.add(p2);
	    */
    }

    public static AirManager getInstance() {
        if (airManager == null)
            airManager = new AirManager();

        return airManager;
    }

    private static Prenotazione getPrenotazione(String numeroPrenotazioneInput){
        for(int i = 0; i < prenotazioni.size(); i++){
            String numeroPrenotazione = prenotazioni.get(i).numeroPrenotazione;
            if(numeroPrenotazione.toLowerCase().equals(numeroPrenotazioneInput))
                return prenotazioni.get(i);
        }
        return null;
    }

    public static void printMenu(String[] strings) {
        for(String string : strings)
            System.out.println(string);
        System.out.println("\nEffettua una scelta: "); //MODIFICATO PERCHè QUANDO SCEGLI L'USER NON HA SENSO PARLARE DI OPERAZIONI
    }

	/*public void setVolo(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}
	*/

    /*
	public void definisciVoloCorrente(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}
	*/

}
