//ARRAY ORDINATO - COPIATO DA ARRAY DISORDINATO

public class D<K extends Comparable,V> implements SortedMultimap<K,V> {
   //parte privata 
   private static final int INITIAL_CAPACITY = 1;
   private Object [] v;
   private int vSize;

   //classe interna
   private class Entry {
      //var. esemplare
      private K key;
      private V value;

      //costruttore
      public Entry (K k, V v){
         setKey(k);
         setValue(v);
      }
      public Entry () {
         this (null, null);
      }

      //metodi modificatori
      public void setKey (K k) {
         key = k;
      }
      public void setValue (V v) {
         value = v;
      }

      //metodi accesso
      public K getKey () { return key;}
      public V getValue () { return value;}
   }

   //costruttore
   public D () {
      makeEmpty();
   }


   //makeEmpty
   public void makeEmpty () {
      v = new Object [INITIAL_CAPACITY];
      vSize = 0;
   }

   public boolean isEmpty () {
      return vSize <= 0;
   }

   public int size () {
      return vSize;
   }

   /**
       * Fornisce i valori a cui la chiave specificata e' associata
       * @param key la chiave specificata
       * @return un array contenente i valori a cui la chiave specificata
       *         e' associata, o un array di dimensione nulla se questa multimappa
       *         non contiene associazioni per la chiave
       */
      //O ()
   public Object [] findAll (K key) {
      Object [] a = new Object [vSize];
      int aSize = 0;

      //accesso ai valori di chiave specificata
      int n = search (key);   //O (log n)

      if (n < 0) {
         return new Object [0];
      }

      a [aSize++] = ((Entry)v[n]).getValue();

      int i = n-1;

      //ricerca ad indici inferiori
      while (i >= 0  && ((Entry)v[i]).getKey().compareTo(key) == 0) {
         a[aSize++] = ((Entry)v[i]).getValue();
         i--;
      }

      //ricerca ad indici superiori
      i = n+1;
      while (i < vSize && ((Entry)v[i]).getKey().compareTo(key) == 0) {
         a[aSize++] = ((Entry)v[i]).getValue();
         i++;
      }

      //ridimensionamento
      Object [] r = new Object [aSize];
      System.arraycopy(a, 0, r, 0, aSize);

      return r;
   }

   //ricerca binaria
   private int search (K key) {
      return search (v, 0, vSize - 1, key);
   }

   private int search (Object [] a, int from, int to, Object rif){

   }

   /** 
       * Associa il valore specificato alla chiave specificata in questa
       * multimappa
       * @param key la chiave specificata
       * @param value il valore specificato
       * @throws java.lang.IllegalArgumentException se la chiave o il valore
       *          specificati valgono null
       */
   public void insert(K key, V value) {
      if (key == null || value == null) {
         throw new IllegalArgumentException();
      }

      //ridimensionamento dinamico
      if (vSize >= v.length) {
         Object [] newV = new Object [2 * v.length];
         System.arraycopy(v, 0, newV, 0, vSize);
         v = newV;
      }

      
      //spostamento per inserimento ordinato per chiave - O(n)
      int i = vSize - 1;
      while (i >= 0 && ((Entry)v[i]).getKey().compareTo(key) > 0) {
         v[i+1] = v[i];
         i--;
      }

      v[i+1] = new Entry (key, value);

      vSize++;
   }   
    
      /**
        * Fornisce le chiavi di questa multimappa
        * @return un array ordinato contenente le chiavi di questa multimappa o
        *         un array di dimensione nulla se questa multimappa e' vuota
        */
   public Comparable[] keys() {
      Comparable [] a = new Comparable [vSize];
      for (int i = 0; i < vSize; i++) {
         a[i] = ((Entry)v[i]).getKey();
      }

      return a;
   }   
           
      /**
        * Rimuove le associazioni di chiave specificata da questa multimappa 
        * @param key la chiave specificata
        * @return un array contenente i valori a cui la chiave specificata
        *         era associata, o un array di dimensione nulla se questa
                  multimappa non contiene associazioni per la chiave     
        */      
   public Object[] removeAll(K key) {
      int n = search(key);

      if (n < 0) {
         return new Object [0];
      }

      int j = n+1;

      while (j < vSize && ((Entry)v[i]).getKey().compareTo(key) == 0) {
            //inisci
      }

      //finisci
      
   } 





   //metodo privato sort
   private void sort (Comparable [] a) {
      if (a.length < 2) {
         return;
      }

      int mid = a.length / 2;

      Comparable [] l = new Comparable [mid];
      Comparable [] r = new Comparable [a.length - mid];

      System.arraycopy(a, 0, l, 0, mid);
      System.arraycopy(a, mid, r, 0, r.length);

      sort(l);
      sort(r);
   }

   //merge
   private void merge
}