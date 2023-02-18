public class Cliente {
    String Nome;
    String Cognome;
    String codiceFiscale;

    Contatti Contatti; //puntatore
    CartaImbarco CartaImbarco; //puntatore

    private String Cliente(String Nome, String Cognome, String codiceFiscale){
        this.Nome=Nome;
        this.Cognome=Cognome;
        this.codiceFiscale=codiceFiscale;
        Contatti Contatti = new Contatti("cliente@gmail.com");
        this.Contatti=Contatti;
        CartaImbarco CartaImbarco=new CartaImbarco();
        this.CartaImbarco=CartaImbarco;
        return codiceFiscale;

    }
    public Contatti getContatti(){
        return this.Contatti;

    }

    public CartaImbarco getCartaImbarco(){
        return CartaImbarco;

    }
}
