import java.time.LocalDate;
import java.util.Scanner;

public class Cliente {
    Scanner scanner;
    String Nome;
    String Cognome;
    String codiceFiscale;

    Contatti Contatti; //puntatore
    CartaImbarco CartaImbarco; //puntatore

    public Cliente(String Nome, String Cognome, String codiceFiscale, String email){
        scanner= new Scanner(System.in);
        this.Nome=Nome;
        this.Cognome=Cognome;
        this.codiceFiscale=codiceFiscale;
        Contatti Contatti = new Contatti(email);
        this.Contatti=Contatti;
        CartaImbarco CartaImbarco=new CartaImbarco();
        this.CartaImbarco=CartaImbarco;
        creaCarta();

    }
    private void creaCarta(){
        System.out.println("Grazie "+Nome+", adesso possiamo procedere con il pagamento :)\nAl momento puoi effettuare il pagamento esclusivamente tramite carta, quindi, puoi cortesemente digitare il codice di 16 cifre impresso sulla tua carta di pagamento?");
        String codiceCarta= scanner.nextLine(); //correggere tipo su DCD
        System.out.println("Quando scade la carta?");
        LocalDate scadenzaCarta = LocalDate.parse(scanner.nextLine()); //da formattare e controllare che non sia scaduta
        System.out.println("Digita il codice CVV di 3 cifre per favore, puoi trovarlo sul retro della carta ;)");
        String CVV = scanner.nextLine();
        System.out.println("Il titolare di questa carta sei tu? -> y/n");
        String seiTitolareQuestion = scanner.nextLine();
        String nomeCognomeTitolare;
        if (seiTitolareQuestion.equals("y")) nomeCognomeTitolare=Nome.concat(" "+Cognome);
        else {System.out.println("Inserisci nome e cognome del titolare, per favore");
            nomeCognomeTitolare=scanner.nextLine();
        }
        System.out.println("Scegli un circuito tra quelli disponibili\n1. VISA\n2. MASTERCARD");
        int circuitoQuestion= Integer.parseInt(scanner.nextLine());
        String circuito;
        if (circuitoQuestion==1) circuito="VISA"; else circuito="MASTERCARD";
        CartaPagamento cartaPagamento = new CartaPagamento(20,circuito,nomeCognomeTitolare,codiceCarta,scadenzaCarta,CVV);
    }
    public Contatti getContatti(){
        return this.Contatti;

    }

    public CartaImbarco getCartaImbarco(){
        return CartaImbarco;

    }
}
