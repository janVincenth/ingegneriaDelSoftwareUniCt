import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;

public class AirManager {
    //aggiungere metodi getters & setters
    private static AirManager airManager;

    //collezioni
    private ArrayList<Volo> voli;
    private static ArrayList<RicorrenzaDiVolo> ricorrenze;
    //private ArrayList<Prenotazione> prenotazioni;
    private ArrayList<Prodotto> prodotti;
    private static ArrayList<Prenotazione> prenotazioni;

    private static Map<String, String> aeroporti;
    //istanze
    //
    private static Volo v1, v2, v3, voloCorrente;
    private Prodotto pr1, pr2;
    //private Prenotazione p1, p2;

    public static void main(String[] args) {
        AirManager Sistema = new AirManager();
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

    private static void routineCliente(Scanner scanner) {
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
                    System.out.println('1');
                    effettuaPrenotazione(scanner);
                    break;
                case 2:
                    System.out.println('2');
                    // cancellaPrenotazione();
                    break;
                case 3:
                    System.out.println('3');
                    // effettuaCheckIn();
                    break;
                case 4: {
                    System.out.println("\nGrazie per aver utilizzato Air-Manager!");
                    System.exit(0);
                }
            }
        }
    }
private static void mostraVoli(){
    System.out.println("\nEcco la lista degli aeroporti:"); //da implementare una lista di aeroporti da cui scegliere tramite elenco puntato
    Iterator<Map.Entry<String, String>> iteratorAeroporti = aeroporti.entrySet().iterator();
    while(iteratorAeroporti.hasNext()){
        Map.Entry<String, String> demoAeroporto= iteratorAeroporti.next();
        System.out.println("Codice IATA: " + demoAeroporto.getKey() + " - Denominazione: " + demoAeroporto.getValue() );
    }
}
    private static void effettuaPrenotazione(Scanner scanner) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazioni = new ArrayList<Prenotazione>();

        String aeroportoPartenza;
        String aeroportoDestinazione;
        LocalDate dataPartenza;
        aeroporti = new HashMap<>();

        //INIZIALIZZO LA COLLEZIONE CON AEROPORTI PRE-SELEZIONATI
        aeroporti.put("CTA","FONTANA ROSSA (Catania)");
        aeroporti.put("FCO","FIUMICINO (Roma)");
        aeroporti.put("FLR","PERETOLA (Firenze)");
        //INIZIALIZZO LA COLLEZIONE CON RICORRENZE PRE-SCELTE
        ricorrenze = new ArrayList<RicorrenzaDiVolo>();
        RicorrenzaDiVolo ricorrenza1v1= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"CTA","FCO",v1,80,50F),
                         ricorrenza2v1= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"CTA","FCO",v1,88,53F),
                         ricorrenza1v2= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"CTA","FLR",v2,90,70F),
                         ricorrenza2v2= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"CTA","FLR",v2,92,75F),
                         ricorrenza1v3= new RicorrenzaDiVolo(LocalDate.of(2023,06,14),"FCO","FLR",v3,20,40F),
                         ricorrenza2v3= new RicorrenzaDiVolo(LocalDate.of(2023,06,15),"FCO","FLR",v3,21,38F);
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
        mostraVoli();

        aeroportoPartenza= scanner.nextLine().toUpperCase();
        System.out.println("\nBene, partirai da: " +aeroporti.get(aeroportoPartenza) +". \nAdesso cortesemente digita il codice IATA dell'aeroporto di arrivo"); //come sopra

        /**************************
         * vince oltre ad assicurarmi che si match una chiave, nella selezione delle destinazioni non devo mostrare lo stesso aeroporto scelto come partenza
         **************************/

        mostraVoli();
        aeroportoDestinazione= scanner.nextLine().toUpperCase();
        System.out.println("\nOttimo, il tuo viaggio inizierà da " +aeroporti.get(aeroportoPartenza) +"e finirà a "+aeroporti.get(aeroportoDestinazione)+ "\nChe giorno vuoi partire? Per favore, inserisci la data di partenza nel formato gg-mm-aaaa"); //come sopra

