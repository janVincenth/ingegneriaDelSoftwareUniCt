public class CartaImbarco {
    String numeroCarta; //numeroCarta non ancora generato //da correggere su DCD il tipo
    short postoASedere;
    Cliente cliente;

    //nella corrente iterazione (iterazione 1) non si stanno considerando eventuali servizi extra acquistati

    public CartaImbarco() {
        this.numeroCarta = String.valueOf(0);  // il numeroCarta viene inizializzato a 0, di default,
                                                 // a indicare che non è ancora stato effettuato il check-in e
                                                 // la carta d'imbarco non è stata effettivamente ancora emessa
    }

    public String getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public short getPostoASedere() {
        return postoASedere;
    }

    public void setPostoASedere(short postoSedere) {
        this.postoASedere = postoSedere;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ecco la tua carta d'imbarco:" +
               "\nNome: " + this.cliente.getNome() +
               "\nCognome: " + this.cliente.getCognome() +
               "\nNumero carta d'imbarco: " + this.numeroCarta +
               "\nPosto a sedere: " + (this.postoASedere+1) +
               "\nGrazie per aver utilizzato il servizio di check-in fai da te offerto da Air-Manager! Buon viaggio!\n";
    }

}
