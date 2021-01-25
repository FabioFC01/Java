public class PDC <E> {
   //clase privata 
   private class Listnode {
      private E value;
      private Listnode next;
      private Listnode previous;


      public Listnode (E v, Listnode p, Listnode n) {
         value = v;
         next = n;
         previous = p;
      }

      public void setValue (E v) {
         value = v;
      }
      public void setNext (Listnode n) {
         next = n;
      }
      public void setPrevious (Listnode p) {
         previous = p;
      }

      public E getValue () { return value;}
      public Listnode getNext () { return next;}
      public Listnode getPrevious () { return previous;}

   }

   //variabili di esemplare
   private Listnode head, tail;
   private int size;


   //costruttore
   public PDC () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      head = new Listnode(null,null, null);
      tail = new Listnode(null, head, null);
      head.setNext(tail);
      //head --- tail
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

   //addFirst
   public void addFirst (E v) {
      head.setNext(new Listnode(v, head, head.getNext()));
      size++;

      (head.getNext().getNext()).setPrevious(head.getNext());

   }

   //addLast
   public void addLast (E v) {
      tail.setValue(v);
      size++;

      tail.setNext(new Listnode(null, tail, null));
      tail = tail.getNext();
   }

   //remove first
   public E removeFirst () {
      if (isEmpty()) {
         return null;
      }

      E rit = head.getNext().getValue();
      //si salta uno
      head.setNext(head.getNext().getNext());
      size--;

      (head.getNext()).setPrevious(head);

      return rit;
   }

   //removeLast
   public E removeLast () {
      if (isEmpty()) {
         return null;
      }

      E rit = tail.getPrevious().getValue();

      //si salta uno
      (tail.getPrevious().getPrevious()).setNext(tail);
      size--;
      tail.setPrevious(tail.getPrevious().getPrevious());

      return rit;
   }

   //getFirst
   public E getFirst () {
      if (isEmpty()) {
         return null;
      }

      return head.getNext().getValue();
   }

   //getLast
   public E getLast () {
      if (isEmpty()) {
         return null;
      }

      return tail.getPrevious().getValue();
   }
}