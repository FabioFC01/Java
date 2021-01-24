import java.util.NoSuchElementException;

public class SE <E extends Comparable> extends S <E> implements Comparable <SE<E>> {

   //costruttore
   public SE () {
      super();
   }
   public SE (E [] a){
      super(a);
   }
   public SE (Set s){
      super(s);
   }

   @Override
   public int compareTo (SE<E> s) throws NullPointerException {
      if (s == null) {
         throw new NullPointerException();
      }

      int n = size() - s.size(); //differenza di lunghezza
      if ( n != 0) {
         return n;
      }

      //generazioni per array per chiamate a sortedarray
      Comparable [] a = new Comparable [size()];
      Comparable [] b = new Comparable [s.size()];

      //ordinamento
      int h = toSortedArrayComp(a);
      int p = s.toSortedArrayComp(b);

      //confronto
      for (int i = size() - 1 ; i >= 0; i--) {
         if (a[i].compareTo(b[i]) != 0) {
            return a[i].compareTo(b[i]);
         }
      }

      //se dovessero essere uguali
      return 0;
   }

   @Override
   public E min () throws NoSuchElementException {
      if (isEmpty()){
         throw new NoSuchElementException();
      }

      //caso base, un solo elemento
      Iterator <E> iter = iterator();
      if (size() < 2) {
         return iter.next();
      }

      //se è più lungo di 1
      E m1 = iter.next(); //quindi il primo
      iter.remove(); //rimozione primo elemento


      E min = min(); //richiamo ricorsivo

      add(m1); //riaggiunta

      //se m1 minore di min appena tornato da chimata ricorsiva
      if (m1.compareTo(min) < 0) {
         min = m1;
      }

      return min;
   }
   
}
