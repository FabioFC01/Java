/**
  * Interfaccia List
  * ADT Lista
  * rappresenta il concetto astratto di lista posizionale
  *
  * @see Iterable
  * @see Container
  *
  * @author A. Luchetta
  * @version
  */
  public interface List extends Iterable, Container
  {
     /**
       Restituisce l'elemento alla posizione specificata nella lista
       @index indice dell'elemento da restituire
     */
     Object get(int index);
  
     /**
       Sostituisce l'elemento alla posizione specificata nella lista con l'elemento x
       @param index posizione dell'elemento da sostituire
       @param x elemento da memorizzare alla posizione
        specificata
       @return l'elemento precedentemente memorizzato
        Alla posizione specificata
     */
     Object set(int index, Object x);
  
    /**
        Inserisce l'elemento specificato alla posizione specificata nella lista
        Sposta a destra tutti gli elementi presenti
        di un posto
        @index rango dell'elemento da inserire
        @x elemento da inserire
     */
     void add(int index, Object x);
  
    /**
        Estrae l'elemento alla posizione specificata nella lista. Sposta a sinistra di
        un posto tutti gli elementi che seguono
        L'elemento estratto
        @index rango dell'elemento da sostituire
  
     */
     Object remove(int index);
  }