import java.util.Scanner;

public class DoubleDivider {
    public static void main (String [] args){
        Scanner in = new Scanner(System.in);

        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = a/b;

        System.out.print(c);

    }
}