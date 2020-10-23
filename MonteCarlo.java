//Approssimazione pi greco in cerchio
//con centro (0,0) e raggio 1

import java.util.Random;

public class MonteCarlo{
    public static void main(String[] args){
        final int TRIES = 1000000; //1M
        Random generator = new Random();

        int hits = 0;
        for(int i = 1; i <= TRIES; i++){
            //creates two casual numbers between -1 and 1

            double r = generator.nextDouble();
            double x = -1 + ( r * 2 );
            r = generator.nextDouble();
            double y = -1 + ( r * 2 );

            //hits is increased by 1 if the point is
            //inside the circle (x^2)+(y^2)=1
            if((x*x) + (y*y) <= 1){
                hits++;
            }
        }
        //the rate hits / tries is gonna be
        //similar to pi/4

        double piEstimate = 4.0 * ((double)hits / TRIES);
        System.out.println ("hits : " + hits);
        System.out.println ("TRIES : " + TRIES);

        System.out.println ("Estimate for pi : " + piEstimate);
    }
}