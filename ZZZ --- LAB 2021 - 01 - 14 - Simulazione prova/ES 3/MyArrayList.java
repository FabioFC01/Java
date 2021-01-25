/**
  * FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 25.8.2020
  *
  * MyArrayList
  *
  * Realizza un vettore.
  * Programmazione generica.
  * Usa come struttura dati un array riempito parzialmente che viene
  * dinamicamente ridimensionato in caso di necessita'.
  *
  * @version 9-Dec-2013
  * @author Adriano Luchetta
  * @param <E> il tipo di esemplari gestiti dalla classe
  * @see Container
  *
  */  
public class MyArrayList<E extends Comparable<E>>
{
   // costanti della classe
   private static final int INITIAL_CAPACITY = 1;

   // variabili di esemplare
   private Comparable[] v; // array di Comparable
   private int vSize;
   
   /**
      Costruisce un vettore vuoto con un array interno di dimensione predefinita
   */
   public MyArrayList()
   {
      makeEmpty();
   }
   /**
      Restituisce true se questo vettore e' vuoto, false altrimenti
      @return true se e solo se questo vettore non contiene elementi, false altrimenti
   */
   public final boolean isEmpty()
   {
      return vSize <= 0;
   }
   
   /**
      crea un vettore vuoto.
   */
   public final void makeEmpty()
   {
      v = new Comparable[INITIAL_CAPACITY];
      vSize = 0;
   }
   
   /**
      Restituisce il numero di elementi di questo vettore.
      @return il numero di componenti in questo vettore.
   */
   public final int size()
   {
      return vSize;
   }   
   
   /**
       Se l'elemento specificato non vale null, aggiunge l'elemento specificato
       in coda a questo vettore, altrimenti ritorna senza fare niente.
       @param e l'elemento da aggiungere a questo vettore
   */
   public final void add(E e)
   {
      add(vSize, e); //esempio di riuso del codice del metodo add(int index, E e)
   }
   
   /**
       Se 0 <= index <= size(), inserisce l'elemento specificato nella posizione
       specificata in questo vettore.
       Sposta a destra l'elemento attualmente in quella posizione (se alcuno) e
       ogni elemento successivo (aggiunge uno al loro indice).
       Se index < 0 o index > size() ritorna senza fare niente. Ritorna senza
       fare niente anche se e vale null.
       @param index indice al quale l'elemento specificato deve essere inserito
       @param e l'elemento da aggiungere a questo vettore
   */
   public final void add(int index, E e)
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
   public final int capacity()
   {
      return v.length;  // dimensione dell'array
   }

   /**
      Restituisce true se questo vettore contiene l'elemento specificato.
      @param e elemento la cui presenza in questo vettore e' da verificare
      @return true se l'elemento specificato e' contenuto in questo vettore,
              false altrimenti
   */
   public final boolean contains(E e)
   {
      // ricerca in un array riempito solo in parte
      for (int i = 0; i < vSize; i++)  // usare vSize e non v.length!
         if (v[i].compareTo(e) == 0)           // usare il metodo compareTo e non l'operatore ==
            return true;               // elemento trovato
            
      return false;  // elemento non trovato
   }
   
   /**
      Se 0<= index < size(), restituisce l'elemento all'indice specificato,
      altrimenti restituisce null.
      @param index un indice in questo vettore
      @return l'elemento all'indice specificato;
   */
   public final E elementAt(int index)
   {
      // pre-condizioni
      if (index < 0 || index >=vSize)
         return null;

      return (E)v[index];
   }
   
   /**
      restituisce l'indice della prima occorrenza dell'elemento specificato in
      questo vettore, o -1 se questo vettore non contiene l'elemento
      @param e elemento da ricercare
      @return indice della prima occorrenza dell'elemento specificato oppure
              -1 se l'elemento non e' presente in questo vettore
   */
   public final int indexOf(E e)
   {
      for (int i = 0; i < vSize; i++)  // usare vSize e non v.length!
         if (v[i].compareTo(e) == 0)           // usare il metodo compareTo e non l'operatore ==          
            return i;

      return -1;
   }
   
   /**
      restituisce il minimo del vettore, se il vettore non e' vuoto, null altrimenti
      */
   public E min()
   {
      if (isEmpty())
         return null;
         
      int minIdx = 0;
      for (int i = 1; i < vSize; i++)
         if (elementAt(i).compareTo(elementAt(minIdx)) < 0)
            minIdx = i;
            
      return elementAt(minIdx);         
   }
   
   /**
      Se 0 <= index < size(), rimuove l'elemento all'indice specificato,
      restituendolo. Sposta a sinistra ogni elemento successivo (sottrae uno al
      loro indice).
      Se index < 0 o index >=size() restituisce null.
      @param index indice da rimuovere
      @return l'elemento rimosso all'indice specificato oppure null se l'indice
      non e' valido
   */
   public final E remove(int index)
   {       
      // memorizzazione temporanea dell'elemento da eliminare
      // verifica delle pre-condizioni demandata al metodo elementAt
      E tmp = elementAt(index);
      
      // indice non valido
      if (tmp == null)
         return null;
      
      // spostamento elementi
      for (int i = index; i < vSize - 1; i++)
         v[i] = v[i + 1];
         
      // garbage Collector
      v[vSize - 1] = null;
      
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
   public final E set(int index, E e)
   {
      // memorizzazione temporanea dell'elemento da sovrascrivere
	  // verifica delle pre-condizioni demandata al metodo elementAt
      E tmp = elementAt(index);
      
      // indice non valido 
      if (tmp == null)
         return null;
         
      v[index] = e;

      return tmp;
   }
  
   /**
      Restituisce un array contenente tutti gli elementi in questo vettore 
       nell'ordine corretto.
      @return un array contenente tutti gli elementi di questo vettore.
   */
   public final Comparable[] toArray()
   {
      Comparable[] tmp = new Comparable[vSize];
      for (int i = 0; i < vSize; i++)
         tmp[i] = v[i];
         
      return tmp;
   }
   
   /**
      Restituisce una stringa contenente gli elementi di questo array in ordine,
       un elemento per riga.
      @return una Comparablea contenente gli elementi di questo array in ordine,
              un elemento per riga.
   */
   public final String toString()
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
      Comparable[] tmp = new Comparable[2 * v.length];
      for (int i = 0; i < v.length; i++)
         tmp[i] = v[i];
         
      v = tmp;
   }
}
