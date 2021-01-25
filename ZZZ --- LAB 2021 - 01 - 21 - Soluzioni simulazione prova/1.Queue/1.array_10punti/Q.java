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
  private static final int INITIAL_CAPACITY = 1;
  private Object[] v;
  private int vSize;
  
  // costruttore - Inizializza una coda vuota
  public Q()
  {
     v = new Object[INITIAL_CAPACITY];
     back = front = 0;
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
        
     // eventuale ridimensionamento dinamico - operazione O(n)
     if (vSize >= v.length)
     {
        Object[] a = new Object[2 * v.length];
        System.arraycopy(v, 0, a, 0, v.length);
        v = a;
     } 
     
     // inserimento nella coda e incremento del numero di elementi
     v[vSize++] = x;   
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
