/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Definisce un iteratore
  *
  * @typeparam T il tipo di elementi restituiti da questo iteratore
  
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public interface Iterator<T> // Iteratore
{
   /**
      @return true se l'iterazione ha elementi successivi
   */
   boolean hasNext();

   /**
      @return il prossimo elemento nell'iterazione
      @throws java.util.NoSuchElementException se l'iterazione non ha successivi
              elementi
   */   
   T next() throws java.util.NoSuchElementException;
   
   /**
      rimuove l'ultimo l'elemento ispezionato da questo iteratore
      @throws java.lang.IllegalStateException se il metodo next non e' stato
              prima chiamato o il metodo remove è stato chiamato dopo l'ultima
              invocazione al metod next
   */
   void remove() throws java.lang.IllegalStateException;  
}
