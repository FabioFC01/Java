/**
  * Interfaccia Iterator
  * concetto astratto di posizione all'interno di una lista
  * @author A. luchetta
  * @version 24-Nov-2006
  */
  public interface Iterator
  {
     /**
        ispeziona l'elemento DOPO la posizione corrente dell'iteratore, avanzando
        successivamente l'iteratore di una posizione nella lista
        @return l'elemento ispezionato, se presente
        throws java.util.NoSuchElementException se non ci sono elementi dopo la
        posizione corrente dell'iteratore
     */
     Object next();
  
     /**
        verifica se e' presente almeno un elemento dopo la posizione corrente
        dell'iteratore
        @return true se e' presente almeno un elemento, false altrimenti
     */
     boolean hasNext();
  
    /**
       inserisce un nuovo elemento dopo la posizione corrente dell'iteratore,
       l'iteratore si posiziona dopo il nuovo elemento
       @param x elemento da inserire
    */
    void add(Object x);
  
    /**
       elimina l'ultimo nodo esaminato dal metodo next()
       puo' essere invocato solo dopo l'invocazione del metodo next()
       @throws java.lang.IllegalStateException se precedentemente non e' stato
       invocato il metodo next()
    */
    void remove();
  }