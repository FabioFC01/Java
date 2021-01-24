import java.util.NoSuchElementException;

//HASH TABLE

public class S <E extends Comparable> implements Set <E> {
   //CLASSE PRIVATA LISTNODE
   private class ListNode {
      //variabili di esemplare
      private E value;
      private ListNode next;

      //costruttore
      public ListNode (E e, ListNode n){
         setNext(n);
         setValue(e);
      }
      public ListNode () {
         this(null, null);
      }

      //metodi modificatori
      public void setValue (E v) { value = v;}
      public void setNext (ListNode n) { next = n;} 

      //metodi di accesso
      public E getValue () { return value;}
      public ListNode getNext () { return next;}
   }
   //FINE CLASSE PRIVATA LISTNODE

   //CLASSE INTERNA ITERATORE
   private class SetIterator <T> implements Iterator <T> {
      //variabili di esemplare
      private ListNode current; //nodo corrente
      private ListNode previous; //nodo precedente
      private int index;         //per ricordarsi del bucket attuale
   

      //costruttore
      public SetIterator () {
         index = 0;
         current = (ListNode)v[index];

         previous = null;
      }

      //hasNext
      public boolean hasNext () {
         if (current.getNext() != null) {
            return true;
         }
         index++;

         while (index < v.length) {
            if (((ListNode)v[index]).getNext() != null) {
               current = (ListNode)v[index];
               return true;
            }
            index++;
         }
         return false;
      }

      //next
      /**
       * @ return valore di current
       */
      public T next () throws NoSuchElementException {
         if (! hasNext()){
            throw new NoSuchElementException();
         }

         //avanzamento
         previous = current;
         current = current.getNext();

         //return
         return (T)current.getValue();
      }

      //remove
      public void remove () throws IllegalStateException {
         if (previous == null) {
            throw new IllegalStateException();
         }

         //salto
         previous.setNext(current.getNext());
         //assegnazione
         current = previous;
         previous = null;
         //diminuzione
         size--;
      }
   }

   //variabili di esemplare
   private Object [] v;
   private static final int CAPACITY = 97;
   private int size;

   //costruttori
   public S () {
      makeEmpty();
   }

   public S (E [] a){
      this();
      for (E e : a){
         add(e);
      }
   }
   public S (Set s){
      this();
      
      if (s == null) {
         return;
      }

      Iterator <E> iter = s.iterator();

      while (iter.hasNext()){
         add(iter.next());
      }
   }

   //makeEmpty
   public void makeEmpty () {
      v = new Object [CAPACITY];
      for (int i = 0; i < CAPACITY; i++) {
         v[i] = new ListNode();
      }
      size = 0;
   }

   //hash
   private int hash (Object e) {
      int ret = e.hashCode() % CAPACITY;
      if (ret < 0) {
         ret = -ret;
      }

      return ret;
   }

   //search
   /***
    * 
    * @param o
    * @return nodo dove si trova il nodo specificato o null se
               non dovesse essere presente
    */
   private ListNode search (Object o) {
      int h = hash(o);

      ListNode n = ((ListNode)v[h]).getNext();

      //scorriamo
      while (n != null) {
         if (n.getValue().equals(o)){
            return n;
         }
         n = n.getNext();
      }

      return null;
   }

   //contains
   public boolean contains (Object o) {
      if (o == null) {
         return false;
      }

      return search(o) != null;
   }

   //add
   public boolean add (E o) {
      if (o == null || contains(o)) {
         return false;
      }
         
      int h = hash(o);
      ListNode head = (ListNode)v[h];
      
      //inserimento valore
      head.setValue(o);
      //nuovo nodo testa del bucket
      v[h] = new ListNode (null, head);
      //incremento
      size++;

      return true;
   }

   //isEmpty
   public boolean isEmpty () {
      return size <= 0;
   }

   //size 
   public int size () {
      return size;
   }

   //min
   public E min () throws NoSuchElementException{
      if (isEmpty()){
         throw new NoSuchElementException();
      }

      Iterator <E> iter = this.iterator();
      E min = iter.next();
      E temp = null;

      while (iter.hasNext()){
         temp = iter.next();

         if (temp.compareTo(min) < 0){
            min = temp;
         }
      }

      return min;
   }

   //toArray
   public int toArray (Comparable [] a) {
      Iterator <E> iter = iterator();

      int i = 0;
      while (iter.hasNext()){
         a[i++] = iter.next();
      }

      return i;
   }

   //toSortedArray
   public int toSortedArray (E [] a) throws ArrayIndexOutOfBoundsException {
      if (a.length < size || a == null) {
         throw new ArrayIndexOutOfBoundsException();
      }

      int ret = toArray(a);

      mergeSort(a);

      return ret;
   }

   //altro to sorted array
   public int toSortedArrayComp (Comparable [] a) throws ArrayIndexOutOfBoundsException {
      if (a.length < size || a == null) {
         throw new ArrayIndexOutOfBoundsException();
      }

      int ret = toArray(a);

      mergeSort(a);

      return ret;
   }


   /**
      Fornisce un iteratore sulla sequenza
      @return un iteratore sugli elementi di tipo T
   */
   public Iterator<E> iterator() {
      return new SetIterator<E>();
   }


   //metodi privati di ordinamento

   private void mergeSort (Comparable [] a) {
      if (a.length < 2) {
         return;
      }
      int mid = a.length / 2;

      Comparable [] l = new Comparable [mid];
      Comparable [] r = new Comparable [a.length - mid];

      System.arraycopy(a, 0, l, 0, mid);
      System.arraycopy(a, mid, r, 0, a.length - mid);

      mergeSort(l);
      mergeSort(r);

      merge (a, l, r);
   }

   private void merge (Comparable [] a, Comparable [] l, Comparable [] r) {
      int ia = 0;
      int il = 0;
      int ir = 0;

      while (il < l.length && ir < r.length) {
         if (l[il].compareTo(r[ir]) < 0) {
               a[ia++] = l[il++];
         }
         else{
            a[ia++] = r[ir++];
         }
      }

      while (il < l.length) {
         a[ia++] = l[il++];
      }
      while (ir < r.length) {
         a[ia++] = r[ir++];
      }

   }


}