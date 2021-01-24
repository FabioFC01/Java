/** FONDAMENTI DI INFORMATICA - CANALE 4
  * PROVA DI PROGRAMMAZIONE DEL 3-LUGLIO-2019
  *
  * Interfaccia List - definisce una lista di elementi parametrici
  *
  * @typeparam E - tipo parametrico
  *
  * @see Container
  * @see Iterator
  *
  * @author A. Luchetta
  * @version 18-06-2019
  */
  public interface List <E> extends Container, Iterable
  {
   /**
       Inserisce l'elemento specificato all'ultima posizione della lista.
       @param x elemento specificato
       @throws IllegalArgumentException se l'elemento specificato vale null                   
     */
     void add(E x);
     
   /**
       Inserisce l'elemento specificato nella posizione di rango specificato.
       Sposta l'elemento attualmente in quella posizione (se esiste) e tutti gli
       elementi seguenti a destra (aggiunge uno ai ranghi).
       @param r rango specificato
       @param x elemento specificato
       @throws java.lang.IndexOutOfBoundsException se il rango non e' nei limiti
               ovvero non e' nell'intervallo [0, numero di elementi della lista]
       @throws IllegalArgumentException se l'elemento specificato vale null                   
     */
     void add(int r, E x);
       
     /**
        Restituisce l'elemento di rango specificato
        @param r rango specificato
        @return elemento di rango specificato
        @throws IndexOutOfBoundsException se il rango non e' nei limiti ovvero non
                e' nell'intervallo [0, numero di elementi della lista - 1]  
     */
     E get(int r);
        
     /**
        Fornisce il rango dell'elemento specificato se presente
        @param x l'elemento specificato
        @return il rango della prima occorrenza nella lista dell'elemento
                specificato o -1 se la lista non contiene l'elemento.
     */
     int rankOf(E x);    
     
     /**
        Rende accessibili gli elementi della lista tramite un array
        @return array contenente gli elementi della lista nella sequenza naturale
     */
     Object[] toArray();
  }