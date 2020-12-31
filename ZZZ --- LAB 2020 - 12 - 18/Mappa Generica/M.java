public class M <K extends Comparable, V > implements Map <K, V> {
    //parte privata
    private static final int INITIAL_SIZE = 1; //prova 1 dopo
    private Object [] v;
    private int vSize;

    //classe interna
    private class Entry {
        private K key;
        private V value;

        public Entry (K k, V v) {
            key = k;
            value = v;
        }
        public Entry () {
            this (null, null);
        }

        public K getKey () {
            return key;
        }

        public V getValue () {
            return value;
        }

        public void setKey (K k){
            key = k;
        }

        public void setValue (V v){
            value = v;
        }
    }
    //--- FINE CLASSE ENTRY ---


    public M () {
        makeEmpty ();
    }

    public void makeEmpty () {
        v = new Object [INITIAL_SIZE];
        vSize = 0;
    }

    public boolean isEmpty () {
        return vSize <= 0;
    }

    public int size () {
        return vSize;
    }

    /***
     * 
     * @param k chiave
     * @return indice dove c'è la chiave, oppure -1
     */
    private int search (K k) {
        if (k == null){ throw new IllegalArgumentException(); }

        for (int i = 0; i < vSize; i++) {
            if ((((Entry)v[i]).getKey()).equals(k)){
                return i;
            }
        }
        return -1;
    }

    /**
        restituisce il valore associato alla chiave specificata
        @param key la chiave specificata
        @return valore associato alla chiave specificata key o null se la chiave
                specificata non e' presente nella mappa
     */ 
    public V get(K key) {
        int n = search(key);
        
        if (n < 0) {
            return null;
        }
        Entry ritorno = (Entry)v[n];

        return ritorno.getValue();
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
    public V put(K key, V value) throws IllegalArgumentException {
        if (key == null || value == null){
            throw new IllegalArgumentException();
        }
        int n = search(key);    //mi da valore associato alla chiave
        
        if (n == -1){    //se non c'era quella chiave prima
            if (vSize >= v.length){ //ridimensionamento dinamico
                Object [] newV = new Object [2 * v.length];
                System.arraycopy(v, 0, newV, 0, vSize);
                v = newV;
            }
            v[vSize++] = new Entry(key, value);
            return null;
        }
        else{       //è stato trovato un valore con quella chiave
            Entry e = (Entry)v[n];
            V old = ((Entry)v[n]).getValue(); //forzamento necessario

            //sostituzione
            v[n] = new Entry (key , value);

            //ritorno
            return old;

        }
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
        if (k == null) { throw new IllegalArgumentException();}

        int n = search(k);
        if (n == -1){       //associazione non presente
            return null;
        }
        V old = ((Entry)v[n]).getValue();
        
        v[n] = v[vSize-1];

        v[vSize - 1] = null;

        vSize--;
        return old;
    }


    private void sort (Comparable [] v) {
        if (v.length < 2){
            return;
        }

        int mid = v.length /2;
        Comparable [] l = new Comparable [mid];
        Comparable [] r = new Comparable [v.length - mid];

        System.arraycopy(v, 0, l, 0, mid);
        System.arraycopy(v, mid, r, 0, v.length - mid);

        sort (l);
        sort (r);

        merge (v , l , r);
    }

    private void merge (Comparable v [], Comparable l [], Comparable r []) {
        int iv = 0;
        int il = 0;
        int ir = 0;

        while (il < l.length && ir < r.length){
            if (l[il].compareTo(r[ir]) < 0) {
                v[iv++] = l[il++];
            }
            else {
                v[iv++] = r[ir++];
            }
        }
        while (il < l.length) {
            v[iv++] = l[il++];
        }
        while (ir < r.length) {
            v[iv++] = r[ir++];
        }
    }


    /**
        accede alle chiavi di questa mappa
        @return se questa mappa non e' vuota restituisce un array ordinato
                contenente le chiavi delle associazioni presenti o altrimenti un
                array di dimensione nulla.
     */
    public Comparable[] keySet() {
        Comparable [] w = new Comparable [vSize];

        for (int i = 0; i < vSize; i++) {
            w[i] = ((Entry)v[i]).getKey(); //riempiamo array di chiavi
        }

        sort(w);
        return w;
    }
    
    /**
        accede ai valori di questa mappa
        @return array contenente i valori della associazioni presenti in questa
                mappa o un array di dimensione nulla se la mappa e' vuota
     */ 
    public Object[] values() {
        if (isEmpty()){
            return null;
        }
        Object [] ritorno = new Object [vSize];
        for (int i = 0; i < vSize; i++){
            ritorno[i] = ((Entry)v[i]).getValue();
        }

        return ritorno;
    }


}
