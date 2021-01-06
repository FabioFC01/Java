//versione con array dinamico
public class D <K extends Comparable, V> implements Dictionary <K , V> {
   //INIZIO CLASSE PRIVATA ENTRY
   private class Entry {
      //variabili di esemplare
      private K key;
      private V value;

      //costruttori
      public Entry (K k, V v){
         setKey(k);
         setValue(v);
      }
      public Entry () {
         this(null, null);
      }

      //metodi modificatori
      public void setKey (K k){
         key = k;
      }
      public void setValue (V v){
         value = v;
      }

      //metodi di accesso
      public K getKey () { return key;}
      public V getValue () { return value;}
   }
   //FINE CLASSE PRIVATA ENTRY

   //variabili di esemplare
   private Object [] v;
   private int size;
   private static final int INITIAL_CAPACITY = 1;

   //costruttore
   public D () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      v = new Object [INITIAL_CAPACITY];
      for (int i = 0; i < INITIAL_CAPACITY; i++){
         v[i] = new Entry();
      }

      size = 0;
   }

   /**
       * Verifica se questo contenitore e' vuoto
       * @return true se questo contenitore e' vuoto, false altrimenti
       */
   public boolean isEmpty() {
      return size <= 0;
   }

   /**
       * Fornisce il numero di elementi presenti in questo contenitore
       * @return il numero di elementi presenti in questo contenitore
       */
   public int size() {
      return size;
   }

   /**
	Inserisce nel dizionario un'associazione avente
	chiave uguale a key e valore uguale a value
	@param key la chiave specificata
	@param value il valore specificato
	@throws IllegalArgumentException se key o value
	valgono null
	*/
	public void insert(K key, V value) {
      if (size >= v.length) { //ridimensionamento dinamico
         Object [] newV = new Object [2 * v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
      }

      v[size++] = new Entry(key, value);
   }
	/**
	Elimina dal dizionario un'associazione,
	di chiave specificata restituendone
	il valore associato oppure null se e non è
	presente nel dizionario
	@param key chiave specificara
	*/
	public V remove(K key) {
      for (int i = 0; i < size; i++) {
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            V ritorno = ((Entry)v[i]).getValue();

            int j;
            for (j = i; j < size -1; j++){
               v[j] = v[j+1];
            }
            v[j+1] = null;
            size--;

            return ritorno;
         }
      }
      return null;
   }
	/**
	Se il dizionario contiene un'associazione avente
	chiave uguale a key, allora ne restituisce il
	valore, altrimenti restituisce null
	@param key la chiave specificata
	@return valore associato alla chiave
	specificata, se presente, o null se non
	presente
	*/
	public V find(K key) {
      for (int i = 0; i < size; i++) {
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            V ritorno = ((Entry)v[i]).getValue();

            return ritorno;
         }
      }
      return null;
   }


   //metodo privato search
   public int search (K key){
      int trovati = 0;
      for (int i = 0; i < size; i++) {
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            trovati++;
         }
      }
      return trovati;
   }


	/**
	Se il dizionario contiene una a piu’ associazioni
	avente chiave uguale a key, allora ne restituisce i
	valori, altrimenti restituisce un array vuoto
	@param key la chiave specificata
	@return valori associati alla chiave
	specificata, se presente, o un array vuoto se
	non presente
   */
	public Object[] findAll(K key) {
      Object [] rit = new Object [search(key)];
      int indice = 0;
      for (int i = 0; i < size; i++) {
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            rit [indice++] = ((Entry)v[i]).getValue();
         }
      }

      return rit;
   }
	/**
	@return array contenente le chiavi del dizionario
	eventualmente ripetute. Restituisce un array
	vuoto (di zero elementi) se il dizionario e’
	vuoto
	*/
	public Object[] keys() {
      Object [] chiavi = new Object [size];

      for (int i = 0; i < size; i++) {
         chiavi[i] = ((Entry)v[i]).getKey();
      }

      return chiavi;
   }
	/**
	Se ci sono associazioni di chiave pari a key ne
	restituisce i valori, altrimenti restituisce un array
	vuoto
	@param key la chiave specificata
	@return valori associati alla chiave specificata, se
	presente, o un array vuoto altrimenti
	*/
	public Object[] removeAll(K key) {
      Object [] rit = findAll(key);

      for (int i = 0; i < size; i++) {
         if (((Entry)v[i]).getKey().compareTo(key) == 0){
            V ritorno = ((Entry)v[i]).getValue();

            int j;
            for (j = i; j < size -1; j++){
               v[j] = v[j+1];
            }
            v[j+1] = null;
            size--;
            
         }
      }
      return rit;
   }
	//...
}