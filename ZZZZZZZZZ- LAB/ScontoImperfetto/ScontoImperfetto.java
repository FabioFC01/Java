/**
  * DoubleDivider
  *
  * @version 10-Ott-2005
  * @author Adriano Luchetta
  *
  * copyright: not applicable
  *
  * Classe che applica uno sconto di 50 unita' a un importo
  * pari a 100 milioni di miliardi di unita'
  *
  */

  import java.util.Locale;

  public class ScontoImperfetto
  {
     public static void main(String[] args)
     {
        final double AMOUNT = 1.0e+17;
        final int DISCOUNT = 50;
  
        double doubleResult = AMOUNT - DISCOUNT;          // calcolo in formato double
        long longResult = ((long) AMOUNT) - DISCOUNT;     // calcolo in formato long
  
        // Aritmetica dei numeri in formato IEEE754 doppia precisione (double)
        System.out.println();
        System.out.println("Se il calcolo e' svolto con numeri in formato ");
        System.out.println("double (IEEE754 doppia precisione) si ottiene:");
        System.out.println();
        System.out.printf(Locale.US, "%20.1f -", AMOUNT);
        System.out.println();
        System.out.printf(Locale.US, "%20.1f", (double) DISCOUNT);
        System.out.println();
        System.out.println("____________________ =");
        System.out.printf(Locale.US, "%20.1f  !!!",  doubleResult);
        System.out.println("   e le due lire dove si sono perse???");
        System.out.println();
  
        // Aritmetica dei numeri interi a 64 bit (long)
        System.out.println();
        System.out.println("Se, invece, il calcolo e' svolto con numeri in formato ");
        System.out.println("long (interi a 64 bit) si ottine:");
        System.out.println();
        System.out.println((long) AMOUNT + " -");
        System.out.printf(Locale.US, "%18d", DISCOUNT);
        System.out.println();
        System.out.println("__________________ =");
        System.out.printf(Locale.US, "%18d   !!!", longResult);
        System.out.println("  le due lire non si sono perse!!!");
     }
  }