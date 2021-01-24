/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe Q
  * Realizza una coda ovvero una collezione di elementi con politica di accesso
  * FIFO (First In First Out) dove il primo elemento inserito (fronte) e' anche
  * il primo estratto.
  *
  * realizzazione con array parzialmente riempito
  *
  * @typeparam T il tipo parametrico degli elementi di questa coda
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class Q<T> implements Queue<T> // realizza l'ADT CODA
{  
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   private Object[] v;                   // array di Object
   private int vSize;  
   
   // costruttore
   public Q()
   {
      v = new Object[INITIAL_CAPACITY];  // array di Object!
      vSize = 0;
   }

   /*
      Se la coda non e' vuota, estrae il fronte della coda e ne restituisce il
      valore. 
      @return il fronte della coda
      @throws EmptyQueueException se la coda e' vuota
   */
   public T dequeue() throws EmptyQueueException // O(n)
   {       
      // memorizzazione temporanea
      T ret = front();        // puo' lanciare EmptyQueueException

      // spostamento mantenendo la sequenza - O(n)
      for (int i = 0; i < vSize - 1; i++)  // attenzione all'indice superiore!
         v[i] = v[i + 1];

      v[vSize - 1] = null;                 // garbage collector

      // decremento del numero di elementi
      vSize--;
         
      return ret; 
   }  
   
   /**
      Inserisce l'elemento specificato nella coda.
      @param x elemento da inserire nella coda
      @throws java.lang.IllegalArgumentException se l'elemento da inserire vale null
   */
   public void enqueue(T x) throws IllegalArgumentException // O(n) nel caso peggiore
   {                                                        // O(1) nel caso medio
      // precondizioni
      if (x == null)
         throw new IllegalArgumentException();
         
      // ridimensionamento dinamico - O(n)
      if (vSize >= v.length)
      {
         Object[] newV = new Object[2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         
         v = newV;  
      }  
         
      // inserimento nella coda
      v[vSize] = x;
      
      // incremento del numero di elementi
      vSize++;
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
      return (T)v[0];
   }
   
  /**
      @return true se la coda e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return vSize == 0;
   }   
   
   /**
      @return numero di elementi presenti nella coda
   */
   public int size()
   {
      return vSize;
   }   
   
   /**
      @return restituisce un array contenente gli elementi della coda nella
              sequenza FIFO con il fronte della coda posizionato all'indice
              zero. La dimensione dell'array sia pari al numero di elementi
              presenti nella coda e il metodo non lanci mai eccezioni.
   */
   public Object[] toArray() // O(n)
   {
      // generazione dell'array
      Object[] t = new Object[vSize];
      
      // popolamento dell'array
      System.arraycopy(v, 0, t, 0, vSize);
      
      return t;
   }
}  
