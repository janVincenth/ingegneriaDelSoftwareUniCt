import java.util.HashMap;
import java.util.Map;

public class MappaPostiASedere {
	private Map<Short, Boolean> postiOccupati;
	private short numeroPostiDisponibili;
	
	public MappaPostiASedere(short numeroPostiDisponibili, boolean libero) {
		for(int i=0; i < this.numeroPostiDisponibili; i++) {
			this.postiOccupati = new HashMap<>();
			postiOccupati.put((short)i, libero); //tutti i posti a sedere sono inizialmente liberi
		}
		this.numeroPostiDisponibili = numeroPostiDisponibili;
	}

	public short definisciPosto() {
		//dove viene fatto il controllo numeroPostiDisponibili > 0?
		
		int numeroTotalePosti = this.postiOccupati.size();
		
		boolean postoTrovato = false;
		for(int i=(numeroTotalePosti/3*2-1); i < numeroTotalePosti; i++) {
			if(postiOccupati.get(i).equals(false)){
				postoTrovato = true;	
				return (short) i;
			}
		}
		if(!postoTrovato) {
			for(int i = numeroTotalePosti/3-1; i < numeroTotalePosti/3*2; i++) {
				if(postiOccupati.get(i).equals(false)){
					postoTrovato = true;	
					return (short) i;
				}
			}
		}
		for(int i = 0; i < numeroTotalePosti/3; i++) {
			if(postiOccupati.get(i).equals(false)){
				postoTrovato = true;	
				return (short) i;
			}
		}
		return 1;
	}
	
	public Map<Short, Boolean> getPostiOccupati() {
		return postiOccupati;
	}
	
	/*
	public void setPostiOccupati(Map<Short, Boolean> postiOccupati) {
		this.postiOccupati = postiOccupati;
	}
	*/

	public short getNumeroPostiDisponibili() {
		return numeroPostiDisponibili;
	}

	public void setNumeroPostiDisponibili(short numeroPostiDisponibili) {
		this.numeroPostiDisponibili = numeroPostiDisponibili;
	}
	
}
