import java.util.Scanner;

public class MakeLogin2{
    public static void main(String[] args){
        //Apertura del flusso ---> flow is opened
        Scanner in = new Scanner(System.in);

        //String sent to terminal
        System.out.print("Inserire il nome : ");
        //Receive next word
        String nome = in.next();

        System.out.print("Inserire il cognome : ");
        String cognome = in.next();

        System.out.print("Inserire la matricola : ");
        int matr = in.nextInt();

        String inits = nome.substring(0,1) + cognome.substring(0,1);
        String lg = inits.toLowerCase() + matr;

        System.out.println("La login e' : " + lg);

        in.close();
    }
}