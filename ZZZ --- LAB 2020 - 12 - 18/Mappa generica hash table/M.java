import java.util.Map;

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
  public class M<K extends Comparable, V> implements Map
  {

    // --- INIZIO CLASSE PRIVATA ENTRY ---
    private class Entry <K extends Comparable, V> {
        private K key;
        private V value;

        public Entry (K k, V v) {
            setKey(k);
            setvalue(v);
        }

        public Entry () {
            this(null, null);
        }

        //metodi modificatori
        public void setKey (K k) {
            key = k;
        }
        public void setvalue (V v) {
            value = v;
        }

        //metodi di accesso
        public K getKey () {
            return key;
        }
        public V getValue () {
            return value;
        }
    }
    // --- FINE CLASSE PRIVATA ENTRY ---

    // --- INIZIO CLASSE PRIVATA LISTNODE ---
    private class ListNode {
        //variabili di esemplare
        private Entry e;
        private ListNode next;

        //costruttore
        public ListNode (Entry e, ListNode n) {
            setEntry(e);
            setNext(n);
        }
        public ListNode () {
            this(null, null);
        }

        //metodi modificatori
        public void setEntry (Entry e){
            this.e = e;
        }
        public void setNext (ListNode n){
            next = n;
        }

        //metodi di accesso
        public Entry getEntry () {
            return e;
        }
        public ListNode getNext () {
            return next;
        }
    }
    // --- FINE CLASSE PRIVATA LISTNODE ---

    //variabili di esemplare
    private final static int CAPACITY = 97; //meglio primo
    private Object [] v;    //array di oggetti
    private int vSize;

    //Costruttore
    public M () {
        makeEmpty();
    }

    public void makeEmpty () {
        v = new Object [CAPACITY];
        for (int i = 0; i < CAPACITY; i++){
            v[i] = new ListNode();
        }
        vSize = 0;
    }


     /**
        restituisce il valore associato alla chiave specificata
        @param key la chiave specificata
        @return valore associato alla chiave specificata key o null se la chiave
                specificata non e' presente nella mappa
     */ 
     public V get(K key){
        int hash = hash(key);

     }
     
     /**
        verifica se questa mappa e' vuota
        @return true se questa mappa e' vuota, false altrimenti
     */
     public boolean isEmpty(){
        return vSize <= 0;
     }

     /**
      * @param key chiave
      * @return hashcode tra 0 e 96
      */
     private int hash (K key) {
         if (key == null) {
             throw new IllegalArgumentException();
         }
        int ret = (key.hashCode()) % CAPACITY;
        if (ret < 0) {
            return -ret;
        }
        return ret;

     }
     
     /**
        accede alle chiavi di questa mappa
        @return se questa mappa non e' vuota restituisce un array ordinato
                contenente le chiavi delle associazioni presenti o altrimenti un
                array di dimensione nulla.
     */
     public Comparable[] keySet(){

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

     }
     
     /**
        fornisce il numero di associazioni presenti in questa mappa
        @return il numero di associazioni contenute in questa mappa
     */
    public int size() {
        return vSize;
    }
     
     /**
        accede ai valori di questa mappa
        @return array contenente i valori della associazioni presenti in questa
                mappa o un array di dimensione nulla se la mappa e' vuota
     */ 
    public Object[] values() {

    }         
  }
  