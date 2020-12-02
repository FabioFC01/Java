 /**
  * MyVector
  *
  * Realizza un vettore.
  * Usa come struttura dati un array riempito parzialmente che viene
  * dinamicamente ridimensionato in caso di necessita'.
  *
  * @version 39-Dec-2013
  * @author Adriano Luchetta
  *
  */
  
  public class MyVector implements Container
  {
     // costanti della classe
     private final int INITIAL_CAPACITY = 1;
  
     // variabili di esemplare
     private Object[] v;
     private int vSize;
     
     /**
        Costruisce un vettore vuoto con un array interno di dimensione predefinita
     */
     public MyVector()
     {
        makeEmpty();
     }
     
     /**
        Restituisce true se questo vettore e' vuoto, false altrimenti
        @return true se e solo se questo vettore non contiene elementi, false altrimenti
     */
     public boolean isEmpty()
     {
        return vSize == 0;
     }
     
     /**
        crea un vettore vuoto.
     */
     public void makeEmpty()
     {
        v = new Object[INITIAL_CAPACITY];
        vSize = 0;
     }
     
     /**
        Restituisce il numero di elementi di questo vettore.
        @return il numero di componenti in questo vettore.
     */
     public int size()
     {
        return vSize;
     }   
     
     /**
         Se l'elemento specificato non vale null, aggiunge l'elemento specificato
         in coda a questo vettore, altrimenti ritorna senza fare niente.
         @param e l'elemento da aggiungere a questo vettore
     */
     public void add(Object e)
     {
        add(vSize, e); //esempio di riuso del codice del metodo add(int index, Object s)
     }
     
     /**
         Se 0 <= index <= size(), inserisce l'elemento specificato nella posizione
         specificata in questo vettore.
         Sposta a destra l'elemento attualmente in quella posizione (se alcuno) e
         ogni elemento successivo (aggiunge uno al loro indice).
         Se index < 0 o index > size() ritorna senza fare niente. Ritorna senza
         fare niente anche se s vale null.
         @param index indice al quale l'elemento specificato deve essere inserito
         @param e l'elemento da aggiungere a questo vettore
     */
     public void add(int index, Object e)
     {
        // pre-condizioni
        if (index < 0 || index > vSize || e == null)
           return;
  
        // ridimensionamento dinamico dell'array
        if (vSize >= v.length)
           resize();
           
        // spostamento di elementi per inserimento
        for (int i = vSize; i > index; i--)
           v[i] = v[i - 1];
           
        // inserimento del nuovo elemento nell'array all'indice specificato
        v[index] = e;      
        vSize++;
     }
     
     /**
        Restituisce la capacita' del vettore.
        @return la dimensione dell'array interno.
     */
     public int capacity()
     {
        return v.length;  // dimensione dell'array
     }
  
     /**
        Restituisce true se questo vettore contiene l'elemento specificato.
        @param e elemento la cui presenza in questo vettore e' da verificare
        @return true se l'elemento specificato e' contenuto in questo vettore,
                false altrimenti
     */
     public boolean contains(Object e)
     {
        // ricerca in un array riempito solo in parte
        for (int i = 0; i < vSize; i++)  // usare vSize e non v.length!
           if (v[i].equals(e))           // usare il metodo equals e non l'operatore ==
              return true;               // elemento trovato
              
        return false;  // elemento non trovato
     }
     
     /**
        Se 0<= index < size(), restituisce l'elemento all'indice specificato,
         altrimenti restituisce null.
        @param index un indice in questo vettore
        @return l'elemento all'indice specificato;
     */
     public Object elementAt(int index)
     {
        // pre-condizioni
        if (index < 0 || index >=vSize)
           return null;
  
        return v[index];
     }
     
     /**
        restituisce l'indice della prima occorrenza dell'elemento specificato in
         questo vettore, o -1 se questo vettore non contiene l'elemento.
        @param e elemento da ricercare
        @return indice della prima occorrenza dell'elemento specificato
     */
     public int indexOf(Object e)
     {
        for (int i = 0; i < vSize; i++)  // usare vSize e non v.length!
           if (v[i].equals(e))    // usare il metodo equals e non l'operatore ==          
              return i;
  
        return -1;
     }
     
     /**
        Se 0 <= index < size(), rimuove l'elemento all'indice specificato, restituendolo. Sposta a sinistra ogni elemento successivo (sottrae uno al loro indice).
        Se index < 0 o index >=size() restituisce null.
        @param index indice da rimuovere
        @return l'elemento rimosso all'indice specificato
     */
     public Object remove(int index)
     {
        // pre-condizioni
        if (index < 0 || index >= vSize)
           return null;
           
        // memorizzazione temporanea dell'elemento da eliminare
        Object tmp = v[index];
        
        // spostamento elementi
        for (int i = index; i < vSize - 1; i++)
           v[i] = v[i + 1];
           
        // decremento del numero di elementi
        vSize--;
           
        return tmp;
     }
  
     /**
        Se 0 <= index < size(), sostituisce l'elemento alla posizione specificata
         in questo vettore con l'elemento specificato.
        Se index < 0 o index >=size() restituisce null.
        @param index indice dell'elemento da sostituire
        @param e elemento da memorizzare alla posizione specificata
        @return l'elemento precedentemente memorizzato alla posizione specificata.
     */
     public Object set(int index, Object e)
     {
        // pre-condizioni
        if (index < 0 || index >= vSize)
           return null;
           
        Object tmp = v[index];
        v[index] = e;
  
        return tmp;
     }
    
     /**
        Restituisce un array contenente tutti gli elementi in questo vettore 
         nell'ordine corretto.
        @return un array contenente tutti gli elementi di questo vettore.
     */
     public Object[] toArray()
     {
        Object[] tmp = new Object[vSize];
        for (int i = 0; i < vSize; i++)
           tmp[i] = v[i];
           
        return tmp;
     }
     
     /**
        Restituisce una stringa contenente gli elementi di questo array in ordine,
         un elemento per riga.
        @return una Objecta contenente gli elementi di questo array in ordine,
                un elemento per riga.
     */
     public String toString()
     {
        String tmp = "";
        for (int i = 0; i < vSize; i++)
           tmp = tmp +  v[i] + "\n";
           
        return tmp;
     }
     
     /*
        ridimensionamento dinamico di questo vettore
        Metodo privato: non commentare in stile javadoc!
     */
     private void resize()
     {
        Object[] tmp = new Object[2 * v.length];
        for (int i = 0; i < v.length; i++)
           tmp[i] = v[i];
           
        v = tmp;
     }
  }
  