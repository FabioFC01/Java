import java.util.Scanner;

public class Multiplo {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        //declaration
        int m = in.nextInt();
        int max = in.nextInt();

        System.out.println("Multipli di " + m + " da 1 a " + max + "  :  ");
        for (int i = 1; i < max; i ++){
            if(i % m == 0){
                System.out.println(i);
            }
        }

        in.close();
    }
}