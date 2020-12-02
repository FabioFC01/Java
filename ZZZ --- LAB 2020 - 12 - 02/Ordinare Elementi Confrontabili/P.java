public class P implements Comparable<P>
{
   // variabile di esemplare
   private final int p;
   
   /**
      inizializza usando un numero intero casuale nell'intervallo [1, 100]
   */
   public P()
   {
      p = (int)(1 +  99 * Math.random()); // genera un numero intero casuale nell'intervallo [1, 100]
   }
   
   /*
      Confronta questo esemplare con l'esemplare specificato
      
      @param n l'esemplare specificato
      @return zero se questo esemplare coincide con l'esemplare specificato
              un numero negativo se questo esemplare precede l'esemplare specificato
              un numero positivo altrimenti.
   */
   public int compareTo(P n)
   {
      return p - n.p;
   }
   
   /**
      Descrizione testuale
   */
   public String toString()
   {
      return "" + p;
   }
}