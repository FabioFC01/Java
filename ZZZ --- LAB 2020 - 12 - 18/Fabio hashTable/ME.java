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
        Object [] valori = valueSet(); //valori ordinati
        return searchBinary(valori, 0, valori.length-1, value) >= 0;
    }

 /**
 accesso ai valori unici della mappa
 @return array contenente i valori della associazioni presenti nella mappa
 ordinati secondo il loro ordine naturale e senza duplicati.
 */ 
    public Comparable[] valueSet() {
        Object [] v = super.values();
        
        M m = new M();

        for (Object e : v){
            m.put((Comparable)e, "");       //inserimento valori come chiavi
        }

        Comparable [] sortedValues = m.keySet();

        return sortedValues;

    }

 /**
 inserisce l'associazione (k, v) nella mappa
 */ public V put(K k, V v) { return super.put(k, v); }

 //ricerca binaria
 private static int searchBinary (Object [] a, int from, int to, Object ref) {
    if (to < from) { return -1;}

    int mid = (from + to) /2;
    Comparable c = (Comparable) a[mid];

    if (c.compareTo(ref) == 0) {
        return mid;
    }

    if (c.compareTo(ref) > 0){  //c è più grande
        return searchBinary(a, from, mid, ref);
    } 
    else{
        return searchBinary(a, mid + 1, to, ref);
    }
 }
}