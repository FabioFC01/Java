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
   private static final int CAPACITY = 31;
   private Object[] v;
   private int size;
   
  // classe interna 
  private class ListNode
  {
     // variabili di esemplare
     private T element;
     private ListNode next;
     
     // costruttore
     public ListNode(T e, ListNode n)
     {
        element = e;
        next = n; 
     }
     
     // costruttore
     public ListNode()
     {
        this(null, null);
     }
     
     // metodi di accesso
     public T getElement()     { return element; }
     public ListNode getNext() { return next;    }
     
     // metodi modificatori
     public void setElement(T e) { element = e;  }
     public void setNext(ListNode n) { next = n; }
  }   
   
   /**
      inizializza un insieme vuoto
   */
   public S()
   {
      // inizializzazione dell'array
      v = new Object[CAPACITY];

      // inizializzazione dei buckets
      for (int i = 0; i < v.length; i++)
         v[i] = new ListNode();
      
      // inizializzazione del numero di elementi
      size = 0;
   }

   /**
      inserisce nell'insieme l'elemento specificato se diverso da null e non gia' presente
      @param x l'elemento specificato
   */ 
   public void add(T x)  // O(n/M) nel caso medio e peggiore
   {
      // precondizioni
      if (x == null || contains(x)) 
         return;
               
      // calcolo della chiave ridotta
      int kr = hash(x);
      
      // inserimento nel bucket di chiave ridotta calcolata
      ListNode n = (ListNode)v[kr];  // nodo header del bucket
      n.setElement(x);               // inserimento nel nodo header
      v[kr] = new ListNode(null, n); // nuovo nodo header
      
      // incremento del numero di elementi
      size++;   
   }
   
   // calcolo della chiave ridotta
   private int hash(T x)
   {
      // calcolo della chiave ridotta - eventualmente negativa
      int h = x.hashCode() % v.length;

      // calcolo del valore assoluto
      if (h < 0)
         h = -h;
         
      return h;   
   }

   /**
      Verifica se l'elemento specificato e' contenuto nell'insieme
      @param x elemento specificato
      @return true se questo insieme contiene l'elemento specificato, false altrimenti
   */
   public boolean contains(T x)
   {
      // se x vale null, allora non e' presente
      if (x == null)
         return false;

      // calcolo della chiave ridotta
      int kr = hash(x);

      // ricerca lineare nel bucket selezionato
      ListNode n = ((ListNode)v[kr]).getNext();
      while (n != null)
      {
         if (n.getElement().compareTo(x) == 0)
            return true;
            
         n = n.getNext();         
      }

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
