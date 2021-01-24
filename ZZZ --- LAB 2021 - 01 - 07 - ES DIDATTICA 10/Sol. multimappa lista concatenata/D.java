/**
  * Realizza il tipo di dati astratto Multimappa, un contenitore di
  * associazioni chiave/valore con chiave non e' necessariamente univoca
  *
  * @typeparam K tipo parametrico della chiave limitato a Comparable
  * @typeparam V tipo parametrico del valore
  *
  * @see SortedMultimap
  *
  * @author A. Luchetta
  * @version 12-02-2019
  *
  * Realizzazione con lista concatenaya
  * Nota sulla complessita' temporale asintotica del metodo findAll
  * la ricerca della chiave e' estesa su tutta la lista concatenata e quindi
  * la complessita' temporale risulta O(n)
  */
public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{   
   // parte privata
   private ListNode head;           //il riferimento al nodo tail non serve
   private int size;
   
   // classe interna
   private class ListNode
   {
      // variabili di esemplare
      private K key;               // chiave dell'associazione
      private V value;             // valore dell'associazione
      private ListNode next;
      
      // costruttore
      public ListNode(K k, V v, ListNode n)
      {
         setKey(k);
         setValue(v);
         setNext(n);
      }
      
      // costruttore
      public ListNode()
      {
         this(null, null, null);
      }
      
      // metodi di accesso
      public K getKey() { return key; }
      public V getValue() { return value; } 
      public ListNode getNext() { return next; }

      //metodi modificatori
      public void setKey(K k) { key = k; }
      public void setValue(V v) { value = v; }
      public void setNext(ListNode n) { next = n; }             
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
   public Object[] findAll(K key) // O(n)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Object[] a = new Object[size]; // memorizza i valori
      int aSize = 0;
      
      // accesso ai valori di chiave specificata - operazione O(n)
      ListNode n = head.getNext();
      while (n != null)   // operazione O(n) 
      {
         if (n.getKey().compareTo(key) == 0)
            a[aSize++] = n.getValue(); 
            
         n = n.getNext();        
      }
            
      // ridimensionamento dell'array contenente i valori
      Object[] r = new Object[aSize];
      System.arraycopy(a, 0, r, 0, r.length);          
      
      return r;
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
         
      // inserimento della nuova associazione
      head.setKey(key);
      head.setValue(value);
      head = new ListNode(null, null, head);
      
      // incremento del numero di associazioni
      size++;  
   }
   
   /**
     * Verifica se questo contenitore e' vuoto
     * @return true se questo contenitore e' vuoto, false altrimenti
     */
   public boolean isEmpty()
   {
      return size <= 0;
   }   
   
   /**
     * Fornisce le chiavi di questa multimappa
     * @return un array ordinato contenente le chiavi di questa multimappa o
     *         un array di dimensione nulla se questa multimappa e' vuota
     */
   public Comparable[] keys() // O(nlogn)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Comparable[] a = new Comparable[size];
      int i = 0;
      
      // accesso alle chiavi - Operazione O(n)
      ListNode n = head.getNext();
      while (n != null)   // operazione O(n) 
      {
         a[i++] = n.getKey(); 
            
         n = n.getNext();        
      }
         
      // ordinamento delle chiavi - O(nlogn)
      sort(a);

      return a;
   } 
   
   /**
     * Rende vuoto il contenitore
     */
   public void makeEmpty()
   {
      head = new ListNode();
      size = 0;
   }   
     
   /**
     * Rimuove da questa multimappa le associazioni di chiave specificata
     * @param key la chiave specificata
     * @return un array contenente i valori a cui la chiave specificata
     *         era associata, o un array di dimensione nulla se questa
               multimappa non contiene associazioni per la chiave     
     */      
   public Object[] removeAll(K key) // O(n)
   {
      // accesso ai valori di chiave specificata
      Object[] r = findAll(key);
      
      // ricerca ed eliminazione delle associazioni di chiave specificata - O(n)
      ListNode n = head;
      while (n.getNext() != null)
      {
         if (n.getNext().getKey().compareTo(key) == 0)  // trovata
         {
            n.setNext(n.getNext().getNext());     // eliminazione del nodo
            size--;                               // decremento no. associazioni
         }
         else
            n = n.getNext();
      }       
      
      return r;
   }
     
   /**
     * Fornisce il numero di elementi presenti in questo contenitore
     * @return il numero di elementi presenti in questo contenitore
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
