import java.util.HashMap;
import java.util.Map;

public class MappaPostiASedere {
	private HashMap<Short, Boolean> postiOccupati;
	private short numeroPostiDisponibili;
	
	public MappaPostiASedere(short numeroPostiDisponibili, boolean libero) {
		postiOccupati= new HashMap<Short, Boolean>();
		this.numeroPostiDisponibili = numeroPostiDisponibili;
		for(int i=0; i < this.numeroPostiDisponibili; i++) {
			postiOccupati.put((short)i, libero); //tutti i posti a sedere sono inizialmente liberi
		}

	}

	public short definisciPosto() {
		int numeroTotalePosti = this.postiOccupati.size();
		short numeroPostoProposto = (short)(numeroTotalePosti+1);
		
		boolean postoTrovato = false;
		for(int i=(numeroTotalePosti/3*2); i < numeroTotalePosti; i++) { //posti economy
			if(this.postiOccupati.get((short)i).equals(false)){
				postoTrovato = true;
				numeroPostoProposto  = (short) i;
				break;
			}
		}
		if(!postoTrovato) {
			for(int i = numeroTotalePosti/3; i < numeroTotalePosti/3*2; i++) { //posti in seconda classe
				if(postiOccupati.get((short)i).equals(false)){
					postoTrovato = true;
					numeroPostoProposto  = (short) i;
					break;
				}
			}
		}
		if(!postoTrovato){
			for(int i = 0; i < numeroTotalePosti/3; i++) {
				if(postiOccupati.get((short)i).equals(false)){ //posti in prima classe
					postoTrovato = true;
					numeroPostoProposto  = (short) i;
					break;
				}
			}
		}

		return numeroPostoProposto;
	}
	
	public HashMap<Short, Boolean> getPostiOccupati() {
		return postiOccupati;
	}
	
	public void setPostiOccupati(Short numeroPostoProposto) {
		this.postiOccupati.put(numeroPostoProposto, true);
		this.numeroPostiDisponibili--;
	}


	public short getNumeroPostiDisponibili() {
		return numeroPostiDisponibili;
	}

	public void setNumeroPostiDisponibili(short numeroPostiDisponibili) {
		this.numeroPostiDisponibili = numeroPostiDisponibili;
	}
	
}
