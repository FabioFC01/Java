/**
  * Definisce il tipo di dati astratto Multimappa Ordinata, un contenitore di
  * associazioni chiave/valore dove la chiave non e' necessariamente univoca ed
  * e' di tipo parametrico limitato a Comparable
  *
  * @typeparam K tipo parametrico limitato a Comparable della chiave 
  * @typeparam V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 27-12-2020
  *
  */
  public interface SortedMultimap<K extends Comparable,V> extends Container
  {   
     /**
       * Fornisce i valori a cui la chiave specificata e' associata
       * @param key la chiave specificata
       * @return un array contenente i valori a cui la chiave specificata
       *         e' associata, o un array di dimensione nulla se questa multimappa
       *         non contiene associazioni per la chiave
       */      
     Object[] findAll(K key);
     
     /** 
       * Associa il valore specificato alla chiave specificata in questa
       * multimappa
       * @param key la chiave specificata
       * @param value il valore specificato
       * @throws java.lang.IllegalArgumentException se la chiave o il valore
       *          specificati valgono null
       */
     void insert(K key, V value);    
    
     /**
       * Fornisce le chiavi di questa multimappa
       * @return un array ordinato contenente le chiavi di questa multimappa o
       *         un array di dimensione nulla se questa multimappa e' vuota
       */
     Comparable[] keys();   
          
     /**
       * Rimuove le associazioni di chiave specificata da questa multimappa 
       * @param key la chiave specificata
       * @return un array contenente i valori a cui la chiave specificata
       *         era associata, o un array di dimensione nulla se questa
                 multimappa non contiene associazioni per la chiave     
       */      
     Object[] removeAll(K key);       
  }