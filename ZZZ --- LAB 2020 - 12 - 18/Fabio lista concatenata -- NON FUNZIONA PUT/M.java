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

  // SOLUZIONE LISTA CONCATENATA

  public class M <K extends Comparable, V> implements Map<K , V>
  {
    //CLASSE INTERNA LISTNODE
    private class ListNode {
        //variabili di esemplare
        private V value;
        private K key;
        private ListNode next;

        //costruttore
        public ListNode () {
            this (null, null, null);
        }
        public ListNode (V v, K k, ListNode n){
            setKey(k);
            setNext(n);
            setValue(v);
        }

        //metodi modificatori
        public void setValue (V v) { value = v;}
        public void setKey (K k) { key = k;}
        public void setNext (ListNode n) { next = n;}

        //metodi di accesso
        public V getValue () { return value;}
        public K getKey () { return key;}
        public ListNode getNext () { return next;}
    }
    //FINE CLASSE LISTNODE

    // ---------

    //variabili di esemplare classe M
    private ListNode head;
    private int size;

    //costruttore
    public M () {
        makeEmpty();
    }

    //makeEmpty
    public void makeEmpty () {
        head = new ListNode();
        size = 0;
    }

    //restituisce il nodo prima di quello che vuoi
    //se il nodo è tail allora non ha trovato
    private ListNode search (K key) {
        if (key == null){
            throw new IllegalArgumentException();
        }

        ListNode n = head;

        while (n.getNext() != null) { //finchè n non è tail
            if (n.getNext().getKey().compareTo(key) == 0){
                return n;
            }
        }

        return n;
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
        if (n.getNext() == null){
            return null;
        }
        return n.getNext().getValue();
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
        if (isEmpty()){
            return null;
        }
        Comparable [] chiavi = new Comparable [size];
        int i = 0;
        ListNode n = head.getNext();

        while(n != null){
            chiavi[i++] = n.getKey();
            n = n.getNext();
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
        ListNode n = search (key);
        if (n.getNext() == null){ //se è tail
            ListNode tail = new ListNode(value, key, null); //nuovo nodo tail
            n.setNext(tail);
            size++;
            return null;
        }
        //se c'è un nodo con quella chiave
        V ritorno = n.getNext().getValue();
        n.getNext().setValue(value);

        return ritorno;
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
        if (k == null){
            throw new IllegalArgumentException();
        }
        ListNode n = search (k);

        if (n.getNext() == null){ //se il nodo è tail
            return null;
        }

        V ritorno = n.getNext().getValue();
        n.setNext(n.getNext().getNext()); //si salta un nodo
        size--;

        return ritorno;
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

        ListNode n = head.getNext();
        int i = 0;

        while(n != null){
            valori[i++] = n.getValue();
            n = n.getNext();
        }

        return valori;
    }


     //MERGESORT
     private void sort (Comparable [] a) { //mergesort
        if (a.length < 2) {
            return;
        }

        int mid = a.length /2;

        Comparable [] l = new Comparable [mid];
        Comparable [] r = new Comparable [a.length - mid];

        System.arraycopy(a, 0, l, 0, mid);
        System.arraycopy(a, mid, r, 0, a.length - mid);

        sort (l);
        sort (r);

        merge(a , l , r);
     }

     private void merge (Comparable [] a, Comparable [] l, Comparable [] r){
         int ia = 0;
         int il = 0;
         int ir = 0;

         while (il < l.length && ir < r.length){
             if (l[il].compareTo(r[ir]) > 0){
                a[ia++] = r[ir++];
             }
             else{
                 a[ia++] = l[il++];
             }
         }

         //uno dei due è finito almeno
         while (il < l.length) {
             a[ia++] = l[il++];
         }
         while (ir < r.length) {
            a[ia++] = r[ir++];
        }
     }
}