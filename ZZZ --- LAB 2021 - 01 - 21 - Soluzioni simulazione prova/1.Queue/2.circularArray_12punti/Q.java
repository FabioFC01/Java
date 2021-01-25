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
  * @version 14-01-2021
  */
public class Q<T> implements Queue<T>  // realizzazione con array circolare
{
  // parte privata
  private static final int INITIAL_CAPACITY = 1;
  private Object[] v;
  private int back, front;
  
  // costruttore - Inizializza una coda vuota
  public Q()
  {
     v = new Object[INITIAL_CAPACITY];
     back = 0;
     front = 0;
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
     @throws java.lang.IllegalArgumentException se l'elemento specificato vale
             null
  */
  public void enqueue(T x) // O(1) nel caso medio, O(n) nel caso peggiore
  {
     // precondizioni
     if (x == null)
        throw new IllegalArgumentException();
        
     // eventuale ridimensionamento dinamico - operazione O(n)
     if (increment(back) == front)
     {
        Object[] a = new Object[2 * v.length];
        int j = 0;         // indice per scandire l'array a da 0 a v.length - 1
        int i = front;     // indice per scandire l'array v da front fino a back
                           // eventualmente con incremento circolare

        // ciclo per copiare gli elementi dall'array v all'array a
        while (i != back)
        {
           a[j] = v[i];        // copia nell'aray a dell'elemento di v 
           j++;                // incremento dell'indice nell'array a
           i = increment(i);   // incremento circolare dell'indice nell'array v
        }
        front = 0;             // posizionamento di front all'indice zero
        back = j;              // posizionamento di back all'indice i
        v = a;
     } 
     
     // inserimento nella coda
     v[back] = x;  
     
     // avanzamento dell'indice back
     back = increment(back); 
  }
  
  // metodo di incremento
  private int increment(int k)
  {
     return (k + 1) % v.length;
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
