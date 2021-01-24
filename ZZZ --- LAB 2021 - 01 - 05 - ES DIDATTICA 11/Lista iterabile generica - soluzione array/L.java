import java.util.NoSuchElementException;

//L con ARRAY
public class L < E > implements List < E > {
   //variabili di esemplare
   private Object [] v;
   private int vSize;
   private static final int INITIAL_SIZE = 1;

   //costruttore
   public L () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      v = new Object [INITIAL_SIZE];
      vSize = 0;
   }

   //isEmpty
   public boolean isEmpty () {
      return vSize <= 0;
   }

   /**
       Inserisce l'elemento specificato nella posizione di rango specificato.
       Sposta l'elemento attualmente in quella posizione (se esiste) e tutti gli
       elementi seguenti a destra (aggiunge uno ai ranghi).
       @param r rango specificato
       @param x elemento specificato
       @throws java.lang.IndexOutOfBoundsException se il rango non e' nei limiti
               ovvero non e' nell'intervallo [0, numero di elementi della lista]
       @throws IllegalArgumentException se l'elemento specificato vale null                   
     */
   public void add(int r, E x) {
      //precondizioni
      if (x == null) {
         throw new IllegalArgumentException();
      }
      if (r < 0 || r > vSize) {
         throw new IndexOutOfBoundsException();
      }

      //eventuale ridimensionamento dinamico
      if (vSize >= v.length) {
         Object [] NewV = new Object [ 2 * v.length];
         System.arraycopy(v, 0, NewV, 0, vSize);
         v = NewV;
      }

      //spostamento degli elementi a dx
      for (int i = vSize; i > r; i--) {
         v [i] = v[i-1];
      }

      v[r] = x;

      vSize++;
   }

   /**
       Inserisce l'elemento specificato all'ultima posizione della lista.
       @param x elemento specificato
       @throws IllegalArgumentException se l'elemento specificato vale null                   
     */
   public void add(E x) {
      add(vSize, x);
   }

   /**
        Restituisce l'elemento di rango specificato
        @param r rango specificato
        @return elemento di rango specificato
        @throws IndexOutOfBoundsException se il rango non e' nei limiti ovvero non
                e' nell'intervallo [0, numero di elementi della lista - 1]  
     */
   public E get(int r) {
      //precondizioni
      if (r < 0 || r >= vSize) {
         throw new IndexOutOfBoundsException();
      }

      return (E)v[r];
   }

   /**
        Fornisce il rango dell'elemento specificato se presente
        @param x l'elemento specificato
        @return il rango della prima occorrenza nella lista dell'elemento
                specificato o -1 se la lista non contiene l'elemento.
     */
   public int rankOf(E x) {
      for (int i = 0; i < vSize; i++) {
         if (v[i].equals(x)){
            return i;
         }
      }

      return -1;
   }

   public int size () {
      return vSize;
   }

   /**
        Rende accessibili gli elementi della lista tramite un array
        @return array contenente gli elementi della lista nella sequenza naturale
     */
   public Object[] toArray() {
      Object [] a = new Object [vSize];
      System.arraycopy(v, 0, a, 0, vSize);

      return a;
   }

   /**
       * Fornisce un iteratore sulla sequenza
       * @return un iteratore posizionato prima del primo elemento della sequenza
       */
   public Iterator<E> iterator() {
      return new ListIterator<E>();
   }

   //CLASSE PRIVATA LISTITERATOR
   private class ListIterator <T> implements Iterator <T> {
      //parte privata
      private int current, previous;
      private static final int INITIAL_POSITION = 0;
      private static final int INVALID_STATE = -1;

      //Costruttore
      public ListIterator () {
         current = INITIAL_POSITION;
         previous = INVALID_STATE;
      }

      /**
        Verifica se e' presente nella sequenza un elemento in posizione successiva
        alla posizione dell'iteratore
        @return true se esiste un elemento successivo nella sequenza o altrimenti
                false 
     */
     public boolean hasNext() {
        return current < vSize;
     }
     
     /**
        Fornisce l'elemento in posizione successiva alla posizione
        dell'iteratore e avanza l'iteratore di una posizione.
        @return l'elemento successivo nell'iterazione
        @throws java.util.NoSuchElementException se non sono presenti elementi in
                posizione successiva alla posizione dell'iteratore
     */
     public T next() {
        if (!hasNext()) {
           throw new NoSuchElementException();
        }

        //memorizzazione
        T rit = (T) v[current];

        //autorizzazione invocazione metodo remove
        previous = current;
        
        current++;

        return rit;
     }
     
     /**
        Rimuove l'elemento che precede la posizione dell'iteratore.
        Il metodo puo' essere invocato solo dopo l'invocazione del metodo next.
        @throws java.lang.IllegalStateException se il metodo viene invocato senza
                una precedente invocazione del metodo next
     */
     public void remove() {
        if (previous == INVALID_STATE){
           throw new IllegalStateException();
        }

        //spostamento elementi
        for (int i = previous; i < vSize - 1; i++) {
           v[i] = v[i+1];
        }

        v[vSize -1] = null;
        vSize--;

        current = previous;
        previous = INVALID_STATE;
     }
   
   }
}