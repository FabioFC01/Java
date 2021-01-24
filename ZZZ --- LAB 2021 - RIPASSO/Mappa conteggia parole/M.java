
public class M <K extends Comparable ,V extends Comparable> implements  Container {
   //classe privata listnode
   private class Listnode {
      //variabili di esemplare
      private K key;
      private V value;
      private Listnode next;

      //costruttore
      public Listnode (K k, V v, Listnode n) {
         setKey(k);
         setValue(v);
         setNext(n);
      }
      public Listnode () {
         this(null, null, null);
      }

      //metodi modificatori
      public void setKey ( K k)  {
         key = k;
      }
      public void setValue (V v) {
         value = v;
      }
      public void setNext (Listnode n) {
         next = n;
      }

      //metodi di accesso
      public K getKey () { return key;}
      public V getValue () { return value;}
      public Listnode getNext () { return next;}
   }
   //FINE CLASSE PRIVATA

   //VARIABILI DI ESEMPLARE
   private Object [] v;
   private int size;
   private final static int CAPACITY = 10853;

   //costruttore
   public M () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      v = new Object [CAPACITY];
      for (int i = 0; i < CAPACITY; i++){
         v[i] = new Listnode();
      }
      size = 0;
   }

   //size
   public int size () {
      return size;
   }

   //isEmpty
   public boolean isEmpty () {
      return size <= 0;
   }

   //hash
   private int hash (K obj) {
      int h = obj.hashCode() % CAPACITY;
      if (h < 0) { 
         h = -h;
      }

      return h;
   }

   //contains
   public boolean contains (K key) {
      if (key == null) {
         return false;
      }
      int index = hash(key);

      Listnode n = ((Listnode)v[index]).getNext();

      while (n != null) {
         if ((n.getKey()).compareTo(key) == 0){
            return true;
         }
         n = n.getNext();
      }
      return false;
   }

   //get
   public V get (K key) {
      if (key == null) {
         return null;
      }

      int index = hash(key);

      Listnode n = ((Listnode)v[index]).getNext();

      while (n != null) {
         if ((n.getKey()).compareTo(key) == 0){
            return (n.getValue());
         }
         n = n.getNext();
      }
      return null;
   }

   //put
   public V put (K key, V value) {
      if (key == null || value == null) {
         return null;
      }

      if (contains(key)) {

         int index = hash(key);
         Listnode n = ((Listnode)v[index]).getNext();

         while (n != null) {
            if ((n.getKey()).compareTo(key) == 0){
               V ritorno = n.getValue();
               n.setValue(value);
               return ritorno;
            }
            n = n.getNext();
         }
         return null;
      }
      //fine if

      //se non contiene già la chiave
      int index = hash(key);
      Listnode n = ((Listnode)v[index]);

      n.setNext(new Listnode(key, value, n.getNext()));
      size++;
      return null;
   }

   //max value
   public String [] max () {
      String parola = "";
      int maxValue = 0;

      for (int i = 0; i < CAPACITY; i++){
         Listnode n = ((Listnode)v[i]).getNext();

         while (n != null) {
            if (n.getValue().compareTo(maxValue) > 0) {
               maxValue = (Integer)n.getValue();
               parola = (String)n.getKey();
            }
            n = n.getNext();
         }


      }
      //abbiamo visto tutte le entry



      String [] ritorno = {maxValue + "   -   " + parola , parola};
      
      return ritorno;
   }


   //remove
   public V remove (K key) {
      if (key == null) {
         return null;
      }

      int index = hash(key);

      Listnode n = ((Listnode)v[index]);

      while (n.getNext() != null) {
         if (n.getNext().getKey().compareTo(key) == 0) {
            V ritorno = n.getNext().getValue();
            n.setNext(n.getNext().getNext());
            size--;
            return ritorno;
         }
         n = n.getNext();
      }
      return null;
   }



}