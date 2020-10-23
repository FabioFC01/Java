import java.util.Random;

public class NumbersInColumns {
    public static void main (String [] args){
        //start 
        Random generator = new Random();
        double pi = 426452.45;
        double p  = 45.782;

        //declaration
        double [] num = new double[50];

        //creation
        for (int i = 0; i < 50 ; i++){
            num[i] = generator.nextDouble();
            num [i] *= 1000;
        }

        //output
        for (int i = 0; i < 50 ; i++){
            System.out.format("%10.4f%n", num[i]);
        }

        /*OUTPUT
        188,3732
        884,7614
         12,4993
        783,4601
        170,5567
        902,7648
        */

        
/*
        System.out.format("%f%n", pi);       // -->  "3.141593"
        System.out.format("%.3f%n", pi);     // -->  "3.142"
        System.out.format("%10.3f%n", pi);   // -->  "     3.142"
        System.out.format("%-10.3f%n", pi);  // -->  "3.142"
        System.out.format("%-10.4f%n%n", pi); // -->  "3,1416"
        System.out.format("%10.4f%n%n", pi); // -->  "3,1416"
        System.out.format("%10.4f%n%n", p); // -->  "3,1416"
*/
    }
}