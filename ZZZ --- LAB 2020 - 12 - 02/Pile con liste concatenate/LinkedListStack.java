/**
  * LinkedListStack
  * realizza l'interfaccia Stack usando internamente un array riempito parzialmente.
  * @author Adriano Luchetta
  * @version 3-Dic-2005
 */
 
public class LinkedListStack implements Stack
{
   // parte privata
   private ListNode head, tail;
   private int size;
   
   public LinkedListStack()
   {
      makeEmpty();
   }
   
   public boolean isEmpty()
   {
      return head == tail;
   }

   public void makeEmpty()
   {
      head = tail = new ListNode();
      size = 0;
   }
   
   public int size()
   {
      return size;
   }
   
   public void push(Object x)
   {
        //inserimento di x
      head.element = x;
      //creazione di new head dietro
      //a quello che prima era head
      head = new ListNode(null, head);
      //aumento size
      size++;
   }
   
   public Object top()
   {
      if (isEmpty())
         throw new EmptyStackException();

         //elemento dopo head
         //l'ultimo inserito
      return head.next.element;
   }
   
   public Object pop()
   {
       //si toglie l'ultimo inserito
       //quello dopo head
      Object tmp = top();
      
      head = head.next;
      head.element = null;
      size--;

      return tmp;
   }

   class ListNode
   {
      Object element;
      ListNode next;

      //oggetto e il next
      public ListNode(Object o, ListNode n)
      {
         element = o;
         next = n;
      }
      
      public ListNode()
      {
         this(null, null);
      }
   }
}
