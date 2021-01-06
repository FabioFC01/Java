
public interface Dictionary <K, V> extends Container {
	/**
	Inserisce nel dizionario un'associazione avente
	chiave uguale a key e valore uguale a value
	@param key la chiave specificata
	@param value il valore specificato
	@throws IllegalArgumentException se key o value
	valgono null
	*/
	void insert(K key, V value);
	/**
	Elimina dal dizionario un'associazione,
	di chiave specificata restituendone
	il valore associato oppure null se e non è
	presente nel dizionario
	@param key chiave specificara
	*/
	V remove(K key);
	/**
	Se il dizionario contiene un'associazione avente
	chiave uguale a key, allora ne restituisce il
	valore, altrimenti restituisce null
	@param key la chiave specificata
	@return valore associato alla chiave
	specificata, se presente, o null se non
	presente
	*/
	V find(K key);
	/**
	Se il dizionario contiene una a piu’ associazioni
	avente chiave uguale a key, allora ne restituisce i
	valori, altrimenti restituisce un array vuoto
	@param key la chiave specificata
	@return valori associati alla chiave
	specificata, se presente, o un array vuoto se
	non presente
	*/
	Object[] findAll(K key);
	/**
	@return array contenente le chiavi del dizionario
	eventualmente ripetute. Restituisce un array
	vuoto (di zero elementi) se il dizionario e’
	vuoto
	*/
	Object[] keys();
	/**
	Se ci sono associazioni di chiave pari a key ne
	restituisce i valori, altrimenti restituisce un array
	vuoto
	@param key la chiave specificata
	@return valori associati alla chiave specificata, se
	presente, o un array vuoto altrimenti
	*/
	Object[] removeAll(K key);
	//...
}