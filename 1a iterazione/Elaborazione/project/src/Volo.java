package classes;

import java.util.ArrayList;

public class Volo {
	private String numeroVolo;
	
	public Volo(String numeroVolo) {
		this.numeroVolo = numeroVolo;
	}
	
	//eliminare da questa classe
	public ArrayList<Volo> creaListaVoli(){
		ArrayList<Volo> voli = new ArrayList<Volo>();
		return voli;
	}

	public boolean(Volo volo) {
		//...
	}
	
	public String getNumeroVolo() {
		return this.numeroVolo;
	}

	public void setNumeroVolo(String numeroVolo) {
		this.numeroVolo = numeroVolo;
	}
	
}
