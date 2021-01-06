//LISTA ITERABLE GENERICA CON ARRAY

public class L<E> implements List<E> {

   //CLASSE PRIVATA ITERATOR
   private class Iterator <E> {
      //variabili di esemplare
      private E current;
      private E previous;

      public Iterator (E cur) {
         current = cur;
         previous = null;
      }

       /**
        Verifica se e' presente nella sequenza un elemento in posizione successiva
        alla posizione dell'iteratore
        @return true se esiste un elemento successivo nella sequenza o altrimenti
                false 
     */
      public  boolean hasNext() {
         
      }
     
     /**
        Fornisce l'elemento in posizione successiva alla posizione
        dell'iteratore e avanza l'iteratore di una posizione.
        @return l'elemento successivo nell'iterazione
        @throws java.util.NoSuchElementException se non sono presenti elementi in
                posizione successiva alla posizione dell'iteratore
     */
     T next();
     
     /**
        Rimuove l'elemento che precede la posizione dell'iteratore.
        Il metodo puo' essere invocato solo dopo l'invocazione del metodo next.
        @throws java.lang.IllegalStateException se il metodo viene invocato senza
                una precedente invocazione del metodo next
     */
     void remove();   
   }

   //variabili di esemplare
   private Object [] v;
   private int vSize;
   private static final int INITIAL_SIZE = 1;

   // --- COSTRUTTORE ---
   public L () {
      makeEmpty();
   }

   //METODI

   /**
       * Verifica se questo contenitore e' vuoto
       * @return true se questo contenitore e' vuoto, false altrimenti
       */
   public boolean isEmpty() {
      return vSize <= 0;
   }
     
      /**
        * Rende vuoto il contenitore
        */
   public void makeEmpty() {
      v = new Object [INITIAL_SIZE];
      vSize = 0;
   }   
            
        
      /**
        * Fornisce il numero di elementi presenti in questo contenitore
        * @return il numero di elementi presenti in questo contenitore
        */
   public int size() {
      return vSize;
   }

   /**
       * Fornisce un iteratore sulla sequenza
       * @return un iteratore posizionato prima del primo elemento della sequenza
       */
   public Iterator<T> iterator() {

   }
}  