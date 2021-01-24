/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe EQ: sottoclasse della classe Q.
  *
  * @see Q
  *
  * @typeparam T il tipo parametrico degli elementi di questa classe
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class EQ<T extends Comparable> extends Q<T> // sottoclasse della classe Q
{     
   /**
      costruttore: inizializza una coda vuota
   */   
   public EQ()
   {
      super();
   }

   /**
      Inserisce l'elemento specificato
      @param x elemento da inserire nella coda
      @throws java.lang.IllegalArgumentException se l'elemento da inserire vale null
   */
   public void enqueue(T x) throws java.lang.IllegalArgumentException // O(1)
   {
         super.enqueue(x);  // puo' lanciare java.lang.IllegalArgumentException
   }    
    
   /**
      @return restituisce un array contenente gli elementi della coda ordinati in senso crescente
              secondo il loro ordine naturale. La dimensione dell'array sia pari al
              numero di elementi presenti nella coda e il metodo non lanci mai eccezioni.
   */
   public Object[] toSortedArray()  // O(nlogn)
   {
      // acceso agli elementi di questa coda
      Object[] v = toArray();
      
      // ordinamento
      sort(v);
      
      return v;
   }
   
   /**
      restituisce unicamente gli elementi che compaiono una sola volta nella
      coda
      @return array di elementi che sono presenti una sola volta nella coda
   */
   // essendo il tipo parametrico T definito come un tipo che realizza
   // l'interfaccia Comparable, si preferisce confrontare gli elementi della
   // classe estesa tramite il metodo  compareTo, anziche' usare il metodo
   // equals 
   public Object[] getOnlyUniqueElements() // O(nlogn)
   {
      // se la coda estesa e' vuota o ha un solo elemento, viene restitito
      // l'array vuoto o l'array di un elemento
      if (size() < 2)
         return toArray();
         
      // generazione dell'array ordinato contenente gli elementi
      Object[] v = toSortedArray();
      
      // generazione dell'array per ospitare gli elementi unici
      Object[] a = new Object[v.length]; // array di elementi unici
      int ia = 0;                        // indice nell'array a     
      
      // gestione del primo elemento dell'array (caso particolare)
      int j = 0;
      T cur = (T) v[j];
      if (cur.compareTo(v[j + 1]) != 0)
         a[ia++] = cur;

      // scansione dell'array v dal secondo al penultimo elemento
      for (int i = 1; i < v.length - 1; i++)
      {
         // elemento corrente nell'array v
         cur = (T) v[i];        // forzamento necessario per invocare sotto il
                                // metodo compareTo                             
         if (cur.compareTo(v[i - 1]) != 0 && cur.compareTo(v[i + 1]) != 0)
            a[ia++] = cur;        
      }
      
      // gestione dell'ultimo elemento dell'array (caso particolare)
      j = v.length - 1;
      cur = (T) v[j];
      if (cur.compareTo(v[j - 1]) != 0)
         a[ia++] = cur;      
              
      // ridimensionamento per generare un array pieno
      Object[] r = new Object[ia];   // il numero di elementi nell'array a e' ia
      System.arraycopy(a, 0, r, 0, r.length);  
      
      return r;
   } 
   
   /**
      divide questa coda (detta coda sorgente) in un numero specificato di code
      (dette code destinazione) in base alle seguenti regole:
      - ciascun elemento della coda sorgente viene assegnato a una delle code
        destinazione
      - le code destinazione hanno lo stesso numero di elementi (a meno di una
        unita')
      - se l'elemento a precede l'elemento b nella coda sorgente e a e b sono
        assegnati alla stessa coda destinazione, allora a precede b nella coda
        destinazione.
      - l'esecuzione del metodo non modifica la coda sorgente  
      @param n numero specificato di code destinazione
      @return array di code di dimensione specificata n   
      @throws java.lang.IllegalArgumentException se n e' negativo  
   */ 
   public EQ[] split(int n)
   {
      // precondizioni
      if (n < 0)
         throw new IllegalArgumentException();
         
      // definizione e creazione delle code
      EQ[] q = new EQ[n];                 // array di code
      for (int i = 0; i < q.length; i++)  // attenzione: le code vanno generate!
         q[i] = new EQ();
                  
      // accesso agli elementi della coda estesa
      Object[] v = toArray();
      
      // inserimento nelle code
      for (int i = 0; i < v.length; i++)
      {
         T cur = (T)v[i];                   // il tipo del parametro di enqueue
         q[i % q.length].enqueue(cur);     // e' T, quindi il forzamento e'
                                            // necessario
      }
         
      return q;   
   }    
   
   // ordinamento mergesort O(nlogn)
   private static void sort(Object[] a)
   {
      if (a.length < 2)
         return;
         
      int mid = a.length / 2;
      Object[] left = new Object[mid];
      Object[] right = new Object[a.length - mid]; 
      System.arraycopy(a, 0, left, 0, mid);
      System.arraycopy(a, mid, right, 0, a.length - mid);
      sort(left);
      sort(right);
      
      merge(a, left, right);   
   }
   
   // ordinamento mergesort 
   private static void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
      {
         Comparable cur = (Comparable) b[ib];   // forzamento necessario per
         if (cur.compareTo(c[ic]) < 0)         // invocare il metodo compareTo
            a[ia++] = b[ib++];                 
         else                                  
            a[ia++] = c[ic++];                 
      }                                        
                                                         
      while (ib < b.length) 
         a[ia++] = b[ib++];
         
      while (ic < c.length) 
         a[ia++] = c[ic++];               
   } 
}  
