import java.util.Scanner;

public class MaxSottostringaTester {
    public static void main (String [] args){
        //Inizio
        //Open flow
        Scanner in = new Scanner (System.in);

        System.out.println("Inserire parola num 1 : ");
        String par1 = in.next();
        System.out.println("Inserire parola num 2 : ");
        String par2 = in.next();

        //Close flow
        in.close();

        //Chiamata classe
        MaxSottostringa test = new MaxSottostringa(par1, par2);
        String result = test.Calcolo();


        System.out.println("---   NUMERO DI ITERAZIONI  ---");
        System.out.println(test.getContatore());

        System.out.println("--- SOTTOSTRINGA PIU' LUNGA ---");
        System.out.println(result);

    }
}