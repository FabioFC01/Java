/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Classe S
  * Realizza un insieme
  *
  * @see Set
  * @param E il tipo di elementi contenuti nell'insieme
  *
  * Realizzazione che usa come struttura interna una lista concatenata mantenuta
  * ordinata
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public class S<E extends Comparable> implements Set<E>
{
   // parte privata
   private ListNode head;  // nodo sentinella della lista concatenata
   private int size;       // numero di elementi contenuti nell'insieme
   
   // classe interna
   private class ListNode  // anello di una lista concatenata
   {
      private E element;
      private ListNode next;
      
      public ListNode(E e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }
      
      public void setElement(E e) { element = e; }
      public void setNext(ListNode n) { next = n; }
      public E getElement() { return element; }
      public ListNode getNext() { return next; }  
   } 
   
   /**
      inizializza questo insieme come insieme vuoto
   */
   public S()
   {
      // inizializzazione di un insieme vuoto
      head = new ListNode();
      size = 0;
   }
   
   /**
      inizializza questo insieme con gli elementi dell'array specificato
      @param a array specificato
   */
   public S(E[] a)
   {
      // inizializzazione di un insieme vuoto
      this();
      
      // verifica sull'array specificato
      if (a == null) // se a vale null inizializza un insieme vuoto
         return;
         
      // inserimento degli elementi dell'array specificato
      for (E e : a)
         add(e);
   }
   
    /**
      inizializza questo insieme con gli elementi dell'insieme specificato
      @param s insieme specificato
   */
   public S(Set s)
   {
      // inizializzazione di un insieme vuoto
      this();
      
      // verifica sull'insieme specificato
      if (s == null)
         return;
         
      // inserimento degli elementi dell'array specificato
      Iterator<E> iter = s.iterator();
      while (iter.hasNext())
         add(iter.next());
   }   

   /**
      inserisce in questo insieme l'elemento specificato se questo e' diverso da
      null e se non e' gia' presente 
      @param e l'elemento specificato
      @return false se questo insieme conteneva l'elemento specificato
   */
   public boolean add(E e) // O(n) nel caso medio e peggiore
   {
      // gestione delle precondizioni
      if (e == null || contains(e))
         return false;
         
      // inserimento ordinato nella lista concatenata
      ListNode n = head;
      while (n.getNext() != null && n.getNext().getElement().compareTo(e) < 0)
         n = n.getNext();        
      n.setNext(new ListNode(e, n.getNext()));
      
      // aggiornamento del numero degli elementi
      size++;
      
      return true; 
   }
     
   /**
      @param o l'elemento specificato
      @return true se l'elemento specificato e' presente nell'insieme
   */
   public boolean contains(Object o) // O(n) nel caso medio e peggiore
   {
      // gestione delle precondizioni
      if (o == null)
         return false;
         
      // ricerca
      ListNode n = search(o);
      
      return n != null;
   }
   
   // ricerca lineare
   // restituisce il nodo in cui e' memorizzato l'elemento specificato se
   // presente, null altrimenti
   private ListNode search(Object o)
   {
      ListNode n = head.getNext(); // nodo successivo al nodo sentinella
      
     // scansione della lista concatenata
     while (n != null)
      {
         if (n.getElement().compareTo(o) == 0)  // notare l'uso di compareTo
            return n;                           // al posto di equals
            
         n = n.getNext();   
      }

       return n;    // restituisce null se l'elemento e non e' stato trovato   
   }
   
   /**
      @return true se questo insieme e' vuoto, false altrimenti     
   */
   public boolean isEmpty()
   {
      return size <= 0;
   }   
   
   /**
      restituisce un iteratore su questo insieme
      @return iteratore su questo insieme     
   */
   public Iterator<E> iterator()
   {
      return new SetIterator<E>();
   }  
   
   // classe interna 
   private class SetIterator<T> implements Iterator<T>
   {
      private ListNode current; // indice corrente nell'array
      private ListNode previous;
      
      public SetIterator()
      {
         current = head;      // posizionamento nel primo elemento dell'array
         previous = null;
      }
      
      public boolean hasNext() // O(1)
      {
         return current.getNext() != null;
      }
      
      public T next() throws java.util.NoSuchElementException // O(1)
      {
         // gestione delle precondizioni
         if (!hasNext())
            throw new java.util.NoSuchElementException();
            
         // accesso al prossimo elemento
         T tmp = (T)(current.getNext().getElement());
         
         // avanzamento dell'iteratore
         previous = current;
         current = current.getNext();

         return tmp;   
      }
      
   /**
      rimuove da questa sequenza l'ultimo l'elemento ispezionato con questo
      iteratore
      @throws IllegalStateException se il metodo next non e' stato prima
              chiamato o il metodo remove è stato chiamato dopo l'ultima
              chiamata al metod next
   */
    public void remove() throws java.lang.IllegalStateException
      {
         // gestione delle precondizioni
         if (previous == null)
            throw new IllegalStateException();
                    
         // cancellazione dell'elemento corrente
         previous.setNext(current.getNext());   
         
         // aggiornamento del numero di elementi
         size--;
         
         // aggiornamento posizione
         current = previous;
         previous = null;    
      }
   }

   /**
      @return l'elemento minimo dell'insieme
      @throws java.util.NoSuchElementException se non esiste un elemento minimo
   */
   public E min() throws java.util.NoSuchElementException
   {
      // gestione delle precondizioni - l'insieme e' vuoto
      if (size() == 0)
         throw new java.util.NoSuchElementException();          
         
      // ipotesi di minimo 
      Iterator<E> iter = iterator(); 
      E min = iter.next();
      
      // Scansione dell'insieme - Ricerca del minimo
      while (iter.hasNext())
      {
         E tmp = iter.next();
         if (tmp.compareTo(min) < 0)
            min = tmp;
      }    
               
      return min;            
   }     
   /**
      @return il numero di elementi presenti in questo insieme     
   */
   public int size()
   {
      return size;
   } 
   
   /**
      restituisce nell'array specificato gli elementi dell'insieme ordinati
      secondo il loro ordine naturale
      @param a array specificato
      @return la dimensione dell'insieme
      @throws ArrayIndexOutOfBoundsException se la dimensione dell'array
              specificato e' minore della dimensione dell'insieme        
   */
   public int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException
   {
      // gestione delle precondizioni
      if (a == null || a.length < size)
         throw new ArrayIndexOutOfBoundsException();
         
      // accesso agli elementi
      int ret = toArray(a);
      
      return ret;
   }
   
   // accesso agli elementi
   private int toArray(E[] a)
   {
      // array non ordinato
      Iterator<E> iter = iterator();
      int i = 0;
      while (iter.hasNext())
         a[i++] = iter.next();
         
      return i;      
   }       
}  
  
