/**
  * Realizza il tipo di dati astratto Multimappa Ordinata, un contenitore di
  * associazioni chiave/valore con chiave non e' necessariamente univoca e
  * limitata a Comparable
  *
  * @typeparam K tipo parametrico limitato a Comparable della chiave 
  * @typeparam V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 27-12-2020
  *
  * Realizzazione con array parzialmente riempito
  * Nota sulla complessita' temporale asintotica del metodo findAll
  * la ricerca della chiave e' estesa su tutta la multimappa e quindi
  * la complessita' temporale risulta O(n)
  */
public class D<K extends Comparable,V> implements Multimap<K,V>
{   
   // parte privata
   private final static int INITIAL_CAPACITY = 1;
   private Object[] v;
   private int vSize;
   
   // classe interna
   private class Entry
   {
      // variabili die semplare
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

      //metodi modificatori
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
   public Object[] findAll(K key) // O(n)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Object[] a = new Object[vSize]; // memorizza i valori
      int aSize = 0;
      
      // accesso ai valori di chiave specificata    
      for (int i = 0; i < vSize; i++)                    // operazione O(n)
         if (((Entry)v[i]).getKey().compareTo(key) == 0)
            a[aSize++] = ((Entry)v[i]).getValue();
            
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
   public void insert(K key, V value) //O(1) nel caso medio, O(n) nel caso peggiore
   {
      // precondizioni 
      if (key == null || value == null)
         throw new IllegalArgumentException();
         
      // ridimensionamento dinamico 
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }   
         
      // inserimento nuova associazione e incremento del numero di associazioni
      v[vSize++] = new Entry(key, value);   
   }   

   /**
     * Verifica se questo contenitore e' vuoto
     * @return true se questo contenitore e' vuoto, false altrimenti
     */
   public boolean isEmpty()
   {
      return vSize <= 0;
   }   
   
   /**
     * @return un array ordinato contenente le chiavi di questa multimappa o
     * un array di dimensione nulla se questa multimappa e' vuota
     */
   public Comparable[] keys() // O(n)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Comparable[] a = new Comparable[vSize];
      
      // accesso alle chiavi
      for (int i = 0; i < vSize; i++)
         a[i] = ((Entry)v[i]).getKey();
         
      // ordinamento delle chiavi
      sort(a);

      return a;
   } 
   
   /**
     * Rende vuoto il contenitore
     */
   public void makeEmpty()
   {
      v = new Object[INITIAL_CAPACITY];
      vSize = 0;
   }     
     
   /**
     * Rimuove da questa multimappa le associazioni di chiave specificata
     * @param key la chiave specificata
     * @return un array contenente i valori a cui la chiave specificata
     *         era associata, o un array di dimensione nulla se questa
               multimappa non contiene associazioni per la chiave     
     */      
   public Object[] removeAll(K key)
   {
      // accesso ai valori di chiave specificata
      Object[] r = findAll(key);
      
      // ricerca ed eliminazione delle associazioni di chiave specificata
      int i = 0;
      while (i < vSize)
      {
         if (((Entry)v[i]).getKey().compareTo(key) == 0)
         {
            v[i] = v[vSize - 1];          // cancellazione dell'associazione
            v[vSize - 1] = null;          // garbage collector
            vSize--;                      // decremento numero di associazioni 
          }
          else          
            i++;                          // gestione della chiave successiva
       }        
      
      return r;
   }
     
   /**
     * Fornisce il numero di elementi presenti in questo contenitore
     * @return il numero di elementi presenti in questo contenitore
     */
   public int size()
   {
      return vSize;
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
