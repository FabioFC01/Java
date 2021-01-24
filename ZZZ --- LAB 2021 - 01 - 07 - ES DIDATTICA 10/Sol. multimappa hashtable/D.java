/**
  * Realizza il tipo di dati astratto Multimappa, un contenitore di
  * associazioni chiave/valore con chiave non e' necessariamente univoca
  *
  * @typeparam K tipo parametrico della chiave limitato a Comparable
  * @typeparam V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 12-02-2019
  *
  * Realizzazione con hash table
  * Nota sulla complessita' temporale del metodo findAll
  * Sia n il numero di associazioni contenute nella multimappa. 
  * La complessita' temporale del metodo findAll e' pari a O(n/M) dove M e' la
  * dimensione della tabella. Infatti se la funzione di hash distribuisce
  * uniformemente le chiavi, la lunghezza media di ciascun bucket e' pari a n/M.
  * Il metodo findAll scandisce il bucket associato alla chiave specificata.
  */
public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{   
   // parte privata
   private final static int CAPACITY = 1;
   private Object[] v;                    // array di Object
   private int size;
   
   // classe interna
   private class ListNode
   {
      // variabili di esemplare
      private Entry element;
      private ListNode next;
      
      // costruttori
      public ListNode(Entry e, ListNode n)
      {
         setElement(e);
         setNext(n);
      }
      
      public ListNode()
      {
         this(null, null);
      }      
      
      // metodi di accesso
      public Entry getElement() { return element; }
      public ListNode getNext() { return next; } 

      // metodi modificatori
      public void setElement(Entry e) { element = e; }
      public void setNext(ListNode n) { next = n; }             
   }
   
   // classe interna
   private class Entry
   {
      // variabili di esemplare
      private K key;
      private V value;
      
      // costruttore
      public Entry(K k, V v)
      {
         setKey(k);
         setValue(v);
      }
      
      // metodi di accesso
      public K getKey() { return key; }
      public V getValue() { return value; } 

      // metodi modificatori
      public void setKey(K k) { key = k; }
      public void setValue(V v) { value = v; }             
   }
   
   /**
      inizializza una multimappa vuota
   */
   public D()
   {
      makeEmpty();
   }

   /**
     * Restituisce un array contenente i valori a cui la chiave specificata
     * e' associata
     * @param key la chiave specificata
     * @return un array contenente i valori a cui la chiave specificata
     *         e' associata, o un array di dimensione nulla se questa multimappa
     *         non contiene associazioni per la chiave
     */      
   public Object[] findAll(K key) // O(n/M), M dimensione della tabella
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Object[] a = new Object[size]; // memorizza i valori
      int aSize = 0;
      
      // accesso ai valori di chiave specificata 
      int h = hash(key);
      ListNode n = ((ListNode)v[h]).getNext();
      while (n != null) // Operazione O(n/M)
      {
         if (n.getElement().getKey().compareTo(key) == 0)
            a[aSize++] = n.getElement().getValue();
            
         n = n.getNext();   
      }
            
      // ridimensionamento dell'array contenente i valori
      Object[] r = new Object[aSize];
      System.arraycopy(a, 0, r, 0, r.length);          
      
      return r;
   }
   
   // chiave ridotta
   private int hash(K k)
   {
      int h = k.hashCode() % v.length;
      
      // valore assoluto 
      if (h < 0)
         h = -h;
         
      return h;   
   }
   
   /** 
     * Associa il valore specificato alla chiave specificata in questa
     * multimappa
     * @param key la chiave specificata
     * @param value il valore specificato
     * @throws java.lang.IllegalArgumentException se la chiave o il valore
     *          specificati valgono null
     */
   public void insert(K key, V value) // O(1)
   {
      // precondizioni 
      if (key == null || value == null)
         throw new IllegalArgumentException();
         
      // inserimento della nuova associazione nel bucket di rango h
      int h = hash(key);
      ((ListNode)v[h]).setElement(new Entry(key, value));
      v[h] = new ListNode(null, (ListNode)v[h]);
      
      // incremento del numero di associazioni
      size++;  
   }   

   /**
     * @return vero se questa multimappa e' vuota, falso altrimenti
     */
   public boolean isEmpty()
   {
      return size <= 0;
   }   
   
   /**
     * @return un array ordinato contenente le chiavi di questa multimappa o
     * un array di dimensione nulla se questa multimappa e' vuota
     */
   public Comparable[] keys() // O(nlogn)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Comparable[] a = new Comparable[size];
      
      // accesso alle chiavi
      int j = 0;
      for (int i = 0; i < v.length; i++)
      {
         ListNode n = ((ListNode)v[i]).getNext();
         while (n != null)
         {
            a[j++] = n.getElement().getKey();
            n = n.getNext();  
         }
      }
         
      // ordinamento delle chiavi - O(nlogn)
      sort(a);

      return a;
   } 
   
   /**
      rende il contenitore vuoto
   */
   public void makeEmpty()
   {
      v = new Object[CAPACITY];
      for (int i = 0; i < v.length; i++)
         v[i] = new ListNode();
      size = 0;
   }   
     
   /**
     * Rimuove da questa multimappa le associazioni di chiave specificata
     * @param key la chiave specificata
     * @return un array contenente i valori a cui la chiave specificata
     *         era associata, o un array di dimensione nulla se questa
               multimappa non contiene associazioni per la chiave     
     */      
   public Object[] removeAll(K key) // O(n/M) M dimensione della tabella
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Object[] a = new Object[size];
      int aSize = 0;  
      
      // ricerca ed eliminazione delle associazioni di chiave specificata
      int h = hash(key);  
      ListNode n = (ListNode)v[h];
      while (n.getNext() != null)
      {
         if (n.getNext().getElement().getKey().compareTo(key) == 0)
         {
            a[aSize++] = n.getNext().getElement().getValue();   //memorizzazione
            n.setNext(n.getNext().getNext());              // rimozione del nodo
            size--;                     // decremento del numero di associazioni
         }
         else         
            n = n.getNext();
      }
            
      // ridimensionamento dinamico dell'array dei valori
      Object[] r = new Object[aSize];
      System.arraycopy(a, 0, r, 0, r.length);          
      
      return r;
   }
     
   /**
     * @return il numero di associazioni presenti in questa multimappa
     */
   public int size()
   {
      return size;
   } 
   
   // ordinamento mergesort - O(nlogn)
   private static void sort(Comparable[] a)
   {
      // caso base
      if (a.length < 2)
         return;
         
      int mid = a.length / 2;   
         
      Comparable[] left = new Comparable[mid]; 
      Comparable[] right = new Comparable[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);  
   }
   
   private static void merge(Comparable[] a, Comparable[] b, Comparable[] c)
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
