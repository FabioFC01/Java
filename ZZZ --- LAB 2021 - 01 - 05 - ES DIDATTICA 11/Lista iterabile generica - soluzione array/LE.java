public class LE <E extends Comparable> extends L <E>{

   //costruttore
   public LE () {
      super();
   }

   public int rankOfSortedList(E x) {
      return search(x);
   }

   /**
    * 
    * @return lista contenente gli elementi della lista ordinati 
               secondo il loro ordine naturale
    */
   public List<E> toSortedList() {
      //lista di appoggio
      List <E> l = new L <E> ();

      //array di oggetti
      Object [] a = super.toArray();

      //ordina
      sort (a);

      for (int i = 0; i < a.length; i++) {
         l.add(i, (E)a[i]);
      }

      return l;
   }

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