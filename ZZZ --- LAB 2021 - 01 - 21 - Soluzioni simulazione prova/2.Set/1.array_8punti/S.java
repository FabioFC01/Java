/**
  * FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 8.9.2020
  *
  * Realizza un insieme di elementi di tipo generico comparabili
  *
  * @param T il tipo generico degli elementi dell'insieme
  *
  * @author A. Luchetta
  * @version 03-Sett-2020
  */
public class S<T extends Comparable<T>> //ADT insieme di elementi comparabili di tipo generico
{
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   private Object[] v;
   private int vSize;
   
   /**
      inizializza un insieme vuoto
   */
   public S()
   {
      v = new Object[INITIAL_CAPACITY];
      vSize = 0;
   }

   /**
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente
      @param x l'elemento specificato
   */ 
   public void add(T x)
   {
      // precondizioni
      if (x == null || contains(x)) 
         return;
               
      // eventuale ridimensionamento dinamico
      if (vSize >= v.length)
      {
         Object[] a = new Object[v.length];
         System.arraycopy(v, 0, a, 0, v.length);
         v = a;
      }
      
      // inserimento e incremento del numero di elementi
      v[vSize++] = x;
   }

   /**
      Verifica se l'elemento specificato e' contenuto nell'insieme
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   public boolean contains(T x)
   {
      // ricerca lineare
      for (int i = 0; i < vSize; i++)
         if (((T)v[i]).equals(x))
            return true;

      return false;
   }
   
   /**
      Verifica se l'insieme e' vuoto
      @return true se questo insieme e' vuoto, false altrimenti
   */
   public boolean isEmpty()
   {
      return false;
   }
     
   
   /**
      Fornisce  il numero di elementi contenuti dell'insieme
      @return il numero di elementi contenuti in questo insieme
   */
   public int size()
   {
      return 0;
   }
   
   /**
      @return array ordinato contenente gli elementi dell'insieme
   */
   public Comparable[]toArraySet()
   {
      return null;
   }        
}
