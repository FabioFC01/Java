/**
  * QueueByStacks
  * realizza una coda, usando due pile.
  * classe per esercitazione: laboratorio IX
  * La realizzazione e', ovviamente, inefficiente
  * @author Adriano Luchetta
  * @version 24.Nov.2006
  * @version 21-Nov-2005
  * @version 3-Dic-2004
  * @see Queue
*/
public class QueueByStacks implements Queue
{
   //parte privata
   Stack pila;
   
   //parte pubblica
   public QueueByStacks()
   {
      makeEmpty();
   }
   
   public void makeEmpty()
   {
      pila = new Stack();   
   }
   
   public boolean isEmpty()
   {
      return pila.isEmpty();
   }

   public int size()
   {
      return pila.size();
   }

   public void enqueue(Object obj)
   {
      pila.push(obj);
      //1
      //12
      //123
   }

   /**
      ispeziona l'elemento in testa alla coda.
      O(n)
      @return elemento in testa alla coda
      @throws EmptyQueueException se la coda e' vuota
   */
   public Object front() throws EmptyQueueException
   {
      if (isEmpty())
         throw new EmptyQueueException();

      // rovescia il contenuto di pila in tmpPila
      Stack tmpPila = new Stack();
      while (!pila.isEmpty())
         tmpPila.push(pila.pop());
         //push nella temp di pop della pila

      // ispeziona l'elemento in cima a tmpPila
      //che era in fondo a Pila, come in una coda
      Object obj = tmpPila.top();
      
      // rovescia il contenuto di tmpPila in pila
      // ripristinando l'ordine iniziale
      while (!tmpPila.isEmpty())
         pila.push(tmpPila.pop());
         
      return obj;
   }
   
   /**
      estrae l'elemento in testa alla coda.
      O(n)
      @return elemento in testa alla coda
      @throws EmptyQueueException se la coda e' vuota
   */
   public Object dequeue() throws EmptyQueueException
   {
       if (isEmpty())
         throw new EmptyQueueException();

      // rovescia il contenuto di pila in tmpPila
      Stack tmpPila = new Stack();
      while (!pila.isEmpty())
         tmpPila.push(pila.pop());

      // estrae l'elemento in cima a tmpPila
      Object obj = tmpPila.pop();

      // rovescia il contenuto di tmpPila in pila
      // ripristinando l'ordine iniziale
      while (!tmpPila.isEmpty())
         pila.push(tmpPila.pop());
         
      return obj;
   }
}
