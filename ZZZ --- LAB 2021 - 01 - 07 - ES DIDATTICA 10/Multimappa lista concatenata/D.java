public class D <K extends Comparable, V> implements SortedMultimap <K,V> {
   //parte privata
   private ListNode head;
   private int size;

   private class ListNode {
      private K key;
      private V value;
      private ListNode next;

      //costruttore
      public ListNode (K k, V v , ListNode n) {
         setKey(k);
         setValue(v);
         setNext(n);
      }
      public ListNode () {
         this (null, null, null);
      }

      //metodi modificatori
      public void  setKey ( K k) {
         key = k;
      }
      public void setValue ( V v) {
         value = v;
      }
      public void setNext ( ListNode n) {
         next = n;
      }

      //metodi accesso
      public K getKey () { return key; }
      public V getValue () { return value;}
      public ListNode getNext () { return next;}
   }

   //makeEmpty
   public void makeEmpty () {
      head = new ListNode ();
      size = 0;
   }

   //insert
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

      head.setKey(key);
      head.setValue(value);
      head = new ListNode (null, null, head);

      //incremento
      size++;
   }

   /**
       * Fornisce i valori a cui la chiave specificata e' associata
       * @param key la chiave specificata
       * @return un array contenente i valori a cui la chiave specificata
       *         e' associata, o un array di dimensione nulla se questa multimappa
       *         non contiene associazioni per la chiave
       */      
   public Object[] findAll(K key) {
      Object [] a = new Object [size];
      int aSize = 0;

      ListNode n = head.getNext();
      while(n != null) {
         if (n.getKey().compareTo(key) == 0){
            a[aSize++] = n.getValue();
         }
         n = n.getNext();
      }

      Object [] r = new Object [aSize];
      System.arraycopy(a, 0, r, 0, aSize);

      return r;
   }

   /**
       * Fornisce le chiavi di questa multimappa
       * @return un array ordinato contenente le chiavi di questa multimappa o
       *         un array di dimensione nulla se questa multimappa e' vuota
       */
   public Comparable[] keys() {
      Comparable [] a = new Comparable [size];
      int i = 0;

      //finisci - foto su google foto
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

      ListNode n = head;

      while (n.getNext() != null) {
         if (n.getNext().getKey().compareTo(key) == 0){
            n.setNext(n.getNext().getNext()); //elimino un nodo
            size--;
         }
         else {
            n = n.getNext();
         }
      }
      return r;
   }
}