import java.util.Scanner;

public class PrimeNumberRicognizer {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        //declaration
        int num = in.nextInt();
        boolean primeNum= true;
        int divisore = 0;

        //calculation
        int max = (int) Math.sqrt(num);

        //iteration
        for (int i = max; i >= 2; i--){
            if(num % i == 0){
                primeNum = false;
                divisore = i;
            }
        }

        //output
        if(num == 1){
            System.out.println("1 non è primo");
        }
        else if(primeNum == true){
            System.out.println("Il numero  " + num + " è primo");
        }
        else{
            System.out.println("Il numero  " + num + " non è primo, è divisibile per " + divisore);
        }
    }
}