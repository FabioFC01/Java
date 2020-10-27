import java.util.Scanner;

public class Main{
    public static void main (String [] args){
        //open flow
        Scanner in = new Scanner (System.in);

        //Declaration
        String nome1;
        String nome2;
        String l1 = "";
        String l2 = "";

        //Input
        System.out.print("Inserire nome del primo giocatore   : ");
        nome1 = in.nextLine();
        System.out.print("Inserire nome del secondo giocatore : ");
        nome2 = in.nextLine();

        //new dado object
        Dado dado1 = new Dado();

        //Lanci
        for(int i = 0; i < 3; i++){
            l1 = l1 + dado1.lancia() + " ";
            l1 = l1 + dado1.lancia() + " ";
        }

        //Calcolo vincitore
        System.out.println(dado1.vincitore(nome1, nome2, l1, l2));

        //close flow
        in.close();
    }
}