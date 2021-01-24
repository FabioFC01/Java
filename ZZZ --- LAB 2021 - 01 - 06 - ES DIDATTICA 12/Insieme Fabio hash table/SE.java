import java.util.NoSuchElementException;

public class SE <E extends Comparable > extends S<E>  implements Comparable<SE<E>> {
   //costruttori
   public SE () {
      super();
   }
   public SE (E[] a) {
      super(a);
   }
   public SE (Set s){
      super(s);
   }

   /*
   Siano s1 e s2 due insiemi:
- se s1.size() < s2.size() allora s1 precede s2
- mentre se s1.size() > s2.size() allora s1 segue s2.
Se gli insiemi hanno la stessa dimensione, allora si confrontino gli elementi ordinati dei due insiemi
a coppie (uno per ciascun insieme) a partire dai maggiori.
   */
  @Override
  public int compareTo (SE s){
     if (s == null) {
        throw new NullPointerException();
     }
     //se sono diverse le lunghezze
     if (size() != (s.size())) {
         return size() - s.size();
     }
     //se le lunghezze sono uguali
     Comparable [] s1 = new Comparable [size()];
     Comparable [] s2 = new Comparable [size()];

     toSortedArrayComp(s1);
     toSortedArrayComp(s2);

     for (int i = size() -1; i >= 0; i--) {
        if (s1[i].compareTo(s2[i]) != 0) {
           return s1[i].compareTo(s2[i]);
        }
     }

     //è tutto uguale
     return 0;
  }

   //min
   @Override
   public E min() throws java.util.NoSuchElementException {
      if (isEmpty()){
         throw new NoSuchElementException();
      }
      //crea nuovo iteratore
      Iterator<E> iter = iterator();
      //caso base
      if (size() < 2) {
         return iter.next();
      }

      //togli un elemento
      E rimosso = iter.next();
      iter.remove();

      //ricorsione
      E minimo = min();

      //aggiunta
      add(rimosso);

      //confronto
      if (rimosso.compareTo(minimo) < 0) {
         minimo = rimosso;
      }

      return minimo;
   }

   //subset
   public SE<E> subset(Iterator<E> iter){
      SE<E> insieme = new SE();
      while(iter.hasNext()){
         insieme.add(iter.next());
      }

      return insieme;
   }

}
