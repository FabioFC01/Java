public class ME<K extends Comparable, V extends Comparable> extends M<K, V>
{
 /**
 Verifica se una associazione di chiave specificata e' presente in questa
 mappa estesa
 @param key la chiave specificata
 @return true se l'associazione di chiave specificata e' presente in
 questa mappa, false altrimenti.
 */ 
    public boolean containsKey(K key) {
        return super.get(key) != null;
    }

 /**
 Verifica se una associazione di valore specificato e' presente in questa
 mappa estesa
 @param value il valore specificato
 @return true se il valore specificato e' presente nella mappa, false
 altrimenti.
 */ 
    public boolean containsValue(V value) {
        Object [] valori = super.values();

        return search(valori, 0, valori.length, value) >= 0;
    }

    //ricerca binaria
    private static int search (Object[]a , int from, int to, Object rif) {
        if (to < from) {
            return -1;
        }

        int mid = (from + to) / 2;

        Comparable c = (Comparable)a[mid];

        if (c.compareTo(rif) == 0){
            return mid;
        }
        if (c.compareTo(rif) > 0) { //mid è maggiore
            return search(a, mid + 1, to, rif);        
        }
        else{   //mid è minore
            return search(a, from, mid - 1, rif);
        }
    }

 /**
 accesso ai valori unici della mappa
 @return array contenente i valori della associazioni presenti nella mappa
 ordinati secondo il loro ordine naturale e senza duplicati.
 */ 
    public Comparable[] valueSet() {
        Object [] valori = super.values();

        M m = new M();

        for (int i = 0; i < valori.length; i++){
            m.put((Comparable)valori[i], "");
        }

        Comparable [] ritorno = m.keySet();

        return ritorno;
    }

 /**
 inserisce l'associazione (k, v) nella mappa
 */ 
    public V put(K k, V v) { return super.put(k, v); }
}