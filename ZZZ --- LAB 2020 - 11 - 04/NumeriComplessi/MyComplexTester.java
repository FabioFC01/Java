/**
 * MyComplexTester
 * classe di prova della classe MyComplex
 * @author A. Luchetta
 * @version 28-Ott-2004
 *
 * Acquisisce da Standard Input due numeri complessi a e b, uno per riga
 * nel formato: re im
 * Stampa:
 * - la somma dei due numeri
 * - la sottrazione
 * - il prodotto
 * - il rapporto
 * - l'inverso di a e di b
 * - il complesso coniugato di a e b
 * - il modulo di a e di b
 * - la parte reale di a e di b
 * - la parte immaginaria di a e di d
 */

import java.util.Scanner;
import java.util.Locale;

public class MyComplexTester
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      in.useLocale(Locale.US);
      
      System.out.println("\nInserire parte reale e immaginaria nella stessa riga, separandoli con uno spazio\n");      

      // acquisisce il primo numero complesso da Standard Input
      System.out.print ("numero complesso a = ");
      double aRe = in.nextDouble();
      double aIm = in.nextDouble();
      MyComplex a = new MyComplex(aRe, aIm);

      // acquisisce il secondo numero complesso da Standard Input
      System.out.print ("numero complesso b = ");
      double bRe = in.nextDouble();
      double bIm = in.nextDouble();
      MyComplex b = new MyComplex(bRe, bIm);

      // emissione a Standard Output dell'elaborazione numerica
      System.out.println("a = " + a + " , b = " + b);
      System.out.println("a + b = " + a.add(b));
      System.out.println("a - b = " + a.sub(b));
      System.out.println("a * b = " + a.mult(b));
      System.out.println("a / b = " + a.div(b));
      System.out.println("1 / a = " + a.inv());
      System.out.println("1 / b = " + b.inv());
      System.out.println("a^ = " + a.conj());
      System.out.println("b^ = " + b.conj());
      System.out.println("|a| = " + a.mod());
      System.out.println("|b| = " + b.mod());
      System.out.println("re(a) = " + a.re());
      System.out.println("re(b) = " + b.re());
      System.out.println("im(a) = " + a.im());
      System.out.println("im(b) = " + b.im());
      
      // chiude il flusso
      in.close();
   }
}
