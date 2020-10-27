import java.util.Scanner;
import java.util.Locale;

public class Input {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        //in.useLocale(Locale.ITALY);

        String inp = in.nextLine();
        int length = inp.length();
        int i = 0;
        while (inp.charAt(i) != (int)','){
            i++;
        }
        String intero = inp.substring(0, i);
        String frazione = inp.substring(i+1, length);
        inp = intero + "." + frazione;

        double finale = Double.parseDouble(inp);


        System.out.format(Locale.ITALY, "%f", finale);

        in.close();

    }
}