/**
  * LinkedListStack
  * realizza l'interfaccia Stack usando internamente un array riempito parzialmente.
  * @author Adriano Luchetta
  * @version 3-Dic-2005
 */

 //PILA
 //FILO
 
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
      head.element = x;
      head = new ListNode(null, head);
      size++;
   }
   
   public Object top()
   {
      if (isEmpty())
         throw new EmptyStackException();

      return head.next.element;
   }
   
   public Object pop()
   {
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
