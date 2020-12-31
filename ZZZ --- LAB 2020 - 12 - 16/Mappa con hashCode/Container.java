/**
  * interfaccia Container: Interfaccia didattica. Non contiene il metodo size.
  * @author M. Dalpasso modificata da A. Luchetta
  * @version 20-Nov-2006
  */
  public interface Container
  {
    /**
       @return true se il contenitore e' vuoto, false altrimenti
    */
    boolean isEmpty();
    
    /**
       rende il contenitore vuoto
    */
    void makeEmpty();
  }
  