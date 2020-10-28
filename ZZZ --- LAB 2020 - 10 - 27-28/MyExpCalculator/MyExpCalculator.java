import java.util.Scanner;
import java.lang.Math;

public class MyExpCalculator{
    public static void main (String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);

        double inp = in.nextDouble();

        //Close flow
        in.close();

        //declaration
        int MAX = 50; //5M
        double risultato = 0;
        double numeratore = 0;
        double denominatore = 1;

        //calculations
        for (int i = 0; i < MAX; i++){
            denominatore = 1;
            numeratore = Math.pow(inp, i);
            int j = 1;
            while( j <= i) {
                denominatore *= j;
                j++;
            }
            risultato += numeratore / denominatore;
        }

        System.out.println(risultato);
        System.out.println(Math.exp(inp));

    }
}
/*
7
1096.6331584284578  - mio
1096.6331584284585  - Math.exp
*/