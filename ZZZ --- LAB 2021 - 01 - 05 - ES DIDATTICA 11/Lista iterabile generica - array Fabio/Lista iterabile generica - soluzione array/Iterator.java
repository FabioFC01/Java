/** FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA DI PROGRAMMAZIONE DEL 3-LUGLIO -2019
  *
  * Interfaccia Iterator - definisce la posizione in una sequenza
  *
  * @typeparam E - tipo parametrico
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
  public interface Iterator <T> // Iterazione su una lista
  {
     /**
        Verifica se e' presente nella sequenza un elemento in posizione successiva
        alla posizione dell'iteratore
        @return true se esiste un elemento successivo nella sequenza o altrimenti
                false 
     */
     boolean hasNext();
     
     /**
        Fornisce l'elemento in posizione successiva alla posizione
        dell'iteratore e avanza l'iteratore di una posizione.
        @return l'elemento successivo nell'iterazione
        @throws java.util.NoSuchElementException se non sono presenti elementi in
                posizione successiva alla posizione dell'iteratore
     */
     T next();
     
     /**
        Rimuove l'elemento che precede la posizione dell'iteratore.
        Il metodo puo' essere invocato solo dopo l'invocazione del metodo next.
        @throws java.lang.IllegalStateException se il metodo viene invocato senza
                una precedente invocazione del metodo next
     */
     void remove();   
  }