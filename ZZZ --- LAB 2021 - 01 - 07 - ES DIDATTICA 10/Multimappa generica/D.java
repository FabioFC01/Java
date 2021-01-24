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
   public Object [] findAll (K key) {
      Object [] a = new Object [vSize];
      int aSize = 0;

      for (int i = 0; i < vSize; i++){
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            a[aSize++] = ((Entry)v[i]).getValue();
         }
      }

      Object [] r = new Object [aSize];
      System.arraycopy(a, 0, r, 0, aSize);

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

      //inserimento associazione
      v[vSize++] = new Entry (key, value);
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

      sort (a);

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
      Object [] r = findAll(key);

      int i = 0;
      while (i < vSize){
         if (((Entry)v[i]).getKey().compareTo(key) == 0) {
            v[i] = v[vSize - 1]; //cancellazione associazione
            v[vSize - 1] = null;
            vSize--;
         }
         else {
            i++;  //gestione chiave successiva
         }
      }

      return r;
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