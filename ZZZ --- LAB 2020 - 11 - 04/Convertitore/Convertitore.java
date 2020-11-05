import java.util.Scanner;

public class Convertitore{
    public static void main (String [] args){
        //open flow
        Scanner in = new Scanner (System.in);

        //Output
        System.out.println("Inserire numero in base 10 e base desiderata in riga");

        //declaration
        int numInt           = in.nextInt();    //base 10
        int baseDesiderata   = in.nextInt();    //base desiderata
        String numFinale     = "";

        int a = numInt;
        int q = 1;
        int r = 0;

        //close flow
        in.close();

        while(q != 0){
            q = a / baseDesiderata;
            r = a % baseDesiderata;
            numFinale = r + numFinale;
            a = q;
        }
        System.out.println(numInt + "  in base 10  =   " + numFinale  + "  in base  " + baseDesiderata);
    }
}