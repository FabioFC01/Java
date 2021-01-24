public class C <T> {

   // variabile de semplare
   private class ListNode {
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
   private ListNode head, tail;
   private int size;

   //costruttore
   public C () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      head = tail = new ListNode();
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

   //front
   public T front () {
      if (isEmpty()) {
         return null;
      }

      T ret = head.getNext().getElement();
      return ret;
   }

   //enqueue
   //lo aggiunti dopo tail
   public void enqueue (T obj) {
      tail.setNext(new ListNode(obj, null));
      tail = tail.getNext();
      size++;
   }

   //dequeue
   //togli elemento dopo head
   public T dequeue () {
      if (isEmpty()) {
         return null;
      }

      T ret = head.getNext().getElement();
      head = head.getNext();
      head.setElement(null);
      size--;

      return ret;
   }
}