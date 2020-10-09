import java.util.*;

public class Flower{
    // dichiarazione
    protected String nome_fiore;
    protected int petali;
    protected float prezzo;         //euro

    //Costruttori
    public Flower () {
        nome_fiore = "Margherita";
        petali = 12;
        prezzo = 0.25f;
    }

    public Flower (String nm, int pet, float pr){
        nome_fiore = nm;
        petali = pet;
        prezzo = pr;
    }

    public static void main(String [] args){
        //Dichiarazione variabili
      //  boolean nuovo = true;
       // String nm = "";
        //String risposta = "";
        int pet = 0;
        float pr = 0;
        int numero = 0;
        int contatore = 0;
        //Inizializzazione costruttore primo fiore
      //  Flower margherita = new Flower();   //Si chiama margherita

        Scanner scan = new Scanner(System.in);

        System.out.println("Quanti fiori devi inserire?");
        numero = scan.nextInt();
        Flower[] yeah = new Flower[numero];


        do{
           // System.out.println("Vuoi inserire un nuovo fiore?");
            
            System.out.println("Nome");
            scan.nextLine();
            String nm = scan.nextLine();
            System.out.println("Petali");
            pet = scan.nextInt();
            System.out.println("Prezzo");
            pr = scan.nextFloat();
            yeah[contatore] = new Flower(nm,pet,pr);
            contatore++;
        } while (contatore < numero);

        scan.close();

        for (contatore = 0; contatore < numero; contatore++){
            System.out.println((contatore+1) + "  " + yeah[contatore].nome_fiore + "  " + yeah[contatore].petali + "  " + yeah[contatore].prezzo);
        }
    }
}