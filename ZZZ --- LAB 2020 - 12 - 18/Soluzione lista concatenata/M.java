/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 22.2.2017
  *
  * classe M - realizza l'ADT mappa - contenitore di associazioni chiave/valore
  * con chiave univoca
  * la chiave e il valore sono di tipo parametrico
  * realizzazione con lista concatenata
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
   private ListNode head;    // attenzione: tail non serve
   private int size;         // variabile per contare le associazioni
   
   private class ListNode // classe interna
   {
      // variabili di esemplare
      private K key;             // chiave direttamente nel nodo
      private V value;           // valore direttamente nel nodo
      private ListNode next;
      
      // costruttore
      public ListNode(K k, V v, ListNode n)
      {
         setKey(k);
         setValue(v);
         setNext(n);
      }
      
      // costruttore
      public ListNode()
      {
         this(null, null, null);
      }
      
      // metodi di accesso
      public K getKey()         { return key;   }
      public V getValue()       { return value; }
      public ListNode getNext() { return next;  }
      
      // metodi modificatore
      public void setKey(K k)          { key = k;   }
      public void setValue (V v)       { value = v; } 
      public void setNext (ListNode n) { next = n;  }           
   }
   
   /**
      inizializza una mappa vuota
   */
   public M()
   {
      head = new ListNode();         
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
      return n.getNext().getValue();      
   }
   
   // ricerca lineare. Se l'associazione e' presente restituisce il riferimento
   // al nodo che precede il nodo contenente l'associazione di chiave
   // specificata, altrimenti restituisce l'ultimo nodo della lista concatenata
   private ListNode search(K k)
   {
      // attraversamento della lista concatenata
      ListNode n = head;
      while (n.getNext() != null)
      {
         if (n.getNext().getKey().compareTo(k) == 0)
            break;         // trovato
            
         n = n.getNext();  // accesso al nodo successivo  
      } 
      
      return n;                                 
   }
   
   /**
      verifica se questa mappa e' vuota
      @return true se questa mappa e' vuota, false altrimenti
   */
   public boolean isEmpty()
   {
      return head.getNext() == null;
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
      
      // copia delle chiavi della mappa
      int i = 0;
      ListNode n = head.getNext();
      while (n != null)
      {
         keys[i++] = n.getKey();
         
         n = n.getNext();
      }
      
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
      ListNode n = search(k);
      
      // associazione presente
      if (n.getNext() != null)
      {
         // memorizzazione del vecchio valore
         V old = n.getNext().getValue();

         // sostituzione del vecchio valore con il nuovo
         n.getNext().setValue(v);             
      
         // restituzione del vecchio valore
         return old;
      }      
      
      // associazione non presente
      
      // inserimento della nuova associazione
      ListNode tail = new ListNode(k, v, null);
      n.setNext(tail);
      
      // incremento del numero di associazioni
      size++;
      
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
      ListNode n = search(k);
      
      // associazione non presente      
      if (n.getNext() == null)
         return null;

      // associazione presente
      // memorizzazione del valore
      V ret = n.getNext().getValue();

      // cancellazione dell'associazione
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
      
      // generazione di un array per memorizzare i valori
      Object[] ret = new Object[keys.length];
            
      // copia dei valori delle associazioni
      ListNode n = head.getNext();
      int i = 0;
      while (n != null)
      {
         ret[i++] = n.getValue();
         
         n = n.getNext();
      }
                        
      return ret;      
   }            
}
