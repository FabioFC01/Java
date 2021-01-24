/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 1.2.2017
  *
  * classe M - realizza l'ADT mappa - contenitore di associazioni chiave/valore
  * con chiave univoca
  * la chiave e il valore sono di tipo parametrico
  * realizzazione con array ordinato
  *
  *
  * typeparam K il tipo parametrico della chiave
  * typeparam V il tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class M<K extends Comparable, V> implements Map<K, V>
{                                                                              
   // parte privata
   private static final int INITIAL_CAPACITY = 1;
   private Object[] w;
   private int wSize;
   
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
      void setKey(K k)    { key = k;   }
      void setValue (V v) { value = v; }      
   }
   
   /**
      inizializza una mappa vuota
   */
   public M()
   {
      w = new Object[INITIAL_CAPACITY];         
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
      
      // associazione non presente
      if (n < 0)
         return null;  
                 
      // associazione presente
      return ((Entry)w[n]).getValue();      
   }
   
   // ricerca binaria
   private int search(K k)
   {    
      return search(w, 0, wSize - 1, k); // att.ne ultimo elemento wSize - 1!
   }
   
   // ricerca binaria 
   private int search(Object[] a, int from, int to, Object t)
   {
      if (from > to)
         return -1;
         
      int mid = (from + to) / 2;
      
      Comparable c = ((Entry)a[mid]).getKey();      
      if (c.compareTo(t) == 0) 
         return mid;
      else if (c.compareTo(t) < 0)
         return search(a, mid + 1, to, t);
      else
         return search(a, from, mid - 1, t);           
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
      
      // accesso alle chiavi gia' ordinate 
      for (int i = 0; i < wSize; i++)        // att.ne: estremo superiore wSize!
         keys[i] = ((Entry)w[i]).getKey();   // att.ne: forzamento necessario!
          
      return keys;
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
         V old = ((Entry)w[n]).getValue();

         // sostituzione della vecchia associazione con la nuova
         w[n] = new Entry(k, v);
      
         // restituzione del vecchio valore
         return old;
      }      
      
      // associazione non presente
      // eventuale ridimensionamento dinamico
      if (wSize >= w.length)
      {
         Object[] newW = new Object[2 * w.length];
         System.arraycopy(w, 0, newW, 0, w.length);
         
         w = newW;
      }
      
      // inserimento ordinato della nuova associazione
      int j = wSize - 1;
      while(j >=0 && ((Entry)w[j]).getKey().compareTo(k) > 0)
      {
         w[j + 1] = w[j];
         j--;     
      }     
      w[j + 1] = new Entry(k, v);
      
      // incremento del numero di associazioni
      wSize++;
      
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

      // memorizzazione del valore
      V ret = ((Entry)w[n]).getValue();
 
      // eliminazione dell'associazione - la sequenza e' importante!
      for (int j = n; j < wSize - 1; j++) // Att.ne: estremo superiore wSize - 1
         w[j] = w[j + 1]; 
         
      // eliminazione dell'associazione presente due volte
      w[wSize - 1] = null;
      
      // decremento del numero di associazioni
      wSize--;
      
      return ret;
   }   
   
   /**
      fornisce  il numero di associazioni presenti in questa mappa
      @return il numero di associazioni presenti in questa mappa
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
            
      // copia dei valori
      for (int i = 0; i < keys.length; i++)
         ret[i] = get(((K)keys[i]));
                        
      return ret;      
   }            
}
