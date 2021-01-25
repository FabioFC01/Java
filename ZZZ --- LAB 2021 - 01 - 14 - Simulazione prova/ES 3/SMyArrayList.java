public class SMyArrayList <E extends Comparable <E>> extends MyArrayList<E> {
   @Override
   public E min() {
      Comparable [] val = toArray();

      E min = minRecursive(val);
      return min;
   }

   private E minRecursive (Comparable [] lista) {
      //caso base
      if (lista.length < 2) {
         return (E)lista[0];
      }

      //creazione nuova lista
      Comparable [] val = new Comparable [lista.length - 1];
      //copia tutto tranne uno
      System.arraycopy(lista, 0, val, 0, lista.length - 1);

      
      E min = minRecursive(val);

      if (((Comparable)min).compareTo((Comparable)val[val.length-1]) > 0) {
         min = (E)val[val.length-1];
      }

      return min;
   }
}
