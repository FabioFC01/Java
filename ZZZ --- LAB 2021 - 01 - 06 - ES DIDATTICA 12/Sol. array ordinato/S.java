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
  * Realizzazione che usa come struttura interna un array riempito parzialmente
  * mantenuto ordinato
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public class S<E extends Comparable> implements Set<E>
{
   // parte privata
   private final static int INITIAL_CAPACITY = 1;
   private Comparable[] v;  // nota: array di Comparable - vedi programmazione generica
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
      // gestione delle precondizioni
      if (e == null || contains(e))
         return false;
         
      // ridimensionamento dinamico
      if (vSize >= v.length)
      {
         Comparable[] vTemp = new Comparable[2 * v.length];
         System.arraycopy(v, 0, vTemp, 0, v.length);
         v = vTemp;
      }
      
      // inserimento ordinato
      int j = vSize - 1;
      while (j >= 0 && e.compareTo(v[j]) < 0)
      {
         v[j + 1] = v[j];
         j--;
      }
      v[j + 1] = e;
      
      // aggiornamento del numero di elementi
      vSize++;
      
      return true; 
   }
     
   /**
      @param o l'elemento specificato
      @return true se l'elemento specificato e' presente nell'insieme
   */
   public boolean contains(Object o) // O(logn) nel caso medio e peggiore
   {        
      // gestione delle precondizioni
      if (o == null)
         return false;
         
      // ricerca
      int n = search(o);
      
      return n >= 0;
   }
   
   // ricerca binaria
   private int search(Object o)
   {
      return search(v, 0, vSize - 1, o);      
   }
   
   private int search(Comparable[] a, int from, int to, Object target)
   {
      if (from > to)
         return -1;
         
      int mid = (from + to) / 2;  
      
      if (a[mid].compareTo(target) == 0)
         return mid;
      else if (a[mid].compareTo(target) < 0)
         return search(a, mid + 1, to, target);
      else
         return search(a, from, mid - 1, target);           
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
      private int current; // indice corrente nell'array
      private int previous;
      
      public SetIterator()
      {
         current = 0;      // posizionamento nel primo elemento dell'array
         previous = -1;
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
            
         // accesso al prossimo elemento
         T tmp = (T)v[current];
         
         // avanzamento dell'iteratore
         previous = current;
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
         if (previous < 0)
            throw new IllegalStateException();
                    
         // cancellazione dell'elemento ispezionato precedentemente da next
         for (int i = previous; i < vSize - 1; i++) // E' richiesto di mantenere
            v[i] = v[i + 1];                        // gli elementi ordinati

         // garbage collector
         v[vSize - 1] = null;
         
         // aggiornamento del numero di elementi
         vSize--;
         
         // aggiornamento posizione
         current = previous;
         previous = -1;    
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
         
      // array ordinato
      int ret = toArray(a);
      
      return ret;
   }
   
   // accesso agli elementi
   private int toArray(E[] a)
   {
      // array non ordinato
      System.arraycopy(v, 0, a, 0, vSize);
      return vSize;   
   }             
}  
  
