/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe Q
  * Realizza una coda ovvero una collezione di elementi con politica di accesso FIFO (First In
  * First Out) dove il primo elemento inserito (fronte) e' anche il primo estratto.
  *
  * realizzazione con array circolare
  *
  * @typepram il tipo parametrico di questa coda
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class Q<T> implements Queue<T> // realizza l'ADT CODA
{  
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   private int front, back;
   private Object[] v;                     // attenzione: array di Object!
   
   
   // costruttore
   public Q()
   {
      front = back = 0;
      v = new Object[INITIAL_CAPACITY];    // attenzione: array di Object!
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
      T ret = front();    // puo' lanciare EmptyQueueException

      v[front] = null;         // garbage collector

      // avanzamento dell'indice front
      front = increment(front);
         
      return ret; 
   }  
   
   /**
      Inserisce l'elemento specificato nella coda.
      @param x elemento da inserire nella coda
      @throws java.lang.IllegalArgumentException se l'elemento da inserire vale
              null
   */
   public void enqueue(T x) throws IllegalArgumentException // O(n) nel caso peggiore
   {                                                        // O(1) nel caso medio
      // precondizioni
      if (x == null)
         throw new IllegalArgumentException();
         
      // ridimensionamento dinamico - O(n)
      if (isFull())
      {
         Object[] newV = new Object[2 * v.length];
         int i = front;     // indice nell'array newV
         int j = front;     // indice nell'array v
         while (j != back)
         {
            newV[i++] = v[j];     // copia da v a newV
            j = increment(j);     // incremento circolare dell'indice di v
         }
         
         v = newV;

         // impostazione del nuovo indice back
         back = i;  // front rimane invariato, back si sposta   
      }  
         
      // inserimento nella coda
      v[back] = x;
      
      // avanzamento di back
      back = increment(back);
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
      return (T)v[front];
   }
   
  /**
      @return true se la coda e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return front == back;
   }   
   
   /**
      @return numero di elementi presenti nella coda
   */
   public int size()
   {
      if (front <= back)
         return back - front;
      else
         return v.length - front + back;   
   }   
   
   /**
      @return restituisce un array contenente gli elementi della coda nella sequenza FIFO con il
              fronte della coda posizionato all'indice zero. La dimensione dell'array sia pari al
              numero di elementi presenti nella coda e il metodo non lanci mai eccezioni.
   */
   public Object[] toArray() // O(n)
   {
      // array
      Object[] t = new Object[size()];    // nuovo array
      int it = 0;                         // indice nell'array t    
 
      // popolamento dell'array a partire dalla testa
      int j = front;           // indice nell'array v
      while (j != back)
      {
         t[it++] = v[j];       // copia dall'array v all'array t
         j = increment(j);     // incremento circolare
      }
      
      return t;
   }
   
   // increment
   private int increment(int n)
   {
      return (n + 1) % v.length;
   }
   
   // isFull
   private boolean isFull()
   {
      return increment(back) == front;
   }
}  
