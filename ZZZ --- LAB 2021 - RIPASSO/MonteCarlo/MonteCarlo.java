public class MonteCarlo {
   public static void main (String [] args) {
      //variabili di esemplare
      int tentativi = 0;
      int hits = 0;

      final long TOTAL_TRIES = 100000000l;

      double x = 0;
      double y = 0;


      //formula cerchio : 

      for (tentativi = 0; tentativi < TOTAL_TRIES; tentativi++) {
         x = (2*Math.random())-1;
         y = (2*Math.random())-1;

         if (x*x + y*y <= 1) { // se rientra nel cerchio
            hits++;
         }
         
      }

      //time for calcoli
      /*
      x^2 + y^2 <= 1
      quindi area = pi*r^2 = pi
      */

      final double AREA_CERCHIO = Math.PI * Math.pow(1, 2); //PI
      final double AREA_QUADRATO = Math.pow(2, 2); //4
      final double ESTIMATE_PI = 4.0*((double)hits/TOTAL_TRIES);



      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("Hits totali : " + hits);
      System.out.println("Hits percentuali : " + ((double)hits/TOTAL_TRIES)*100.0 + " %");
      System.out.printf("Rapporto area cerchio / quadrato :   %13.7f  %n" , ((double)AREA_CERCHIO/AREA_QUADRATO));
      System.out.println("PI : " +  Math.PI);
      System.out.printf("Stima PI : %39.7f", ESTIMATE_PI);



   }
}