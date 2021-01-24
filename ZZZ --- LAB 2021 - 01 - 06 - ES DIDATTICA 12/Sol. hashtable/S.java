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
  * Realizzazione che usa come struttura interna una hash table
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public class S<E extends Comparable> implements Set<E>
{
   // parte privata
   private static final int CAPACITY = 97; // numero primo
   private Object[] v; // array di Object - programmazione generica!
   private int size;   // numero di elementi dell'array
   
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
      v = new Object[CAPACITY];
      size = 0;     
      for (int i = 0; i < v.length; i++) // inizializzazione dei bucket
         v[i] = new ListNode();
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
         
      // inserimento nella hash table
      int h = hash(e);                 // generazione della chiave ridotta
      ListNode head = (ListNode)v[h];  // nodo sentinella del bucket
      head.setElement(e);              // inserimento nel nodo sentinella
      v[h] = new ListNode(null, head); // nuovo nodo sentinella del bucket
      
      // aggiornamento del numero di elementi
      size++; 
      
      return true;
   }
   
   // calcolo della chiave ridotta 
   private int hash(Object o)
   {
      int h = o.hashCode() % v.length;
      if (h < 0)
         h = - h;
         
      return h;   
   }
     
   /**
      @param o l'elemento specificato
      @return true se l'elemento specificato e' presente nell'insieme
   */
   public boolean contains(Object o) // O(n/M) nel caso medio e peggiore
   {                                 // dove M e' la dimensione della tabella   
      // gestione delle precondizioni
      if (o == null)
         return false;
         
      // ricerca nella hash table
      ListNode n = search(o);
      
      return n != null;
   }
   
   // ricerca lineare nel bucket
   // restituisce il nodo in cui si trova l'elemento specificato o null se
   // l'elemento specificato non e' presente nel bucket
   private ListNode search(Object o)
   {
      // selezione del bucket
      ListNode n = ((ListNode)v[hash(o)]).getNext();
      
      // scansione nel bucket
      while (n != null)
      {
         if (n.getElement().compareTo(o) == 0)
            return n;
            
         n = n.getNext();   
      }

      return n; // restituisce null se l'elemento specificato non e' presente      
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
      private ListNode current;  // nodo corrente nel bucket corrente
      private ListNode previous; // nodo precedente
      private int index;         // indice del bucket corrente
      
      public SetIterator()
      {
         index = 0;                    // posizione nel bucket di indice zero
         current = (ListNode)v[index]; // posizione nel nodo sentinella del
                                       // bucket corrente
         previous = null;                              
      }
      
      public boolean hasNext()
      {
         // verifica se esiste un prossimo elemento nel bucket corrente
         if(current.getNext() != null)
            return true;
            
         // ricerca di un prossimo elemento nei bucket seguenti
         index++; // bucket successivo
         while (index < v.length) // scansione della hash table
         {
            if (((ListNode)v[index]).getNext() != null)
            {
               current = (ListNode)v[index]; // nodo sentin. nel bucket corrente
               return true;
            }
            index++;   
         }
         
         return false;  // non sono stati trovati bucket con elementi presenti          
      }
      
      public T next() throws java.util.NoSuchElementException
      {
         // gestione delle precondizioni
         if (!hasNext())
            throw new java.util.NoSuchElementException();
            
         // avanzamento nel bucket
         previous = current;
         current = current.getNext();
 
         // restituzione del prossimo elemento
         return (T)current.getElement();   
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
         
         // aggiornamento della posizione
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
         
      // prima ipotesi di minimo 
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
      
      // ordinamento
      sort(a);
      
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
   
   // algoritmo di ordinamento mergesort
   private void sort(Comparable[] v)
   {
      if (v.length < 2)
         return;
         
      int mid = v.length / 2;
      
      Comparable[] left = new Comparable[mid];
      Comparable[] right = new Comparable[v.length - mid];
      System.arraycopy(v, 0, left, 0, left.length);
      System.arraycopy(v, mid, right, 0, right.length);
      
      sort(left); 
      sort(right);
      
      merge(v, left, right);
   }
   
   private void merge(Comparable[] a, Comparable[] b, Comparable[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (b[ib].compareTo(c[ic]) < 0)
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++]; 
            
      while (ib < b.length)
         a[ia++] = b[ib++];                 
      while (ic < c.length)
         a[ia++] = c[ic++]; 
   }          
}  
  
