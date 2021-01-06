import java.util.NoSuchElementException;

//LISTA CON LISTA CONCATENATA
public class ListaSuCatena implements List, Iterator {
   //INIZIO CLASSE PRIVATA ENTRY
   private class Entry {
      //variabili di esemplare
      private Object value;
      private Entry next;

      //costruttori
      public Entry (Object val, Entry n){
         setNext(n);
         setValue(val);
      }
      public Entry () {
         this(null, null);
      }

      //metodi modificatori
      public void setValue (Object val){
         value = val;
      }
      public void setNext (Entry n) {
         next = n;
      }

      //metodi di accesso
      public Object getValue () { return value;}
      public Entry getNext () { return next;}
   }
   //FINE CLASSE PRIVATA ENTRY


   //INIZIO CLASSE PRIVATA LINKEDLISTITERATOR
   private class LinkedListIterator implements Iterator {
      //variabili di esemplare
      private Entry current; //precede la pos. attuale, mai null
      private Entry previous; //precedente
      private Entry tail;

      //costruttore
      public LinkedListIterator (Entry h) {
         //iteratore è tra previous e h
         current = h;
         previous = null;
      }

      //hasNext
      public boolean hasNext () {
         return current.getNext() != null;
      }

      //next
      /**
        ispeziona l'elemento DOPO la posizione corrente dell'iteratore, avanzando
        successivamente l'iteratore di una posizione nella lista
        @return l'elemento ispezionato, se presente
        throws java.util.NoSuchElementException se non ci sono elementi dopo la
        posizione corrente dell'iteratore
     */
      public Object next () {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         previous = current;
         current = current.getNext();

         return current.getValue();
      }

      /**
       inserisce un nuovo elemento dopo la posizione corrente dell'iteratore,
       l'iteratore si posiziona dopo il nuovo elemento
       @param x elemento da inserire
    */
      public void add(Object x) {
         Entry n = new Entry (x , current.getNext());

         current.setNext(n);
         current = n;
         previous = null; //così da non invocare remove

         if (current.getNext() == null) { //gestione ultimo nodo
            tail = current;
         }
      }

      public void remove () throws IllegalStateException {
         if (previous == null){
            throw new IllegalStateException();
         }

         previous.setNext(current.getNext());
         current = previous;

         if (current.getNext() == null) { //gestione ultimo nodo
            tail = current;
         }

         previous = null; //cos' non puoi chiamare remove
         //due volte di seguito
      }
   }

   //variabili di esemplare
   private int size;
   private Entry head;

   //costruttori
   public ListaSuCatena () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      head = new Entry();
      size = 0;
   }

   /**
       @return true se il contenitore e' vuoto, false altrimenti
    */
   public boolean isEmpty() {
      return size <= 0;
   }
  
    /**
       @return  numero di elementi nel contenitore
    */
   public int size() {
      return size;
   }

   /**
       Restituisce l'elemento alla posizione specificata nella lista
       @index indice dell'elemento da restituire
     */
   public Object get(int index) {
      if (isEmpty()){
         throw new EmptyListException();
      }

      Iterator n = iterator();   //LinkedListIterator

      Object ret = null;

      for (int i = 0; i < index; i++) {
         if (n.hasNext()){
            ret = n.next();
         }
      }

      return ret;
   }
  
    /**
      Sostituisce l'elemento alla posizione specificata nella lista con l'elemento x
      @param index posizione dell'elemento da sostituire
      @param x elemento da memorizzare alla posizione
       specificata
      @return l'elemento precedentemente memorizzato
       Alla posizione specificata
    */
   public Object set(int index, Object x) {
      if (isEmpty()){
         throw new EmptyListException();
      }

      

   }
 
   /**
       Inserisce l'elemento specificato alla posizione specificata nella lista
       Sposta a destra tutti gli elementi presenti
       di un posto
       @index rango dell'elemento da inserire
       @x elemento da inserire
    */
    void add(int index, Object x);
 
   /**
       Estrae l'elemento alla posizione specificata nella lista. Sposta a sinistra di
       un posto tutti gli elementi che seguono
       L'elemento estratto
       @index rango dell'elemento da sostituire
 
    */
   public Object remove(int index) {
      if (isEmpty()){
         throw new EmptyListException();
      }
   }


   // ITERATOR
   
   /**
        genera un interatore sulla lista
        @return l'iteratore sulla lista
     */
   public Iterator iterator() {
      return new LinkedListIterator(head);
   }

}