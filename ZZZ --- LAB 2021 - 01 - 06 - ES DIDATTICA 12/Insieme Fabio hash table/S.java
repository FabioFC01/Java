import java.util.NoSuchElementException;

public class S < E extends Comparable > implements Set <E> {
   //classe privata listnode
   private class ListNode {
      //varaibili di esemplare
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
      public void setValue (E e) { value = e;}
      public void setNext (ListNode n) { next = n;}

      //metodi di accesso
      public E getValue () { return value;}
      public ListNode getNext () { return next;}
   }

   //classe privata iteratore
   private class SetIterator implements Iterator <E> {
      //varaibili di esemplare
      private ListNode current;
      private ListNode previous;
      private int index;

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
               //current è head del bucket
               current = ((ListNode)v[index]);
               //previous = null;
               return true;
            }
            index++;
         }
         //sei alla fine biaatch
         return false;
      }

      //next
      public E next() throws NoSuchElementException {
         if (! hasNext()){
            throw new NoSuchElementException();
         }

         previous = current;
         current = current.getNext();
         
         E ret = current.getValue();
         return ret;
      }

      //remove
     /**
        rimuove l'ultimo l'elemento ispezionato da questo iteratore
        @throws java.lang.IllegalStateException se il metodo next non e' stato
                prima chiamato o il metodo remove è stato chiamato dopo l'ultima
                invocazione al metod next
     */
      public void remove() throws IllegalStateException {
         if (isEmpty() || previous == null) {
            throw new IllegalStateException();
         }

         //togli elemento
         previous.setNext(current.getNext());
         current = previous;
         previous = null;

         size--;
      }
   }
   //FINE  CLASSE PRIVATA SetIterator

   //variabili di esemplare insieme
   private Object [] v;
   private int size;
   private final static int CAPACITY = 97;

   //costruttore
   public S () {
      makeEmpty();
   }
   public S (E [] a){
      this();
      for (E val : a) {
         add(val);
      }
   }
   /*
   public S (Set<E> insiemeSet) {
      this();
      Iterator <E> iter = insiemeSet.iterator();
      if (insiemeSet == null) {
         return;
      }

      while(iter.hasNext()){
         add(iter.next());
      }
   }*/
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
      for (int i = 0; i < CAPACITY; i++){
         v[i] = new ListNode ();
      }
      size = 0;
   }

   //isEmpty
   public boolean isEmpty () {
      return size <= 0;
   }

   //size
   public int size () {
      return size;
   }

   //hash
   private int hash (Object o) {
      int h = o.hashCode() % CAPACITY;
      if (h < 0) {
         h = -h;
      }

      return h;
   }

   /**
        verifica se l'elemento specificato e' presente in questo insieme
        @param o l'elemento specificato
        @return true se questo insieme contiene l'elemento specificato o
                false altrimenti     
     */
    //O(n)
   public boolean contains(Object o) {
      Comparable [] valori = new Comparable [size]; 
      toArray(valori);
      for (Object e : valori) {
         if (e.equals(o)){
            return true;
         }
      }

      return false;
   }


   //ridà un array di oggetti dell'insieme
   //O(n)
   public int toArray (Comparable [] a )throws ArrayIndexOutOfBoundsException {
      int indexArray = 0;
      if (a.length < size || a == null) {
         throw new ArrayIndexOutOfBoundsException();
      }
      int i = 0;
      ListNode n;

      for (i = 0; i < CAPACITY; i++){
         n = ((ListNode)v[i]).getNext();

         //analizziamo il bucket
         while (n != null) {
            a[indexArray++] = n.getValue();
            n = n.getNext();
         }
      }

      return size;

   }

   //add
   /**
        inserisce in questo insieme l'elemento specificato se e' diverso da null e
        non e' gia' presente 
        @param e l'elemento specificato
        @return false se questo insieme conteneva gia' l'elemento specificato
     */
   public boolean add(E e) {
      if (contains(e)){
         return false;
      }

      int ind = hash(e);
      //prendiamo head, che ha valore nullo
      ListNode n = ((ListNode)v[ind]);
      n.setValue(e);
      //questo è il nuovo bucket di v[ind]
      v[ind] = new ListNode(null, n);
      //incremento
      size++;

      return true;
   }

   /**
        copia nell'array specificato gli elementi di questo insieme ordinati
        in senso crescente secondo il loro ordine naturale
        @param a array specificato
        @return numero di elementi di questo insieme copiati nell'array specif.to
        @throws java.lang.ArrayIndexOutOfBoundsException se la dimensione
                dell'array specificato e' minore della dimensione dell'insieme
          
     */
    //O(n*log(n))
   public int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException {
      if (a.length < size || a == null) {
         throw new ArrayIndexOutOfBoundsException();
      }

      //O(n)
      Comparable [] valori = new Comparable [size];
      toArray(valori);
      //O(n*log(n))
      mergesort(valori);
      //O(n)
      System.arraycopy(valori, 0, a, 0, valori.length);

      return valori.length;
   }
   //con comparable
   public int toSortedArrayComp (Comparable[] a) throws ArrayIndexOutOfBoundsException {
      if (a.length < size || a == null) {
         throw new ArrayIndexOutOfBoundsException();
      }

      //O(n)
      Comparable [] valori = new Comparable [size];
      toArray(valori);
      //O(n*log(n))
      mergesort(valori);
      //O(n)
      System.arraycopy(valori, 0, a, 0, valori.length);

      return valori.length;
   }

   //iteratore
   /**
      Fornisce un iteratore sulla sequenza
      @return un iteratore sugli elementi di tipo T
   */
   public Iterator<E> iterator() {
      return new SetIterator();
   }


   //mergesort
   private void mergesort (Comparable [] a) {
      if (a.length < 2) {
         return;
      }

      int mid = a.length / 2;

      Comparable [] l = new Comparable [mid];
      Comparable [] r = new Comparable [a.length - mid];

      System.arraycopy(a, 0, l, 0, l.length);
      System.arraycopy(a, mid, r, 0, r.length);

      mergesort(l);
      mergesort(r);

      merge(a, l, r);
   }

   //merge
   private void merge (Comparable[] a, Comparable [] l, Comparable [] r){
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

   // ricerca del minimo
   public E min() throws java.util.NoSuchElementException {
      if (isEmpty()) // gestione delle precondizioni - l'insieme è vuoto
         throw new java.util.NoSuchElementException();
  
      // iteratore per l'accesso agli elementi
      Iterator<E> iter = iterator();
  
      // ipotesi di minimo
      E min = iter.next();

      // Scansione dell'insieme - Ricerca del minimo
      while (iter.hasNext()) {
         E tmp = iter.next();
         if (tmp.compareTo(min) < 0)
             min = tmp;
      }
      return min;
   }
  

}