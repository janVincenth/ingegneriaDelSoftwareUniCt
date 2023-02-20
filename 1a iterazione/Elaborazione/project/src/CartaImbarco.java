public class CartaImbarco {
    int numeroCarta = 0; //numeroCarta non ancora generato //da correggere su DCD il tipo

    short postoASedere;
    String nome;
    String cognome;
    Cliente cliente;
    //non stiamo considerando i servizi extra al momento

    public CartaImbarco() {
    }


    /*
    public String CartaImbarco(short numeroPostoProposto){
        numeroCarta="20231616161616161616";
        postoSedere=3;
        return numeroCarta;
    }
    */

    public int getNumeroCarta() {
        return numeroCarta;
    }

    public void setNumeroCarta(int numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    public short getPostoASedere() {
        return postoASedere;
    }

    public void setPostoASedere(short postoSedere) {
        this.postoASedere = postoSedere;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
