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

  //COCIANCICH FABIO - 2016268
public class S<T extends Comparable<T>> //ADT insieme di elementi comparabili di tipo generico
{
   // parte privata
   private Object [] v;
   private int size;

   
   /**
      inizializza un insieme vuoto
   */
   public S()
   {
      makeEmpty();
   }

   public void makeEmpty () {
      v = new Object [1];
      size = 0;
   }

   /**
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente
      @param x l'elemento specificato
   */ 
   public void add(T x)
   {
      if (x == null || contains(x)) {
         return;
      }

      if (size >= v.length){
         Object [] newV = new Object [2 * v.length];
         System.arraycopy(v, 0, newV, 0, size);
         v = newV;
      }

      int j = size -1;

      while (j >= 0 && ((Comparable)v[j]).compareTo(x) > 0) {
         v[j+1] = v[j];
         j--;
      }
      v[j+1] = x;
      size++;
   }

   /**
      Verifica se l'elemento specificato e' contenuto nell'insieme
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   public boolean contains(T x)
   {
      return binarySearch(0,v.length ,x) > -1;
   }

   //ricerca binaria
   private int binarySearch (int from, int to, Object o) {
      if (from > to) {
         return -1;
      }
      int mid = (to+ from)/2;
      Comparable k = (Comparable)(v[mid]);

      if (k.compareTo(o) == 0) {
         return mid;
      }
      else if (k.compareTo(o) > 0){
         return binarySearch(from, mid-1, o);
      }
      else {
         return binarySearch(mid + 1, to, o);
      }


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
