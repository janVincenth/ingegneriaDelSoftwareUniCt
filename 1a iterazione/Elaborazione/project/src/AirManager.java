import java.time.LocalTime;
import java.util.*;
import java.time.LocalDate;

public class AirManager {
	//aggiungere metodi getters & setters
	private static AirManager airManager;

	//collezioni
	private ArrayList<Volo> voli;
	private ArrayList<Prenotazione> prenotazioni;
	private ArrayList<Prodotto> prodotti;
	private static Map<String, String> aeroporti;
	//istanze
	//
	private Volo v1, v2, voloCorrente;
	private Prodotto pr1, pr2;
	private Prenotazione p1, p2;
	private Cliente cl1;
	private Contatti c1;

	public static void main(String[] args) {
		airManager = AirManager.getInstance();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Benvenuto in Air-Manager!\nStai utilizzando il software come impiegato o come cliente?");

		String[] userOptions = {"1. Cliente", "2. Impiegato"};
		airManager.printMenu(userOptions);

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
		String[] clientOptions = {"1. Effettua una prenotazione (Acquisto biglietto)",
								  "2. Cancella una prenotazione",
								  "3. Effettua il check-in",
								  "4. Modifica una prenotazione già esistente",
								  "5. Esci da Air-Manager"
								 };
		int option = 0;
		while(option != 5) {
			System.out.println("\nSpecifica il numero dell'operazione che desideri effettuare fra le seguenti: ");
			airManager.printMenu(clientOptions);

			option = Integer.parseInt(scanner.nextLine());

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
					effettuaCheckIn(scanner);
					break;
				case 4:
					System.out.println('4');
					// modificaPrenotazione();
					break;
				case 5: {
					System.out.println("\nGrazie per aver utilizzato Air-Manager!");
					System.exit(0);
					}
			}
		}
	}

	private static void effettuaCheckIn(Scanner scanner) {
		System.out.println("Benvenuto nella procedura di check-in! Si prega di inserire il numero della prenotazione per cui effettuare il check-in");
		//cliente inserisce numeroPrenotazione
		String numeroPrenotazioneInput = scanner.nextLine().toLowerCase();

		Prenotazione p = airManager.getPrenotazione(airManager.prenotazioni, numeroPrenotazioneInput);
		if(p == null) //al momento non è data la possibilità di provare più volte consecutivamente, per semplicità
			System.out.println("Non è stata trovata alcuna prenotazione avente il numero prenotazione inserito.");
		else {
			System.out.println("\nÈ stata trovata una prenotazione avente il seguente codice: " + numeroPrenotazioneInput + ". Si prega di inserire il codice del proprio documento d'identità:");
			String codiceDocumento = scanner.nextLine().toLowerCase();
			String codiceDocumentoPrenotazione = p.getDocumentoIdentita().getCodiceDocumento();
			//if(!airManager.verificaCorrispondenzaDocumento(codiceDocumentoPrenotazione, codiceDocumento)) //differente da metodo DCD
			//if(codiceDocumentoPrenotazione.equals(codiceDocumento))
			if("AX00".equals(codiceDocumento))
				System.out.println("Il codice documento fornito non corrisponde a quello associato alla prenotazione indicata.");
			else System.out.println("\nCodice documento valido. Si prega di inserire la mail utilizzata in fase di prenotazione:");
				String email = scanner.nextLine().toLowerCase();
				String emailPrenotazione = p.getCliente().getContatti().getEmail();
				//if(!airManager.verificaCorrispondenzaEmail(emailPrenotazione, email)) //differente da metodo in DCD
				if(!emailPrenotazione.equals(email))
				//if("a@hotmail.com".equals(email))
					System.out.println("L'email fornita non corrisponde a quella associata alla prenotazione indicata.");
				else System.out.println("\nEmail valida.");

				//determino posto da proporre al cliente
				short numeroPostoProposto = p.getRicorrenza().getMappaAssociata().definisciPosto();

				System.out.println("Air-Manager ti propone il seguente posto a sedere: " + numeroPostoProposto + "\nAccetti?\n1. Sì\n2. No");
				int option = scanner.nextInt();
				if(option == 1) // scenario di successo
					System.out.println("Posto accettato. Aggiorno mappa... (da continuare)");//aggiorna mappa setMappa
				else System.out.println("Posto rifiutato (da continuare)");
		}
	}

	private static void effettuaPrenotazione(Scanner scanner) {

		String aeroportoPartenza;
		String aeroportoDestinazione;
		LocalDate dataPartenza;
		aeroporti = new HashMap<>();

		//INIZIALIZZO LA COLLEZIONE CON AEROPORTI PRE-SELEZIONATI
		aeroporti.put("CTA","FONTANAROSSA (Catania)");
		aeroporti.put("FCO","FIUMICINO (Roma)");
		aeroporti.put("FLR","PERETOLA (Firenze)");


		System.out.println("\nEcco la lista degli aeroporti da cui puoi partire! \nPer favore, scegli un aeroporto di partenza digitando il codice IATA corrispondente:"); //da implementare una lista di aeroporti da cui scegliere tramite elenco puntato

		Iterator<Map.Entry<String, String>> demoAeroporti = aeroporti.entrySet().iterator();
		while(demoAeroporti.hasNext()){
			Map.Entry<String, String> demoAeroporto= demoAeroporti.next();
			System.out.println("Codice IATA: " + demoAeroporto.getKey() + " - Denominazione: " + demoAeroporto.getValue() );
		}

		aeroportoPartenza= scanner.nextLine();

		System.out.println("\nBene, partirai da: " +aeroporti.get(aeroportoPartenza) +". \nAdesso cortesemente digita il codice IATA dell'aeroporto di arrivo"); //come sopra



		/*String aeroportoDestinazione= scanner.nextLine().toLowerCase();
		System.out.println("\nInserisci la data di partenza nel formato dd/mm/yyyy");
		LocalDate dataPartenza=  ;
		matchPreferenze()*/
	}

	private static void routineImpiegato(Scanner scanner) {
		String[] employedOptions = {"1. Gestisci volo",
									"2. Gestisci schedulazione volo",
									"3. Assegna promozione",
									"4. Gestisci anagrafica prodotto",
									"5. Effettua carico di magazzino",
									"6. Stampa lista dei prodotti in sottoscorta",
									"7. Esci da Air-Manager"
									};
		int option= 0;
		while(option != 7) {
			System.out.println("\nSpecifica il numero dell'operazione che desideri effettuare fra le seguenti: ");
			airManager.printMenu(employedOptions);
			option = Integer.parseInt(scanner.nextLine());

			switch (option) {
				case 1:
					System.out.println('1');
					// gestisciVolo();
					break;
				case 2:
					System.out.println('2');
					// gestisciSchedulazioneVolo();
					break;
				case 3:
					System.out.println('3');
					// assegnaPromozione();
					break;
				case 4:
					System.out.println('4');
					// gestisciSchedaAnagraficaProdotto();
					break;
				case 5:
					System.out.println('5');
					// effettuaCaricoMagazzino();
					break;
				case 6:
					//code block
					System.out.println('6');
					//stampaListaProdottiInSottoscorta();
					break;
				case 7: {
					System.out.println("\nGrazie per aver utilizzato Air-Manager!");
					System.exit(0);
				}
			}
		}
	}

	private AirManager() {

		this.voli = new ArrayList<Volo>(); //private
		this.prenotazioni = new ArrayList<Prenotazione>(); //private
		this.prodotti = new ArrayList<Prodotto>(); //private

		//creo voli di esempio e li aggiungo alla lista dei voli
	    v1 = new Volo("AZ4697");
	    v2 = new Volo("FR1209");
	    voli.add(v1);
	    voli.add(v2);

	    //creo ricorrenze di esempio e li aggiungo a ciascun volo

	    //creo prenotazioni di esempio e le aggiungo alla lista delle prenotazioni
	    p1 = new Prenotazione();
	    p1.setNumeroPrenotazione("ABCDEF012345");
	    p1.setData(LocalDate.of(2023, 1, 10));
	    p1.setImporto((float)50); //capire gestione float
	    p2 = new Prenotazione();
	    p2.setNumeroPrenotazione("GHILMN012345");
	    p2.setData(LocalDate.of(2020, 9, 9));
	    p2.setImporto((float)50); //capire gestione float
	    prenotazioni.add(p1);
	    prenotazioni.add(p2);

	    //creo prodotti di esempio e li aggiungo alla lista dei prodotti
	    pr1 = new Prodotto("0001", "Acqua Naturale", 2, 10);
	    pr2 = new Prodotto("0002", "Biscotti cioccolato", 3, 10); //provare con float
	    prodotti.add(pr1);
	    prodotti.add(pr2);

	}

	public static AirManager getInstance() {
		if (airManager == null)
			airManager = new AirManager();
		else
			System.out.println("Esiste già un'istanza di AirManager");

		return airManager;
	}

	public void printMenu(String[] strings) {
		for(String string : strings)
			System.out.println(string);
		System.out.println("\nEffettua una scelta: "); //MODIFICATO PERCHè QUANDO SCEGLI L'USER NON HA SENSO PARLARE DI OPERAZIONI
	}
	
	/*public void setVolo(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}
	*/

	public Prenotazione getPrenotazione(ArrayList<Prenotazione> prenotazioni, String numeroPrenotazioneInput){
		for(int i = 0; i < prenotazioni.size(); i++){
			String numeroPrenotazione = prenotazioni.get(i).numeroPrenotazione;
			if(numeroPrenotazione.toLowerCase().equals(numeroPrenotazioneInput))
				return prenotazioni.get(i);
		}
		return null;
	}
	public boolean verificaCorrispondenzaEmail(String emailPrenotazione, String email) {
		return true; //non implementato né utilizzato, al momento
	}
	
	public boolean verificaCorrispondenzaDocumento(String prenotazioneTrovata, String codiceDocumento) {
		return true; //non implementato né utilizzato, al momento
	}

	/*
	public boolean verificaCondizioniRimborso(Date dataPrenotazione) {
		
	}

	public void definisciVoloCorrente(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}
	
	public boolean verificaUnicitaProdotto(String codProdotto1, String codProdotto2) {
	
	}
	*/
	
}
