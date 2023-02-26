import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class RicorrenzaDiVolo {
	private LocalDate dataPartenza;
	private LocalDate dataArrivo;
	private LocalTime oraPartenza;
	private String aeroportoPartenza;
	private String aeroportoArrivo;
	private Volo voloAssociato;
	private MappaPostiASedere mappaAssociata;
	private int durataNominale;

	public float getPrezzo() {
		return prezzo;
	}

	private float prezzo;
	
	//volo associato va in costruttore?
	public RicorrenzaDiVolo(LocalDate DataPartenza,
		   String aeroportoPartenza, String aeroportoArrivo, Volo voloAssociato, int durataNominale, float prezzo) {
		this.dataPartenza = DataPartenza;
		this.aeroportoArrivo=aeroportoArrivo;
		this.aeroportoPartenza = aeroportoPartenza;
		this.voloAssociato = voloAssociato;
		this.durataNominale = durataNominale;
		this.prezzo=prezzo;
	}
	
	/*public RicorrenzaDiVolo getRicorrenzaPerPreferenze(String partenza, String destinazione, LocalDate data, LocalTime ora) {
		//da implementare
	}*/
	
	//eliminare da questa classe
	/*public ArrayList<RicorrenzaDiVolo> creaListaRicorrenze(){
		ArrayList<RicorrenzaDiVolo> prodotti = new ArrayList<RicorrenzaDiVolo>();
		return ricorrenze;
	}*/
	
	//addRicorrenza costituisce un'operazione standard su List fatta da main in Air-Manager
	
	public Volo getVolo() {
		return this.voloAssociato;
	}

	public LocalDate getDataPartenza() {
		return dataPartenza;
	}

	public void setDataPartenza(LocalDate dataPartenza) {
		this.dataPartenza = dataPartenza;
	}

	public LocalDate getDataArrivo() {
		return dataArrivo;
	}

	public void setDataArrivo(LocalDate dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public LocalTime getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(LocalTime oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public String getAeroportoPartenza() {
		return aeroportoPartenza;
	}

	public void setAeroportoPartenza(String aeroportoPartenza) {
		this.aeroportoPartenza = aeroportoPartenza;
	}

	public String getAeroportoArrivo() {
		return aeroportoArrivo;
	}

	public void setAeroportoArrivo(String aeroportoArrivo) {
		this.aeroportoArrivo = aeroportoArrivo;
	}

	public Volo getVoloAssociato() {
		return voloAssociato;
	}

	public void setVoloAssociato(Volo voloAssociato) {
		this.voloAssociato = voloAssociato;
	}

	public MappaPostiASedere getMappaAssociata() {
		return mappaAssociata;
	}

	public void setVoloAssociato(MappaPostiASedere mappaAssociata) {
		this.mappaAssociata = mappaAssociata;
	}
	public int getDurataNominale() {
		return durataNominale;
	}

	public void setDurataNominale(int durataNominale) {
		this.durataNominale = durataNominale;
	}

	public void setMappaAssociata(MappaPostiASedere mappaAssociata){
		this.mappaAssociata=mappaAssociata;
	}
}