/**************************
 * vince implementare un controllo data inserita
 **************************/

		String dataPartenzaGrezza =  scanner.nextLine();
        int giorno = Integer.parseInt(dataPartenzaGrezza.substring(0,2));
        int mese= Integer.parseInt(dataPartenzaGrezza.substring(3,5));
        int anno= Integer.parseInt(dataPartenzaGrezza.substring(6,10));

        dataPartenza=LocalDate.of(anno,mese,giorno);
        System.out.println("\nEcco i voli disponibili: "); //vince: gergo voli usato volutamente
        for(int i=0; i<ricorrenze.size();i++){
            if(ricorrenze.get(i).getAeroportoPartenza().equals(aeroportoPartenza) && ricorrenze.get(i).getAeroportoArrivo().equals(aeroportoDestinazione) && ricorrenze.get(i).getDataPartenza().equals(dataPartenza))
                System.out.println(i+1+". Volo: "+ricorrenze.get(i).getVoloAssociato().getNumeroVolo()+", con tempo di percorrenza pari a "+ricorrenze.get(i).getDurataNominale()+" minuti. Prezzo in € "+ricorrenze.get(i).getPrezzo());

        }
        //vince: ho appena mostrato la lista dei voli che matchano le preferenze, adesso devo fare selezionare il volo di preferenza.
        // nb vince: l'indice delle opzioni di volo non parte da 1
        System.out.println("Effettua una scelta ");
        int scelta=Integer.parseInt(scanner.nextLine());

        System.out.println("Fantastico! Andiamo avanti, adesso ho bisogno di sapere come ti chiami?");
        String nome = scanner.nextLine();
        System.out.println("Quale è il tuo cognome?");
        String cognome = scanner.nextLine();
        System.out.println("Adesso ho bisogno del tuo codice fiscale per favore, puoi digitarlo sotto");
        String codiceFiscale = scanner.nextLine();

        System.out.println("Adesso puoi digitare il codice del tuo documento per favore?");
        String codiceDocumento = scanner.nextLine();
        System.out.println("Quando scade il tuo documento?"); //vince: al momento non formatto la data, ma poi dovrò formattarla - importante controllare anche se non è scaduto
        String scadenzaDocumento = scanner.nextLine();
        System.out.println("Infine, puoi scrivere il tuo indirizzo e-mail?");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cognome, codiceFiscale,email);
        prenotazione.setData(LocalDate.now());
        prenotazione.setImporto(20F); //20 cast in float F
        prenotazione.setCliente(cliente);
        prenotazione.setNumeroPrenotazione("1000");
        prenotazioni.add(prenotazione);
        System.out.println("Il pagamento è andato a buon fine. La prenotazione è stata registrata"); //vince: aggiornare DCD


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

    private AirManager() {

        this.voli = new ArrayList<Volo>(); //private
        //this.prenotazioni = new ArrayList<Prenotazione>(); //private

        //creo voli di esempio e li aggiungo alla lista dei voli
        v1 = new Volo("AZ4697");
        v2 = new Volo("FR1209");
        v3 = new Volo("AZ1406");
        voli.add(v1);
        voli.add(v2);
        voli.add(v3);

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
        //creo prodotti di esempio e li aggiungo alla lista dei prodotti
        /*pr1 = new Prodotto("0001", "Acqua Naturale", 2, 10);
        pr2 = new Prodotto("0002", "Biscotti cioccolato", 3, 10); //provare con float
        prodotti.add(pr1);
        prodotti.add(pr2);*/

    }

    public static AirManager getInstance() {
        if (airManager == null)
            airManager = new AirManager();

        return airManager;
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
	public boolean verificaCorrispondenzaEmail(String prenotazioneTrovata, String email) {
		//
	}

	public boolean verificaCorrispondenzaDocumento(String prenotazioneTrovata, String codiceDocumento) {

	}

	public boolean verificaCondizioniRimborso(Date dataPrenotazione) {

	}

	public void definisciVoloCorrente(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}

	public boolean verificaUnicitaProdotto(String codProdotto1, String codProdotto2) {

	}
	*/

}
