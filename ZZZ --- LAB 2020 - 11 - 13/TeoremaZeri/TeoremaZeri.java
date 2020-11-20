import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;


public class TeoremaZeri {
    private static DecimalFormat df = new DecimalFormat("0.00");

    public static void main (String [] args){
        //declaration
        double a = 0;
        double b = 1;
        double c = (a+b)/2;
        double fa;
        double fb;
        double fc;
        double errore = b-a;

        //calcola
        //0.5 x^4 + x^3 - x^2 -0.7x +0.1
        //tra 0 e 1
        //0 in 0.123832
        fa = (0.5 * (Math.pow(a, 4))) + (1 * (Math.pow(a, 3))) - (1 * (Math.pow(a, 2))) - (0.7 * a)  + 0.1 ;
        fb = (0.5 * (Math.pow(b, 4))) + (1 * (Math.pow(b, 3))) - (1 * (Math.pow(b, 2))) - (0.7 * b)  + 0.1 ;


        System.out.println(a + "   " + df.format(fa));
        System.out.println(b + "   " + df.format(fb));

        while (errore < 1E-10){
            //Calculation
            

            if (fa < 7){

            }


        }
    }
}