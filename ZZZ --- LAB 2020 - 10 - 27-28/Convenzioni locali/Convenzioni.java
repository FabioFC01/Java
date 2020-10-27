import java.util.Scanner;
import java.util.Locale;

public class Convenzioni{
    public static void main (String [] args){
        //Open flow with US convenction
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);         // usa la convenzione USA

        System.out.print("Inserire numero a virgola mobile : ");
        String input = in.nextLine();
        double num = Double.parseDouble(input);
        System.out.println(num);

        //close flow
        in.close();

        //-------------------------------
        //Open a new flow
        Scanner nuovo = new Scanner(System.in);

        System.out.print("Inserire numero a virgola mobile : ");
        input = nuovo.nextLine();
        num = Double.parseDouble(input);
        System.out.println(num);

        //close flow
        nuovo.close();

    }
}