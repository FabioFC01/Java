 /**
  * interfaccia Map
  * definisce il tipo di dati astratto Mappa
  *
  * @see Container
  *
  * @author A. Luchetta
  * @version 8-1-2018
  */
  public interface Map <K, V> extends Container  //--ADT map
  {
     /**
        restituisce il valore associato alla chiave specificata
        @param key la chiave specificata
        @return il valore associato alla chiave specificata, se presente,
                null se l'associazione non e' presente
        @throws IllegalArgumentException se key vale null
     */
     V get(K key);
  
     /**
        inserisce l'associazione key/value nella mappa. Se la chiave e' gia'
        presente, sostituisce l'associazione e restituisce il valore
        precedentemente associato alla chiave
        @param key la chiave specificata
        @param value il valore specificato
        @return il valore precedentemente associato alla chiave specificata, se
                presente, null se la chiave non e' gia' presente
        @throws IllegalArgumentException se key o value valgono null
     */
     V put(K key, V value);
  
     /**
        elimina l'associazione di chiave specificata
        @param key la chiave specificata
        @return il valore associato alla chiave specificata, se
                presente, null se la chiave non e' presente
        @throws IllegalArgumentException se key vale null
     */
     V remove(K key);
  
     /**
        restituisce un array contenente le chiavi della mappa.
        @return array contenente tutte le chiavi della mappa
     */
     Object[] keys();
  }
  