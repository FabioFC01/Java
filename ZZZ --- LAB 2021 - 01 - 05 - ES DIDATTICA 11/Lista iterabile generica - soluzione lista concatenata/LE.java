public class LE<E extends Comparable> extends L<E>
{
   //costruttore
   public LE () {
      super();
   }


   public int rankOfSortedList(E x) {
      return search(x);
   }


   public List<E> toSortedList() {
      Object [] v = toArray();

      sort (v);

      //lista di appoggio
      List <E> lista = new LE <E> ();

      for (int i = 0; i < v.length; i++) {
         lista.add(i, (E)v[i]);
      }

      return lista;
   }



   // METODI NOIOSI



   //metodo sort
   private void sort (Object [] a) {
      if (a.length < 2) {
         return;
      }

      int mid = a.length / 2;

      Object [] l = new Object [mid];
      Object [] r = new Object [a.length - mid];

      System.arraycopy(a, 0, l, 0, mid);
      System.arraycopy(a, mid, r, 0, r.length);

      sort(l);
      sort(r);

      merge (a, l , r);
   }

   //metodo sort
   private void merge (Object [] a, Object [] l, Object [] r){
      int ia = 0;
      int il = 0;
      int ir = 0;

      while (il < l.length && ir < r.length) {

         Comparable left = (Comparable)(l[il]);

         if (left.compareTo((Comparable)r[ir]) < 0) {
               a[ia++] = l[il++];
         }
         else{
               a[ia++] = r[ir++];  
         }
      }

      while (il < l.length) {
         a[ia++] = l[il++];
      }
      while (ir < r.length) {
         a[ia++] = r[ir++];
      }
   }

   //metodo ricerca binaria
   private static int search (Object [] a, int from, int to, Object rif) {
      if (to < from) {
         return -1;
      }

      int mid = (from + to) / 2;

      if (((Comparable)a[mid]).compareTo(rif) == 0) {
         return mid;
      }
      else if (((Comparable)a[mid]).compareTo(rif) > 0) {
         return search(a, from, mid - 1, rif);
      }
      else {
         return search(a, mid + 1, to, rif);
      }
   }

   //metodo search chiamata
   private  int search (Object x) {
      Object [] v = toSortedList().toArray();

      return search(v, 0, v.length, x);
   }
}
