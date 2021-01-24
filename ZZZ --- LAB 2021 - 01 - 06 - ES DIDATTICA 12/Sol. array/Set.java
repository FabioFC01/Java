/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Definisce il tipo di dati astratto insieme
  *
  * @see Iterable
  * @typeparam E il tipo di elementi gestiti dall'insieme
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Set<E extends Comparable> extends Iterable<E>
{
   /**
      inserisce in questo insieme l'elemento specificato se e' diverso da null e
      non e' gia' presente 
      @param e l'elemento specificato
      @return false se questo insieme conteneva gia' l'elemento specificato
   */
   boolean add(E e);
     
   /**
      verifica se l'elemento specificato e' presente in questo insieme
      @param o l'elemento specificato
      @return true se questo insieme contiene l'elemento specificato o
              false altrimenti     
   */
   boolean contains(Object o);
     
   /**
      Verifica se questo insieme e' vuoto 
      @return true se questo insieme e' vuoto o false altrimenti    
   */
   boolean isEmpty();

   /**
      Fornisce il numero di elementi di questo insieme (dimensione)
      @return il numero di elementi presenti in questo insieme     
   */
   int size();
   
   /**
      copia nell'array specificato gli elementi di questo insieme ordinati
      in senso crescente secondo il loro ordine naturale
      @param a array specificato
      @return numero di elementi di questo insieme copiati nell'array specif.to
      @throws java.lang.ArrayIndexOutOfBoundsException se la dimensione
              dell'array specificato e' minore della dimensione dell'insieme
        
   */
   int toSortedArray(E[] a) throws ArrayIndexOutOfBoundsException;
}  
 
