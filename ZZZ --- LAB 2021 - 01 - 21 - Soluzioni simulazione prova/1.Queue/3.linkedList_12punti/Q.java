/**
  * FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 8.9.2020
  *
  * Classe Q - realizza una coda di elementi di tipo parametrico
  *
  * @see EmptyQueueException
  * @see Queue
  *
  * @author A. Luchetta
  * @version 05-09-2020
  */
public class Q<T> implements Queue<T>
{
  // parte privata
  private ListNode head, tail;
  private int size;
  
  // classe interna 
  private class ListNode
  {
     // variabili di esemplare
     private T element;
     private ListNode next;
     
     // costruttore
     public ListNode(T e, ListNode n)
     {
        element = e;
        next = n; 
     }
     
     // costruttore
     public ListNode()
     {
        this(null, null);
     }
     
     // metodi di accesso
     public T getElement()     { return element; }
     public ListNode getNext() { return next;    }
     
     // metodi modificatori
     public void setElement(T e) { element = e;  }
     public void setNext(ListNode n) { next = n; }
  }
  
  // costruttore - Inizializza una coda vuota
  public Q()
  {
     head = tail = new ListNode();
     size = 0;
  }

  /**
     @return true se il contenitore e' vuoto, false altrimenti
  */
  public boolean isEmpty() { return false; }

  /**
     @return numero di elementi nel contenitore
  */
  public int size() { return 0; }
  
  /**
     inserisce nella coda l'elemento specificato
     @param x elemento specificato
     @throws java.lang.IllegalArgumentException se l'elemento specificato vale null
  */
  public void enqueue(T x) // O(1) nel caso medio, O(n) nel caso peggiore
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
     @return il fronte della coda
     @throw EmptyQueueException se la coda e' vuota
  */
  public T front()
  {
     return null;
  }
  
  /**
     ispezione, estraendolo, l'elemento in fronte alla coda
     @return elemento in fronte alla coda
     @throw EmptyQueueException se la coda e' vuota
  */
  public T dequeue() throws EmptyQueueException
  {
     return null;
  }
}
