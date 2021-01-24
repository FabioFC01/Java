/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Realizzando questa interfaccia e' possibile scandire in sequenza gli
  * elementi di un contenitore
  *
  * @typeparam T il tipo di elementi restituiti dall'iteratore
  * @see Iterator
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
  public interface Iterable<T>
{
   /**
      Fornisce un iteratore sulla sequenza
      @return un iteratore sugli elementi di tipo T
   */
   Iterator<T> iterator();
}

