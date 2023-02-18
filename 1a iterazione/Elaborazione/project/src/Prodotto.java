import java.util.ArrayList;

//no class descrizioneProdotto
public class Prodotto {
	private String codiceProdotto;
	private String denominazione;
	private float prezzo;
	private int sottoscorta;
	private String lottoDiProduzione;
	
	public Prodotto(String codiceProdotto, String denominazione, int prezzo, int sottoscorta) {
		this.codiceProdotto = codiceProdotto;
		this.denominazione = denominazione;
		this.prezzo = prezzo;
		this.sottoscorta = sottoscorta;
		//e il lottoDiProduzione?
	}
	
	//inserisciProdotto e addProdotto coincidono; sono entrambe operazioni standard su List fatte da main in Air-Manager

	//eliminare da questa classe
		public ArrayList<Prodotto> creaListaProdotti(){
			ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
			return prodotti;
		}
	
	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public int getSottoscorta() {
		return sottoscorta;
	}

	public void setSottoscorta(int sottoscorta) {
		this.sottoscorta = sottoscorta;
	}

	public String getLottoDiProduzione() {
		return lottoDiProduzione;
	}

	public void setLottoDiProduzione(String lottoDiProduzione) {
		this.lottoDiProduzione = lottoDiProduzione;
	}
}
