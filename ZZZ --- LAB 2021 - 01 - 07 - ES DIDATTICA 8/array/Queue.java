/**
  *           FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                    Prova di Programmazione - 17-02-2015
  *
  * Interfaccia Queue
  * Definisce una coda ovvero una collezione di elementi con politica di accesso
  * FIFO (First In First Out) dove il primo elemento inserito (fronte) e' anche 
  * il primo estratto.
  *
  * @typeparam T il tipo parametrico degli elementi di questa coda
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public interface Queue<T>  // ADT Coda
{  
   /*
      Se questa coda non e' vuota, estrae il fronte della coda e ne restituisce
      il valore. 
      @return il fronte di questa coda
      @throws EmptyQueueException se questa coda e' vuota
   */
   T dequeue() throws EmptyQueueException;   
   
   /**
      Inserisce l'elemento specificato in questa coda.
      @param x elemento da inserire in questa coda
      @throws java.lang.IllegalArgumentException se l'elemento da inserire vale
              null
   */
   void enqueue(T x) throws IllegalArgumentException; 
   
   /**
      Se questa coda non e' vuota, restituisce il fronte della coda.
      @return fronte di questa coda
      @throws EmptyQueueException se questa coda e' vuota
   */
   T front() throws EmptyQueueException;
   
  /**
      @return true se questa coda e' vuota, false altrimenti
   */
   boolean isEmpty();   
   
   /**
      @return numero di associazioni presenti in questa coda
   */
   int size();   
   
   /**
      @return restituisce un array contenente gli elementi di questa coda nella
              sequenza FIFO con il fronte di questa coda posizionato all'indice
              zero. La dimensione dell'array sia pari al numero di elementi
              presenti in questa coda e il metodo non lanci mai eccezioni.
   */
   Object[] toArray();  
}  
