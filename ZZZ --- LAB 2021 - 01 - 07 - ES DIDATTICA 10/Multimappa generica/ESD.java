public class ESD<K extends Comparable,V extends Comparable> extends D<K,V>
{ // parte privata
 

   //costruttore
 public ESD() {
    super();
 } 
 /** @return true se questa multimappa contiene la chiave specificata,
 false altrimenti
 */ 
   public boolean contains(K key) {
      return findAll(key).length > 0;
   }
 /** @return un array ordinato contenente le chiavi univoche di questa
 multimappa o un array di dimensione nulla se questa multimappa
 e’ vuota
 */ 
   public Comparable[] keySet() {
      //accesso alle chiavi
      Comparable [] k = keys();

      //restituzione dell'insieme delle chiavi univoche
      return purge (k);
   }
 /**@return un array ordinato contenente i valori univoci di questa multimappa
 o un array di dimensione nulla se questa multimappa e’ vuota
*/ 
   public Comparable[] valueSet() {
      final String EMPTY_STRING = "";

      //accesso chaivi univoche
      Comparable [] k = keySet();

      ESD <V, String> m = new ESD <V, String> ();

      //inserimento in appoggio
      for (int i = 0; i < k.length; i++) {
         Object [] v = findAll((K)k[i]);

         for (int j = 0; j < v.length; j++) {
            m.insert((V)v[j], EMPTY_STRING);
         }
      }

      return m.keySet();

   }

   private Comparable [] purge (Comparable [] a) {
      if (a.length < 2)  {
         return a;
      }

      int i = 0;
      int j = i+1;

      while (j < a.length) {
         //se la chiave è multipla avanzo
         while (j < a.length && a[j].compareTo(a[i]) == 0) {
            j++;
         }

         //memorizzazione della nuova classe all'indice corretto
         if (j < a.length) {
            a[++i] = a [j++];
         }
      }

      //ridimensionamento array
      Comparable [] r = new Comparable [i+1];
      System.arraycopy(a, 0, r, 0, r.length);

      return r;
   }
}