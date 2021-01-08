/**
  * Interfaccia Iterable
  * Definisce la proprieta' di iterativita'
  *
  * @author A. Luchetta
  * @version 14-02-2019
  *
  */
  public interface Iterable<T>
  {   
     /**
       * Fornisce un iteratore sulla sequenza
       * @return un iteratore posizionato prima del primo elemento della sequenza
       */
     Iterator<T> iterator();      
  }