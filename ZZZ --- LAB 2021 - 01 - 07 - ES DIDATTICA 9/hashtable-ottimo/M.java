/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 1.2.2017
  *
  * classe M - realizza l'ADT mappa - contenitore di associazioni chiave/valore
  * con chiave univoca
  * la chiave e il valore sono di tipo parametrico
  * realizzazione con hash table
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
   private static final int CAPACITY = 97; // numero primo per uniformita' hash
   private Object[] v;                     // att.ne: array di Object
   private int size;
   
// classe interna Entry
   private class Entry
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
   
   // classe interna ListNode
   private class ListNode
   {
      // variabili di esemplare
      private Entry element;     // att.ne: l'elemento e' un'Entry
      private ListNode next;
      
      // costruttore
      public ListNode(Entry e, ListNode n)
      {
         setElement(e);
         setNext(n); 
      }
      
      // costruttore
      public ListNode()
      {
         this(null, null);
      }
      
      // metodi di accesso
      public Entry getElement() { return element; }
      public ListNode getNext() { return next;    }

      // metodi modificatori
      public void setElement(Entry e) { element = e;}
      public void setNext(ListNode n) { next = n;   }     
   }
   
   /**
      inizializza questa mappa vuota
   */
   public M()
   {
      // generazione dell'array
      v = new Object[CAPACITY];  // att,ne array di Object!

      // inizializzazione dei bucket 
      for (int i = 0; i < v.length; i++)
         v[i] = new ListNode(); // crea ListNode!
         
      size = 0;   
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
      ListNode n = search(k);
      
      // associazione non presente
      if (n.getNext() == null)
         return null;  
                 
      // associazione presente
      Entry e = n.getNext().getElement();
      
      return e.getValue();      
   }
   
   /*
      se la chiave e' presente nella mappa restituisce il riferimento al nodo
      che precede il nodo contenente la chiave specificata, altrimenti
      restituisce il nodo tail.
      - k chiave specificata
   */
   private ListNode search(K k)
   {
      // calcolo della chiave ridotta
      int i = h(k);
      
      // attraversamento del bucket
      ListNode n = (ListNode)v[i]; // att.ne forzamento necessario!      
      while (n.getNext() != null)
      {
         if (n.getNext().getElement().getKey().compareTo(k) == 0)
            break;        // trovato
         n = n.getNext();   
      }         

      return n;
   }
   
   // calcolo della chiave ridotta
   private int h(K k)
   {
      // generazione di hash positivo o negativo
      int i = k.hashCode() % v.length;

      // calcolo del modulo di hash 
      if (i < 0)
        i = -i;
        
      return i;            
   }
   
   /**
      verifica se questa mappa e' vuota
      @return true se questa mappa e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return size <= 0;
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
      Comparable[] keys = new Comparable[size];
      
      // copia delle chiavi
      int j = 0;
      for (int i = 0; i < v.length; i++)
      {
         // scorrimento dei bucket
         ListNode n = (ListNode)v[i];  // att.ne forzamento necessario!       
         while (n.getNext() != null)
         {
            keys[j++] = n.getNext().getElement().getKey(); 
            n = n.getNext();
         }       
      }
      
      // ordinamento
      sort(keys);
      
      return keys;
   }  
   
   // ordinamento per fusione 
   private void sort(Object[] a)
   {
      if (a.length < 2)
         return;
         
      int mid = a.length / 2;
      Object[] left = new Object[mid]; 
      Object[] right = new Object[a.length - mid];
      System.arraycopy(a, 0, left, 0, left.length);
      System.arraycopy(a, mid, right, 0, right.length);
      
      sort(left);
      sort(right);
      
      merge(a, left, right);  
   }
   
   // fusione 
   private void merge(Object[] a, Object[] b, Object[] c)
   {
      int ia = 0, ib = 0, ic = 0;
      
      while (ib < b.length && ic < c.length)
         if (((Comparable)b[ib]).compareTo(c[ic]) < 0) // att.ne: forzamento
            a[ia++] = b[ib++];                         // necessario
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
      ListNode n = search(k);
      
      // associazione non presente
      if (n.getNext() == null) 
      {
         // inserimento di una nuova associazione in un nuovo nodo
         n.setNext(new ListNode(new Entry(k, v), null)); //aggiunge l'associazione in coda al bucket

         // incremento del numero di associazioni
         size++; 
         
         return null;
      }
      
      // associazione presente nella mappa
      // memorizzazione del vecchio valore
      V ret = n.getNext().getElement().getValue();

      // sostituzione della vecchia associazione con la nuova
      n.getNext().setElement(new Entry(k, v));
      
      return ret;
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
      ListNode n = search(k);

      // associazione non presente
      if (n.getNext() == null)
         return null;

      // associazione presente
      // memorizzazione temporanea del valore
      V ret = n.getNext().getElement().getValue();
      
      // eliminazione del nodo contenente l'associazione da cancellare
      n.setNext(n.getNext().getNext());
 
      // decremento del numero di associazioni
      size--;
      
      return ret;
   }   
   
   /**
      fornisce il numero di associazioni contenute in questa mappa
      @return il numero di associazioni contenute in questa mappa
   */
   public int size()
   {
      return size;
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
      
      // generazione dell'array dei valori
      Object[] ret = new Object[keys.length];
            
      // accesso ai valori
      for (int i = 0; i < keys.length; i++)
         ret[i] = get(((K)keys[i]));
                        
      return ret;      
   }            
}
