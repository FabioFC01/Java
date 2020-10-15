import java.util.Scanner;

public class MakeLogin3{
    public static void main(String [] args){
        //Flow is opened
        Scanner in = new Scanner (System.in);

        System.out.print("Inserire nella stessa riga nome, cognome e matr : ");
        String nome = in.next();        //nt nextLine()
        String cognome = in.next();
        int matr = in.nextInt();

        String inits = nome.substring(0,1) + cognome.substring(0,1);
        String lg = inits + matr;

        System.out.println(lg);        //Capital letters

        in.close();
    }
}