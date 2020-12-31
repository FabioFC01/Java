/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 22.2.2017
  *
  * classe M - realizza l'ADT mappa - contenitore di associazioni chiave/valore
  * con chiave univoca
  * la chiave e il valore sono di tipo parametrico
  * realizzazione con array non ordinato
  *
  * typeparam K il tipo parametrico della chiave
  * typeparam V il tipo parametrico del valore
  *
  * @see Map
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class M<K extends Comparable, V> implements Map<K, V>
{                                                                              
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   private Object[] w;    // attenzione: array di Object!
   private int wSize;
   
   // -- INIZIO CLASSE INTERNA ---
   private class Entry // classe interna
   {
      // variabili di esemplare
      private K key;
      private V value;
      
      // costruttore
      public Entry(K k, V v)
      {
         setKey(k);
         setValue(v);
      }
      
      // metodi di accesso
      public K getKey()   { return key;  }
      public V getValue() { return value;}
      
      // metodi modificatore
      public void setKey(K k)    { key = k;   }
      public void setValue (V v) { value = v; }      
   }
   
   /**
      inizializza una mappa vuota
   */
   public M()
   {
      w = new Object[INITIAL_CAPACITY];  // att.ne array di Object!         
      wSize = 0;   
   }

   /**
      restituisce il valore associato alla chiave specificata
      @param key la chiave specificata
      @return valore associato alla chiave specificata key o null se la chiave
              specificata non e' presente nella mappa
   */ 
   public V get(K k)
   {
      // ricerca
      int n = search(k);
      
      // associazione non presente, valore -1
      if (n < 0)
         return null;  
                 
      // associazione presente
      Entry e = (Entry)w[n];     // attenzione: forzamento necessario
      return e.getValue();      
   }
   
   // ricerca lineare
   private int search(K k)
   {
      for (int i = 0; i < wSize; i++)   // attenzione: estremo superiore wSize!
         if (((Entry)w[i]).getKey().equals(k)) // att.ne: forzamento necessario!
            return i;                          // notare che se k vale null      
                                               // il metodo non lancia eccezioni
      return -1;                               // e restituisce -1
   }
   
   /**
      verifica se questa mappa e' vuota
      @return true se questa mappa e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return wSize <= 0;
   }
   
   /**
      accede alle chiavi di questa mappa
      @return se questa mappa non e' vuota restituisce un array ordinato
              contenente le chiavi delle associazioni presenti o altrimenti un
              array di dimensione nulla.
   */
   public Comparable[] keySet()
   {
      // generazione dell'array per memorizzare le chiavi
      Comparable[] keys = new Comparable[wSize];
      
      // copia delle chiavi della mappa
      for (int i = 0; i < wSize; i++)
         keys[i] = ((Entry)w[i]).getKey();   // att.ne: forzamento necessario
      
      // ordinamento delle chiavi
      sort(keys);
      
      return keys;
   }  
   
   // ordinamento per fusione
   private void sort(Comparable[] a)
   {
      if (a.length < 2)
         return;
         
      int mid = a.length / 2;
      Comparable[] left = new Comparable[mid]; 
      Comparable[] right = new Comparable[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);  
   }
   
   // fusione
   private void merge(Comparable[] a, Comparable[] b, Comparable[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (b[ib].compareTo(c[ic]) < 0)
            a[ia++] = b[ib++];
         else
            a[ia++] = c[ic++];
            
       while (ib < b.length)
          a[ia++] = b[ib++];     
            
       while (ic < c.length)
          a[ia++] = c[ic++];                  
   }     

   /**
      se questa mappa non contiene un'associazione di chiave specificata,
      aggiunge l'associazione di chiave e valore specificati e restituisce null,
      altrimenti sostituisce l'associazione presente di chiave specificata con
      la nuova associazione di valore specificayo e restituisce il vecchio
      valore che e' stato sostituito
      @param key la chiave specificata
      @param value il valore specificato
      @return null se questa mappa non contiene un'associazione di chiave
             specificata o altrimenti il vecchio valore associato alla chiave
      @throws IllegalArgumentException se key o value valgono null
   */
   public V put(K k, V v)
   {
      // gestione delle precondizioni
      if (k == null || v == null)
         throw new IllegalArgumentException();
         
      // ricerca
      int n = search(k);
      
      // associazione presente
      if (n >= 0)
      {
         // memorizzazione del vecchio valore
         Entry e = (Entry)w[n];
         V old = e.getValue();
         //V old = ((Entry)w[n]).getValue();  // att.ne: forzamento necessario!

         // sostituzione della vecchia associazione con la nuova
         w[n] = new Entry(k, v);             
      
         // restituzione del vecchio valore
         return old;
      }      
      
      // associazione non presente
      // eventuale ridimensionamento dinamico dell'array
      if (wSize >= w.length)
      {
         Object[] newW = new Object[2 * w.length];
         System.arraycopy(w, 0, newW, 0, w.length);
         
         w = newW;
      }
      
      // inserimento della nuova associazione e incremento del numero di 
      // associazioni
      w[wSize++] = new Entry(k, v);
      
      return null;
   }    
  
   /**
      elimina da questa mappa l'associazione di chiave specificata e ne
      restituisce il valore   
      @param key la chiave specificata
      @return null se in questa mappa non e' presente un'associazione di chiave
              specificata o, altrimenti, il valore associato alla chiave
              specificata
   */
   public V remove(K k)
   {
      // ricerca
      int n = search(k);
      
      // associazione non presente      
      if (n < 0)
         return null;

      // associazione presente
      // memorizzazione del valore
      V ret = ((Entry)w[n]).getValue();

      // cancellazione dell'associazione - la sequenza non e' importante!
      w[n] = w[wSize - 1];
      
      // cancellazione di elemento ripetuto
      w[wSize - 1] = null;
      
      // decremento del numero di associazioni
      wSize--;
      
      return ret;
   }   
   
   /**
      fornisce il numero di associazioni contenute in questa mappa
      @return il numero di associazioni contenute in questa mappa
   */
   public int size()
   {
      return wSize;
   } 
   
   /**
      accede ai valori di questa mappa
      @return array contenente i valori della associazioni presenti in questa
              mappa o un array di dimensione nulla se la mappa e' vuota
   */ 
   public Object[] values()
   {    
      // accesso alle chiavi
      Object[] keys = keySet();
      
      // generazione di un array per memorizzare i valori
      Object[] ret = new Object[keys.length];
            
      // copia dei valori delle associazioni
      for (int i = 0; i < keys.length; i++)
         ret[i] = get(((K)keys[i]));
                        
      return ret;      
   }            
}
