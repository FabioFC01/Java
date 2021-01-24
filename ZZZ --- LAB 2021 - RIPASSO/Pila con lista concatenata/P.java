public class P<T> {
   //classe privata
   // classe interna 
   private class ListNode
   {
      // variabile de semplare
      private T element;
      private ListNode next;
      
      // costruttore
      ListNode(T e, ListNode n)
      {
         element = e;
         next = n;
      }
      
      // costruttore
      ListNode()
      {
         this(null, null);
      }
      
      // metodi di accesso
      public T getElement() { return element; }
      public ListNode getNext()    { return next; }

      // metodi modificatori
      public void setElement(T e) { element = e; }
      public void setNext(ListNode n)  { next = n; }
   }


   //variabili di esemplare
   private ListNode head;
   private int size;

   //costruttore
   public P () {
      makeEmpty();
   }


   //makeEmpty
   public void makeEmpty () {
      head = new ListNode();
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

   //top
   public T top () {
      if (isEmpty()) {
         return null;
      }

      T ret = head.getNext().getElement();

      return ret;
   }

   //push
   public void push (T obj) {
      if (obj == null) {
         throw new TuaMadreException();
      }

      head.setNext(new ListNode(obj, head.getNext()));
      size++;
   }

   //pop
   public T pop () {
      if (isEmpty()) {
         throw new TuaMadreException();
      }

      T ret = top();
      head.setNext(head.getNext().getNext());
      size--;

      return ret;
   }


}