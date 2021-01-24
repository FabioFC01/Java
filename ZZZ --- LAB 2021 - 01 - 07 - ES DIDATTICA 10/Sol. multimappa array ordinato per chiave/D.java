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
  * Realizzazione con array ordinato
  * Nota sulla complessita' temporale asintotica del metodo findAll
  * Sia n il numero di associazioni contenute nella multimappa. Allora la
  * complessita' temporale asintotica e' pari a:
  * - O(logn) nei casi migliori
  * - O(n) nel caso medio
  * - O(n) nel caso peggiore
  * I casi migliori sono quando la chiave ricercata non e' presente o e'
  * presente una sola volta. Nel caso migliore la complessita' temporale e'
  * O(logn) ed e' determinata dalla ricerca binaria.
  * Il caso peggiore e' quando tutte le associazioni della multimappa hanno la
  * stessa chiave. In tal caso, la complessita' temporale e' pari a O(n) ed e'
  * determinata dalla copia di tutti i valori della multimappa.
  * Nel caso medio, detto k il numero di associazioni di chiave specificata,
  * allora la complessita' temporale e' pari a logn + k ed e' determinata dalla
  * ricerca binaria seguita dalla copia dei k valori associati alla chiave
  * ricercata. Effettuando l'analisi ammortizzata si ottiene il valore O(n) per
  * la complessita' temporale asintotica media (vedi analisi ammortizzata)
  */
public class D<K extends Comparable,V> implements SortedMultimap<K,V>
{   
   // parte privata
   private final static int INITIAL_CAPACITY = 1;
   private Object[] v;
   private int vSize;
   
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
      public K getKey()   { return key;   }
      public V getValue() { return value; } 

      // metodi modificatori
      public void setKey(K k)   { key = k;   }
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
   public Object[] findAll(K key) // O(logn) + k (k molteplicita' della chiave)
   {
      // array di dimensione pari al numero di associazioni nella multimappa
      Object[] a = new Object[vSize]; // memorizza i valori
      int aSize = 0;
      
      // accesso ai valori di chiave specificata
      int n = search(key); // operazione O(logn)
      
      // chiave non presente
      if (n < 0)
         return new Object[0];
      
      // memorizzazione del valore dell'associazione all'indice n
      a[aSize++] = ((Entry)v[n]).getValue();
      
      // NB: i due cicli while successivi hanno complessita' temporale
      // asintotica pari a O(k) dal momento che copiano k - 1 valori
      
      // ricerca  e copia dei valori a indici inferiori a n
      int i = n - 1;
      while (i >= 0 && ((Entry)v[i]).getKey().compareTo(key) == 0)
      {   a[aSize++] = ((Entry)v[i]).getValue();
          i--;
      }
            
      // ricerca e copia dei valori a indici superiori a n
      i = n + 1;
      while (i < vSize && ((Entry)v[i]).getKey().compareTo(key) == 0)
      {   a[aSize++] = ((Entry)v[i]).getValue();
          i++;
      }           
            
      // ridimensionamento dell'array contenente i valori
      Object[] r = new Object[aSize];
      System.arraycopy(a, 0, r, 0, r.length);          
      
      return r;
   }
   
   // ricerca binaria
   private int search(K key)
   {
      return search(v, 0, vSize - 1, key);
   }
   
   private int search(Object[] a, int from, int to, K key)
   {
      // caso base
      if (from > to)
         return -1;
         
      int mid = (from + to) / 2;
      K middle = ((Entry)a[mid]).getKey();
      
      if (middle.compareTo(key) == 0) // altro caso base
         return mid;
      else if (middle.compareTo(key) < 0)
         return search(a, mid + 1, to, key);   // cerca a destra
      else
         return search(a, from, mid - 1, key); // cerca a sinistra 
   }  
   
   /** 
     * Associa il valore specificato alla chiave specificata in questa
     * multimappa
     * @param key la chiave specificata
     * @param value il valore specificato
     * @threws java.lang.IllegalArgumentException se la chiave o il valore
     *          specificati valgono null
     */
   public void insert(K key, V value) //O(n) nel caso medio e peggiore
   {
      // precondizioni 
      if (key == null || value == null)
         throw new IllegalArgumentException();
         
      // eventuale ridimensionamento dinamico 
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }   
         
      // spostamento per inserimento ordinato per chiave - O(n)
      int i = vSize - 1;
      while (i >=0 && ((Entry)v[i]).getKey().compareTo(key) > 0)
      {
         v[i + 1] = v[i];
         i--;
      }
      
      // inserimento della nuova associazione
      v[i + 1] = new Entry(key, value);
      
      // incremento del numero di associazioni
      vSize++;   
   }    

   /**
     * @return vero se questa multimappa e' vuota, falso altrimenti
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
      
      // accesso alle chiavi - le chiavi sono gia' ordinate
      for (int i = 0; i < vSize; i++)
         a[i] = ((Entry)v[i]).getKey();

      return a;
   } 
   
   /**
      rende vuota questa multimappa
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
   public Object[] removeAll(K key) // O(logn) + k(molteplicita' della chiave)
   {     
      // ricerca della chiave specificata
      int n = search(key); // operazione O(logn)
      
      // chiave non presente
      if (n < 0)
         return new Object[0];  
         
      // NB: le operazioni seguenti hanno complessita' temporale pari a O(k)             
      
      // ricerca dell'indice massimo di chiave specificata
      int j = n + 1;
      while (j < vSize && ((Entry)v[j]).getKey().compareTo(key) == 0)
         j++;
      int jMax = j - 1;
      
      // ricerca di indice minimo di chiave specificata
      j = n - 1;
      while (j >= 0 && ((Entry)v[j]).getKey().compareTo(key) == 0)
         j--;
      int jMin = j + 1;
      
      // molteplicita' della chiave specificata
      int k = jMax - jMin + 1;
      
      // copia dei valori di chiave specificata - operazione O(k)
      Object[] r = new Object[k];
      int i =0;
      for (j = jMin; j <= jMax; j++ )
         r[i++] = ((Entry)v[j]).getValue();
      
      // cancellazione delle associazioni di chiave specificata
      System.arraycopy(v, jMax + 1, v, jMin, vSize - jMax);// spostamento ordinato 
               
      // decremento del numero di associazioni
      vSize = vSize - k;
      
      // garbage collector 
      j = vSize;    
      while (j < v.length && v[j] != null)       
         v[j++] = null;        
      
      return r;
   }
     
   /**
     * @return il numero di associazioni presenti in questa multimappa
     */
   public int size()
   {
      return vSize;
   }        
}
