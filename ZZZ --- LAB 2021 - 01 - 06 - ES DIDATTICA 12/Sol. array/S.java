/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Realizza un insieme
  *
  * @see Set
  * @typeparam E il tipo di elementi contenuti nell'insieme
  *
  * Realizzazione che usa come struttura interna un array riempito parzialmente
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public class S<E extends Comparable> implements Set<E>
{
   // parte privata
   private final static int INITIAL_CAPACITY = 1;
   private Comparable[] v;  // nota: array di Comparable
                            // vedi programmazione generica
   private int vSize;       // numero di elementi dell'insieme
   
   /**
      inizializza questo insieme come insieme vuoto
   */
   public S()
   {
      v = new Comparable[INITIAL_CAPACITY];
      vSize = 0;
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
      // gestione delle precondizioni - O(n) nel caso medio
      if (e == null || contains(e))
         return false; // l'elemento specificato non e' stato inserito
         
      // eventuale ridimensionamento dinamico
      if (vSize >= v.length)
      {
         Comparable[] vTemp = new Comparable[2 * v.length];
         System.arraycopy(v, 0, vTemp, 0, v.length);
         v = vTemp;
      } 
      
      // inserimento nell'insieme e incremento del numero di elementi
      v[vSize++] = e;
      
      return true; // l'elemento specificato e' stato inserito
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
      int n = search(o);
      
      return n >= 0;
   }
   
   // ricerca lineare
   private int search(Object o)
   {
      for (int i = 0; i < vSize; i++)       // att.ne: estremo superiore vSize
         if (((E)v[i]).compareTo(o) == 0)   // stilisticamente e' piu' elegante
            return i;                       // usare per il confronto il metodo
                                            // compareTo al posto di equals
       return -1;      
   }   
   
   /**
      @return true se questo insieme e' vuoto, false altrimenti     
   */
   public boolean isEmpty()
   {
      return vSize <= 0;
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
      // variabili di esemplare
      private int current;  // indice corrente nell'array
      private int previous; // indice per gestire le chiamate al metodo remove
      private final static int ILLEGAL_STATE = -1;
      
      public SetIterator()
      {
         current = 0;            // posizionamento nel primo elemento dell'array
         previous = ILLEGAL_STATE;    // impedisce di chiamare il metodo remove
      }
      
      public boolean hasNext() // O(1)
      {
         return current < vSize;
      }
      
      public T next() throws java.util.NoSuchElementException // O(1)
      {
         // gestione delle precondizioni
         if (!hasNext())
            throw new java.util.NoSuchElementException();
            
         // accesso al prossimo elemento dell'iterazione
         T tmp = (T)v[current];
         
         // avanzamento dell'iteratore
         previous = current; // permette di chiamare il metodo remove
         current++;

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
         if (previous == ILLEGAL_STATE)
            throw new IllegalStateException();
                    
         // cancellazione dell'elemento ispezionato precedentemente da next
         v[previous] = v[vSize - 1];  // non e' richiesto di mantenere gli
                                      // elementi in sequenza 
         // garbage collector
         v[vSize - 1] = null;
         
         // aggiornamento del numero di elementi
         vSize--;
         
         // aggiornamento della posizione
         current = previous;
         previous = ILLEGAL_STATE;     // impedisce di chiamare il metodo remove  
      }
   } // fine della classe interna
   
   /**
      Fornisce l'elemento minimo dell'insieme
      @return l'elemento minimo dell'insieme
      @throws java.util.NoSuchElementException se non esiste un elemento minimo
   */
   public E min() throws java.util.NoSuchElementException
   {
      // gestione delle precondizioni - l'insieme e' vuoto
      if (isEmpty())
         throw new java.util.NoSuchElementException();          
         
      // prima ipotesi di minimo 
      Iterator<E> iter = iterator(); 
      E min = iter.next();
      
      // Scansione dell'insieme e selezione del minimo
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
      return vSize;
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
      if (a == null || a.length < vSize)
         throw new ArrayIndexOutOfBoundsException();
         
      // array non ordinato
      int ret = toArray(a);
      
      // ordinamento
      sort(a);
      
      return ret;
   } 
   
   // accesso agli elementi
   private int toArray(E[] a)
   {
      // array non ordinato
      System.arraycopy(v, 0, a, 0, vSize);
      return vSize;   
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
  
