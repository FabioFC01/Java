/**
  * Container.java
  *
  * Definisce un contenitore astratto.
  *
  * @author A. Luchetta
  * @version 18-Nov-2006
  *
  */
  public interface Container
  {
    /**
      verifica se il contenitore e' vuoto.
      @return true se il contenitore e' vuoto, false altrimenti
    */
    boolean isEmpty();
  
    /**
      rende vuoto il contenitore.
    */
    void makeEmpty();
  
    /**
      restituisce il numero di elementi presenti nel contenitore.
      @return il numero di elementi presenti nel contenitore
    */
    int size();
}  