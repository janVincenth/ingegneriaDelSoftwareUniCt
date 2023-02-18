import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AirManager {
	//aggiungere metodi getters & setters
	private static AirManager airManager;
	
	//collezioni
	private ArrayList<Volo> voli;
	//private ArrayList<Prenotazione> prenotazioni; 
	private ArrayList<Prodotto> prodotti; 
	//istanze
	private Volo v1, v2, voloCorrente;
	private Prodotto pr1, pr2;
	//private Prenotazione p1, p2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Benvenuto in Air-Manager!\nStai utilizzando il software come impiegato o come cliente?");
		
		String user = scanner.nextLine().toLowerCase();
		
		if(user.equals("cliente")) { //utilizzo da parte di un cliente
			routineCliente(scanner);
		}
		else if(user.equals("impiegato")) { //utilizzo da parte di un impiegato
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

	private static void effettuaPrenotazione(Scanner scanner) {

		String aeroportoPartenza;
		String aeroportoDestinazione;
		LocalDate dataPartenza;

		System.out.println("\nInserisci l'aeroporto di partenza"); //da implementare una lista di aeroporti da cui scegliere tramite elenco puntato
		String aeroportoPartenza= scanner.nextLine().toLowerCase();
		System.out.println("\nInserisci l'aeroporto di arrivo"); //come sopra
		String aeroportoDestinazione= scanner.nextLine().toLowerCase();
		System.out.println("\nInserisci la data di partenza nel formato dd/mm/yyyy");
		LocalDate dataPartenza= ;
		//matchPreferenze()
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
	    voli.add(v1);
	    voli.add(v2);
	    
	    //creo ricorrenze di esempio e li aggiungo a ciascun volo
	    
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
	
	public static void printMenu(String[] strings) {
		for(String string : strings)
			System.out.println(string);
		System.out.println("\nInserisci il numero dell'operazione che vuoi effettuare: ");
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
