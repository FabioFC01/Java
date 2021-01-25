/**
  * FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 25.8.2020
  *
  * MyArrayList
  *
  * Realizza un vettore.
  * Programmazione generica.
  * Usa come struttura dati un array riempito parzialmente che viene
  * dinamicamente ridimensionato in caso di necessita'.
  *
  * @version 9-Dec-2013
  * @author Adriano Luchetta
  * @param <E> il tipo di esemplari gestiti dalla classe
  * @see Container
  *
  */
  public class SMyArrayList<E extends Comparable<E>> extends MyArrayList<E>  
  {  
     /**
        restituisce il minimo del vettore, se il vettore non e' vuoto, null altrimenti
     */
     public E min()
     {
        // caso base
        if (isEmpty())
           return null;
           
        // semplificazione del problema
        E min1 = remove(0); 
        
        // caso base - la lista ha un solo elemento
        if (isEmpty())
           return min1;
           
        // chiamata ricorsiva
        E min2 = min(); 
        
        // inserimento dell'elemento precedentemente estratto
        add(0, min1);  
        
        // calcolo del minimo
        if (min1.compareTo(min2) < 0)
           return min1;
        else
           return min2;                    
     }
  }