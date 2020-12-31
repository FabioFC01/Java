public class M <K, V> implements Map <K, V> {
    //parte privata
    private static final int INITIAL_CAPACITY = 97; //numero primo per uniformità hash
    private Object [] w;    //array di object
    private int size;

    //classe Interna
    private class Entry {
        //variabili di esemplare
        private K key;
        private V value;

        //costruttore con parametri
        public Entry (K k, V v){
            setKey(k);
            setValue(v);
        }

        //metodi di accesso
        public K getKey () {
            return key;
        }
        public V getValue () {
            return value;
        }

        //metodi modificatori
        public void setKey (K k) {
            key = k;
        }
        public void setValue (V v){
            value = v;
        }
    }
    //---FINE CLASSE ENTRY ---

    //classe interna
    private class ListNode {
        private Entry element;  //elemento di questo nodo
        private ListNode next;  //riferimento al nodo successivo

        //costruttore
        public ListNode (Entry e, ListNode n){
            setElement(e);
            setNext(n);
        }

        //costruttore senza parametri
        public ListNode () {
            this(null, null);
        }

        //metodi di accesso
        public Entry getElement () {
            return element;
        }
        public ListNode getNext () {
            return next;
        }

        //metodi modificatori
        public void setElement (Entry e){
            element = e;
        }
        public void setNext (ListNode n){
            next = n;
        }

    }
    //--- FINE CLASSE LISTNODE ---

    //------------------------------------------------------

    //Inizializza mappa vuota
    public M () {
        makeEmpty();
    }

    /***
     * creazione e inizializzazione mappa vuota
     * con array di ListNode con lunghezza INTIIAL_CAPACITY
     */
    public void makeEmpty () {
        w = new Object [INITIAL_CAPACITY];  //array di object
        for (int i = 0; i < w.length; i++){
            w[i] = new ListNode();          //inizializzazione liste concatenate
        }
        size = 0;
    }

    /***
     * 
     * @param k chiave
     * @return value v se c'è associazione con la chiave,
     *          null altrimenti
     */
    public V get (K k) {
        //ricerca
        ListNode n = search(k);

        //gestione associazione chiave non trovata
        //ovvero se ListNode n è tail
        if (n.getNext() == null){
            return null;
        }

        //gestione nel caso in cui ci sia associazione
        return n.getNext().getElement().getValue();
    }

    //ti da il nodo prima di quello con k
    //nel caso non ci sia ti da il nodo tail
    //quindi con n.getnext() == null
    private ListNode search (K k){
        //calcolo chiave ridotta
        int i = h(k);

        //nodo di appoggio per ricerca
        //w.length = INITIAL_CAPACITY = 97
        ListNode n = (ListNode) w[i];    //forzamento necessario

        //scansione del bucket
        while (n.getNext() != null){
            if (n.getNext().getElement().getKey().equals(k)){
                break;  //esci perchè hai trovato ListNode con chiave k
            }
            n = n.getNext();    //passa al nodo successivo
        }

        return n;
    }

    //calcolo chiave ridotta
    private int h (K k){
        int i = k.hashCode()% w.length; 

        if (i < 0){
            return -i;
        }
        
        return i;
    }

    /***
     * @return true se mappa è vuota, false altrimenti
     */
    public boolean isEmpty () {
        return size <= 0;
    }

    /***
     * @return array con tutte le chiavi
     * 
     * da precisare che questo metodo l'ho creato io
     * non so se funziona o se sia il migliore
     */
    public Object [] keys () {
        Object [] ritorno = new Object [size];
        int contatore = 0;
        for (int i = 0 ; i < w.length; i++){    //scorri array w
            ListNode n = (ListNode) w[i];

            while(n.getNext() != null){ //finchè non arrivi a tail
                /*
                if (((Entry)n.getElement()!= null) &&  ((K)n.getElement().getKey() != null)){
                    ritorno [contatore++] = (K) n.getElement().getKey();
                }
                n = n.getNext();*/
                //devi prendere il valore successivo
                ritorno[contatore++] = n.getNext().getElement().getKey();
                n = n.getNext();
            }
        }

        return ritorno;

    }

    /***
     * 
     * @param k  chiave
     * @param v   valore da inserire
     * @return il valore prima legato a quella chiave 
     *          o null in caso opposto
     */
    public V put (K k, V v){
        ListNode n = search(k); //cerca nella mappa

        //gestione nel caso non ci sia associazione
        if(n.getNext() == null) {   //cioè se n è tail
            n.setNext(new ListNode( new Entry(k, v) , null ) );
            size++;
            return null; //perchè non c'era associazione
        }

        //gestione se c'è associazione
        V precedente = n.getNext().getElement().getValue();
        //inserisci valore v
        n.getNext().getElement().setValue(v);

        return precedente;
    }

    /***
     * 
     * @param k   chiave, bisogna cercarne l'associazione
     * @return il valore prima associato alla chiave k,
     *          null se non c'erano associazioni con quella chiave
     */
    public V remove (K k){
        ListNode n = search(k);

        //gestione nel caso in cui non ci sia associazione
        //con chiave k, ovvero se n è tail
        if (n.getNext() == null){
            return null;
        }
        //gestione se c'è associazione con chiave
        //prendiamo il valore di n.next
        V ritorno = n.getNext().getElement().getValue();
        //colleghiamo n al nodo successivo del successivo
        n.setNext(n.getNext().getNext());
        //decremento size
        size--;

        return ritorno;
    }

    /***
     * 
     * @return size
     */
    public int size () {
        return size;
    }
}