import java.util.Scanner;
import java.util.Locale;

public class Convenzioni{
    public static void main (String [] args){
        //Open flow with US convenction
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);         // usa la convenzione USA

        System.out.print("Inserire numero a virgola mobile : ");

        String input = in.next();
        double num3 = Double.parseDouble(input);
        System.out.println(num3);                      //punto
        System.out.format(Locale.ITALY, "%f", num3);  //virgola
        System.out.println();


        double d = 12.3; 
        System.out.format(Locale.ITALY, "%f", d); 

        //close flow
        in.close();
    }
}