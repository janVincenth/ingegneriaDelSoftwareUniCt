package classes;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class AirManager {
	//aggiungere metodi getters & setters
	private static AirManager airManager;
	
	//collezioni
	private ArrayList<Volo> voli;
	private ArrayList<Prenotazione> prenotazioni; 
	private ArrayList<Prodotto> prodotti; 
	//istanze
	private Volo v1, v2, voloCorrente;
	private Prodotto prodotto1, prodotto2;
	private Prenotazione prenotazione1, prenotazione2;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Benvenuto in Air-Manager!");
		System.out.println("Stai utilizzando il software come impiegato o come cliente?");
		
		String user = scanner.nextLine().toLowerCase();
		
		if(user.equals("cliente")) { //utilizzo da parte di un cliente
			System.out.println("Indica quale operazione vuoi effettuare fra le seguenti (specificane il numero): ");
			System.out.println("1. Effettuare una prenotazione (Acquisto biglietto)");
			System.out.println("2. Cancellare una prenotazione");
			System.out.println("3. Effettuare il check-in");
			
			int request = Integer.parseInt(scanner.nextLine());
			
			switch(request) {
				case 1:
					//code block
					System.out.println('1');
					//da implementare
					break;
				case 2:
					//code block
					System.out.println('2');
					//da implementare
					break;
				case 3:
					//code block
					System.out.println('3');
					//da implementare
					break;
			}
		}
		else if(user.equals("impiegato")) { //utilizzo da parte di un impiegato
			System.out.println("Indica quale operazione vuoi effettuare fra le seguenti (specificane il numero): ");
			System.out.println("Gestire scheda anagrafica prodotto");
			System.out.println("Effettua carico di magazzino per approvvigionamento aeromobile");
			System.out.println("Stampare lista dei prodotti in sottoscorta");
			
			int request = Integer.parseInt(scanner.nextLine());
			
			switch(request) {
				case 1:
					//code block
					System.out.println('1');
					//da implementare
					break;
				case 2:
					//code block
					System.out.println('2');
					//da implementare
					break;
				case 3:
					//code block
					System.out.println('3');
					//da implementare
					break;
			}
			
		}
		else System.out.println("Il valore inserito non è valido. Ritenta.");
		
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
	
	/*public void setVolo(String numeroVolo) {
		this.voloCorrente.numeroVolo = numeroVolo;
	}
	*/
	
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
	}
}
