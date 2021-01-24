/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe Q
  * Realizza una coda ovvero una collezione di elementi con politica di accesso
  * FIFO (First In First Out) dove il primo elemento inserito (fronte) e' anche
  * il primo estratto.
  *
  * Realizzazione tramite lista concatenata.
  *
  * typeparam T il tipo parametrico degli elementi di questa classe
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class Q<T> implements Queue<T> // realizza l'ADT CODA
{  
   // parte privata
   private ListNode head, tail;
   private int size;           // variabile per contare gli elementi della coda
   
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
   
   /**
      inizializza una coda vuota
   */
   public Q()
   {
      head = tail = new ListNode();
      size = 0;
   }

   /*
      Se la coda non e' vuota, estrae il fronte della coda e ne restituisce il
      valore. 
      @return il fronte della coda
      @throws EmptyQueueException se la coda e' vuota
   */
   public T dequeue() throws EmptyQueueException // O(1)
   {       
      // memorizzazione temporanea
      T ret = front(); // puo' lanciare EmptyQueueException
      
      // estrazione in testa
      head = head.getNext();
      head.setElement(null);
      
      // decremento del numero di associazioni
      size--;
         
      return ret; 
   }  
   
   /**
      Inserisce l'elemento specificato nella coda.
      @param x elemento da inserire nella coda
      @throws java.lang.IllegalArgumentException se l'elemento da inserire vale
              null
   */
   public void enqueue(T x) throws IllegalArgumentException // O(1)
   {
      // precondizioni
      if (x == null)
         throw new IllegalArgumentException();
         
      // inserimento in coda
      tail.setNext(new ListNode(x, null)); 
      tail = tail.getNext();
      
      // incremento del numero di elementi
      size++;  
   } 
   
   /**
      Se la coda non e' vuota, restituisce il fronte della coda.
      @return fronte della coda
      @throws EmptyQueueException se la coda e' vuota
   */
   public T front() throws EmptyQueueException // O(1)
   {
      // precondizioni
      if (isEmpty())
         throw new EmptyQueueException();
         
      // ispezione in testa
      return head.getNext().getElement();
   }
   
  /**
      @return true se la coda e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return head == tail;
   }   
   
   /**
      @return numero di elementi presenti nella coda
   */
   public int size()
   {
      return size;
   }   
   
   /**
      @return restituisce un array contenente gli elementi della coda nella
              sequenza FIFO con il fronte della coda posizionato all'indice
              zero. La dimensione dell'array sia pari al numero di elementi
              presenti nella coda e il metodo non lanci mai eccezioni.
   */
   public Object[] toArray() // O(n)
   {
      // generazione di array
      Object[] v = new Object[size];
      
      // popolamento dell'array a partire dal fronte
      int i = 0;
      ListNode n = head.getNext();
      while (n != null)
      {
         v[i++] = n.getElement();
         n = n.getNext();
      }
      
      return v;
   }
}  
