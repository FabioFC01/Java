/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 22.2.2017
  *
  * interfaccia Map - ADT mappa - contenitore di associazioni chiave/valore con
  * chiave univoca
  * la chiave e il valore sono di tipo parametrico
  *
  * typeparam K il tipo parametrico della chiave
  * typeparam V il tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */

  // SOLUZIONE FABIO CON HASHTABLE

  public class M<K extends Comparable, V> implements Map <K, V>
  {
      //INIZIO CLASSE PRIVATA LISTNODE
      private class ListNode {
          //variabili d'esemplare
          private K key;
          private V value;
          private ListNode next;

          //costruttori
          ListNode () {
              this(null,null,null);
          }
          ListNode (K k, V v, ListNode n){
            setKey(k);
            setNext(n);
            setValue(v);
          }

          //metodi modificatori
          public void setKey (K k){ key = k; }
          public void setValue (V v) { value = v;}
          public void setNext (ListNode n) { next = n;}

          //metodi di accesso
          public K  getKey () { return key;}
          public V getValue () { return value;}
          public ListNode getNext () { return next;}

      }

      //FINE CLASSE PRIVATA LISTNODE

      //Variabili di esemplare
      private Object [] v;
      private int size;
      private static final int CAPACITY = 97; //num. primo

      //Costruttore
      M () {
        makeEmpty();
      }

      //makeEmpty
      public void makeEmpty () {
          v = new Object [CAPACITY];
          size = 0; 
          for (int i = 0; i < CAPACITY; i++){
              v[i] = new ListNode();
          }
      }

      //hashCode
    private int hash (K key) {
        int rit = key.hashCode() % CAPACITY; 
        if (rit < 0) { return -rit;}

        return rit;
    }

      //search
      //ti ridà il nodo prima
    private ListNode search (K key) {
        int i = hash(key);
        //si cerca in v[i]

        ListNode n = (ListNode)v[i];

        while(n.getNext() != null) {
            if (n.getNext().getKey().compareTo(key) == 0){
                return n;
            }
            n = n.getNext();
        }
        return n; //in questo caso tail di v[i]

    }

     /**
        restituisce il valore associato alla chiave specificata
        @param key la chiave specificata
        @return valore associato alla chiave specificata key o null se la chiave
                specificata non e' presente nella mappa
     */ 
    public V get(K key) {
        if (key == null){
            throw new IllegalArgumentException();
        }

        ListNode n = search(key);

        if (n.getNext() == null) { //se è tail
            return null;
        }

        V valore = n.getNext().getValue();
        return valore;
    } 
     
     /**
        verifica se questa mappa e' vuota
        @return true se questa mappa e' vuota, false altrimenti
     */
    public boolean isEmpty() {
        return size <= 0;
    }
     
     /**
        accede alle chiavi di questa mappa
        @return se questa mappa non e' vuota restituisce un array ordinato
                contenente le chiavi delle associazioni presenti o altrimenti un
                array di dimensione nulla.
     */
    public Comparable[] keySet() {
        Comparable [] chiavi = new Comparable [size];
        int j = 0;

        for (int i = 0; i < CAPACITY; i++) {
            ListNode n = (ListNode) v[i];

            while (n.getNext() != null) {
                chiavi[j++] = (Comparable) n.getNext().getKey();
                
                n = n.getNext();
            }
        }

        sort (chiavi);

        return chiavi;
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
    public V put(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException();
        }

        ListNode n = search(key);

        if (n.getNext() == null) { //se è tail
            n.setNext(new ListNode (key, value, null));
            size++;
            return null;
        }

        //c'è una corrispondenza
        V valore = n.getNext().getValue();
        n.getNext().setValue(value);
        
        return valore;
    }
     
     /**
        elimina da questa mappa l'associazione di chiave specificata e ne
        restituisce il valore   
        @param key la chiave specificata
        @return null se in questa mappa non e' presente un'associazione di chiave
                specificata o, altrimenti, il valore associato alla chiave
                specificata
     */
    public V remove(K k) {
        ListNode n = search(k);

        if (n.getNext() == null) {
            return null;
        }
        else{
            V valore = n.getNext().getValue();
            n.setNext(n.getNext().getNext());
            size--;

            return valore;
        }
    }
     
     /**
        fornisce il numero di associazioni presenti in questa mappa
        @return il numero di associazioni contenute in questa mappa
     */
    public int size() {
        return size;
    }
     
     /**
        accede ai valori di questa mappa
        @return array contenente i valori della associazioni presenti in questa
                mappa o un array di dimensione nulla se la mappa e' vuota
     */ 
    public Object[] values() {
        Object [] valori = new Object [size];
        int j = 0;

        for (int i = 0; i < CAPACITY; i++) {
            ListNode n = (ListNode) v[i];

            while (n.getNext() != null) {
                valori[j++] = n.getNext().getValue();
                
                n = n.getNext();
            }
        }

        return valori;
    }    
     
     
     //metodo privato sort
     private static void sort (Comparable [] a){
         if (a.length < 2) { return;}

         int mid = a.length / 2;

         Comparable [] l = new Comparable [mid];
         Comparable [] r = new Comparable [a.length - mid];

         System.arraycopy(a, 0, l, 0, mid);
         System.arraycopy(a, mid, r, 0, r.length);

         sort (l);
         sort (r);

         merge (a, l ,r);
     }

     private static void merge (Comparable [] a, Comparable [] l, Comparable [] r){
         int ia = 0;
         int il = 0;
         int ir = 0;

         while(il < l.length && ir < r.length){
             if (l[il].compareTo(r[ir]) > 0) {
                 a[ia++] = r[ir++];
             }
             else {
                a[ia++] = l[il++];
             }
         }

         while (il < l.length) {
            a[ia++] = l[il++];
         }
         while (ir < r.length) {
            a[ia++] = r[ir++];
         }
     }
  }
  