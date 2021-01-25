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
   private Comparable[] v;
   private int vSize;
   
   /**
      inizializza un insieme vuoto
   */
   public S()
   {
      v = new Comparable[INITIAL_CAPACITY];
      vSize = 1;
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
         Comparable[] a = new Comparable[v.length];
         System.arraycopy(v, 0, a, 0, v.length);
         v = a;
      }
      
      // inserimento ordinato
      int j = vSize;
      while (j >= 0 && x.compareTo((T)v[j - 1]) < 0)
      {
         v[j] = v[j - 1];
         j--;
      }     
      v[j + 1] = x; 
             
      //incremento del numero di elementi 
      vSize++;     
   }

   /**
      Verifica se l'elemento specificato e' contenuto nell'insieme
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   public boolean contains(T x)
   {
      // ricerca binaria
      return search(v, 0, vSize - 1, x);
   }
   
   // ricerca binaria
   private boolean search(Comparable[] a, int from, int to, T target)
   {
      // caso base - l'elemento cercato non e' presente
      if (from > to)
         return false;
         
      // accesso all'elemento centrale
      int mid = (from + to) / 2;   // indice circa al centro dell'array
      T middle = (T)v[mid];        // elemento circa al centro dell'array
      
      // caso base - l'elemento ricercato e' l'elemento centrale
      if (middle.compareTo(target) == 0)
         return true; 
         
      // chiamate ricorsive
      else if (middle.compareTo(target) < 0) 
         return search(v, mid + 1, to, target);   // ricerca a destra
      else
         return search(v, from, mid - 1, target); // ricerca a sinistra            
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
