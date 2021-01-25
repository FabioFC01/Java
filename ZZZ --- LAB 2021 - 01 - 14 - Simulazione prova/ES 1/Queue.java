/**
  * FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 8.9.2020
  *
  * Interfaccia Queue - definisce una coda di elementi di tipo parametrico
  *
  * @see EmptyQueueException
  *
  * @author A. Luchetta
  * @version 05-09-2020
  */
public interface Queue<T>
{
  /**
     @return true se il contenitore e' vuoto, false altrimenti
  */
  boolean isEmpty();

  /**
     @return numero di elementi nel contenitore
  */
  int size();
  
  /**
     inserisce nella coda l'elemento specificato
     @param x elemento specificato
     @throws java.lang.IllegalArgumentException se l'elemento specificato vale null
  */
  void enqueue(T x);
  
  /**
     @return il fronte della coda
     @throw EmptyQueueException se la coda e' vuota
  */
  T front();  
  
  /**
     ispezione, estraendolo, l'elemento in fronte alla coda
     @return elemento in fronte alla coda
     @throw EmptyQueueException se la coda e' vuota
  */
  T dequeue() throws EmptyQueueException;
}
