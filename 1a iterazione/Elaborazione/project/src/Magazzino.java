package classes;

public class Magazzino {
	private String idMagazzino;
	private int giacenzaAttuale;
	private int ammanco;
	
	public Magazzino(String idMagazzino, int giacenzaAttuale, int ammanco) {
		this.idMagazzino = idMagazzino;
		this.giacenzaAttuale = giacenzaAttuale;
		this.ammanco = ammanco;
	}

	public String getIdMagazzino() {
		return idMagazzino;
	}

	public void setIdMagazzino(String idMagazzino) {
		this.idMagazzino = idMagazzino;
	}

	public int getGiacenzaAttuale() {
		return giacenzaAttuale;
	}

	public void setGiacenzaAttuale(int giacenzaAttuale) {
		this.giacenzaAttuale = giacenzaAttuale;
	}

	public int getAmmanco() {
		return ammanco;
	}

	public void setAmmanco(int ammanco) {
		this.ammanco = ammanco;
	}
}
