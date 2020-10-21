import java.util.Scanner;

public class IntegerDivider {
    public static void main (String [] args) {
        Scanner in = new Scanner (System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = a / b;

        in.close();

        System.out.println(c);
    }
}