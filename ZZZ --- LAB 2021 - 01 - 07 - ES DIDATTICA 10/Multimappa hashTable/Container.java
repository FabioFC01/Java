/**
  * Interfaccia Container
  * Definisce il tipo di dati astratto Contenitore
  *
  * @author A. Luchetta
  * @version 14-02-2019
  *
  */
  public interface Container
  {   
  
     /**
       * Verifica se questo contenitore e' vuoto
       * @return true se questo contenitore e' vuoto, false altrimenti
       */
     boolean isEmpty();
     
     /**
       * Rende vuoto il contenitore
       */
     void makeEmpty();   
           
       
     /**
       * Fornisce il numero di elementi presenti in questo contenitore
       * @return il numero di elementi presenti in questo contenitore
       */
     int size();       
  }