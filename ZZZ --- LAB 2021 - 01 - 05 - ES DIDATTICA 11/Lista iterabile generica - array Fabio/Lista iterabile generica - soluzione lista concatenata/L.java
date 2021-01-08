import java.util.NoSuchElementException;

//L con LISTA CONCATENATA
public class L < E > implements List < E > {
   //INIZIO CLASSE PRIVATA ListNode
   private class ListNode {
      //variabili di esemplare
      private E value;
      private ListNode next;

      //costruttore
      public ListNode (E v, ListNode n) {
         setNext(n);
         setValue(v);
      }
      public ListNode () {
         this (null, null);
      }

      //metodi di modifica
      public void setValue (E v) { value = v;}
      public void setNext (ListNode n) { next = n;}

      //metodi di accesso
      public E getValue () { return value;}
      public ListNode getNext () { return next;}
   }
   //FINE CLASSE PRIVATA

   //variabili di esemplare
   private ListNode head, tail;
   private int size;

   //costruttore
   public L () {
      makeEmpty();
   }


   //makeEmpty
   public void makeEmpty () {
      head = tail = new ListNode();
      size = 0;
   }

   /**
       Inserisce l'elemento specificato all'ultima posizione della lista.
       @param x elemento specificato
       @throws IllegalArgumentException se l'elemento specificato vale null                   
     */
   public void add(E x) {
      //precondizioni
      if (x == null) {
         throw new IllegalArgumentException();
      }

      tail.setNext(new ListNode(x, null));

      tail = tail.getNext();

      size++;
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
      if (r < 0 || r > size) {
         throw new IndexOutOfBoundsException();
      }

      //spostamento elementi a dx
      //head torna indietro di uno, pos. 0 vuoto
      head = new ListNode(null, head);

      //ovvero la cella vuota alla pos. 0
      ListNode n = head.getNext();

      for (int i = 0; i < r; i++){
         //equivale a v[n] = v[n+1];
         n.setValue(n.getNext().getValue());
         //avanzamento
         n = n.getNext();
      }

      //inserimento valore alla giusta posizione
      n.setValue(x);

      //gestione coda
      if (n.getNext() == null) {
         tail = n;
      }

      size++;

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
      if (r < 0 || r >= size) {
         throw new IndexOutOfBoundsException();
      }

      ListNode n = head.getNext();

      for (int i = 0; i < r; i++) {
         n = n.getNext();
      }

      return n.getValue();
   }

   public boolean isEmpty () {
      return size <= 0;
   }

   public int size () {
      return size;
   }

   /**
        Fornisce il rango dell'elemento specificato se presente
        @param x l'elemento specificato
        @return il rango della prima occorrenza nella lista dell'elemento
                specificato o -1 se la lista non contiene l'elemento.
     */
   public int rankOf(E x) {
      //precondizioni
      if (x == null) {
         throw new IllegalArgumentException();
      }

      //listnode
      ListNode n = head.getNext();
      int rango = 0;

      while (n.getNext() != null){
         if (n.getValue().equals(x)){
            return rango;
         }
         //avanzamento
         rango++;
         n = n.getNext();
      }

      return -1;
   }

   /**
        Rende accessibili gli elementi della lista tramite un array
        @return array contenente gli elementi della lista nella sequenza naturale
     */
   public Object[] toArray() {
      Object [] v = new Object [size];

      //listnode
      ListNode n = head.getNext();
      int rango = 0;

      while (n != null){
         v[rango] = n.getValue();
         rango++;
         n = n.getNext();
      }

      return v;
   }

   /**
       * Fornisce un iteratore sulla sequenza
       * @return un iteratore posizionato prima del primo elemento della sequenza
       */
   public Iterator<E> iterator() {
      return new LinkedIterator<E> ();
   }


   //CLASSE PRIVATA
   private class LinkedIterator <T> implements Iterator <T> {
      //varaibili di esemplare
      private ListNode current, previous;
      private final ListNode INVALID_STATE = null;

      //costruttore
      public LinkedIterator () {
         current = head;
         previous = INVALID_STATE;
      }

      /**
        Verifica se e' presente nella sequenza un elemento in posizione successiva
        alla posizione dell'iteratore
        @return true se esiste un elemento successivo nella sequenza o altrimenti
                false 
     */
     public boolean hasNext() {
        return current.getNext() != null;
     }

     /**
        Fornisce l'elemento in posizione successiva alla posizione
        dell'iteratore e avanza l'iteratore di una posizione.
        @return l'elemento successivo nell'iterazione
        @throws java.util.NoSuchElementException se non sono presenti elementi in
                posizione successiva alla posizione dell'iteratore
     */
    public T next() {
       if (! hasNext()) {
          throw new NoSuchElementException();
       }

       previous = current;
       current = current.getNext();

       return (T)current.getValue();
    }

    /**
        Rimuove l'elemento che precede la posizione dell'iteratore.
        Il metodo puo' essere invocato solo dopo l'invocazione del metodo next.
        @throws java.lang.IllegalStateException se il metodo viene invocato senza
                una precedente invocazione del metodo next
     */
    //VIENE CANCELLATO IL NODO CURRENT
    public void remove() {
       //precondizioni
       if (previous == INVALID_STATE){
          throw new IllegalStateException();
       }

       //cancellazione attuale current
       previous.setNext(current.getNext());

       //current indietreggia
       current = previous;

       previous = INVALID_STATE;

       //gestione ultimo nodo
       if (current.getNext() == null) {
          tail = current;
       }

       //decremento
       size--;
    }
   }
}