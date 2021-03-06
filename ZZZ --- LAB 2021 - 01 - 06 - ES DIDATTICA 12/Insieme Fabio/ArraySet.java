//INSIEME SENZA DOPPIONI

public class ArraySet <E extends Comparable> implements Set {
   //variabili di esemplare
   private Object [] v;
   private int vSize;
   private static final int INITIAL_SIZE = 1;
   
   //costruttore
   public ArraySet () {
      makeEmpty();
   }

   //makeEmpty
   public void makeEmpty () {
      v = new Object [INITIAL_SIZE];
      vSize = 0;
   }

   public boolean isEmpty () {
      return vSize <= 0;
   }

   public int size () {
      return vSize;
   }

   public boolean contains (Object rif) {
      for (int i = 0; i < vSize; i++){
         if (v[i].equals(rif)){
            return true;
         }
      }
      return false;
   }

   /**
        inserisce in questo insieme l'elemento specificato se e' diverso da null e
        non e' gia' presente 
        @param e l'elemento specificato
        @return false se questo insieme conteneva gia' l'elemento specificato
     */
   public boolean add(Comparable e) {
      if (e == null) {
         throw new IllegalArgumentException();
      }

      if (contains(e)) {
         return false;
      }

      //se non ci dovesse essere e

      if (vSize >= v.length){ //ridimensionamento dinamico
         Object [] newV = new Object [2 * v.length];
         System.arraycopy(v, 0, newV, 0, vSize);
         v = newV;
      }

      //aggiunta elemento
      v[vSize++] = e;

      //ritorno
      return true;
   }

   public Comparable [] toArray () {

      Comparable [] rit = new Comparable [vSize];
      System.arraycopy(v, 0, rit, 0 ,vSize);
      return rit;
   } 


   /**
        copia nell'array specificato gli elementi di questo insieme ordinati
        in senso crescente secondo il loro ordine naturale
        @param a array specificato
        @return numero di elementi di questo insieme copiati nell'array specif.to
        @throws java.lang.ArrayIndexOutOfBoundsException se la dimensione
                dell'array specificato e' minore della dimensione dell'insieme
          
     */
   public int toSortedArray(Comparable[] a) throws ArrayIndexOutOfBoundsException {
      if (a.length < vSize) {
         throw new ArrayIndexOutOfBoundsException();
      }

      Comparable [] raw = toArray();
      mergeSort(raw);

      System.arraycopy(raw, 0 , a, 0 , raw.length);

      return raw.length;
   }

   private void mergeSort (Comparable [] a) {
      if (a.length < 2) {
         return;
      }
      int mid = a.length / 2;

      Comparable [] l = new Comparable [mid];
      Comparable [] r = new Comparable [a.length - mid];

      System.arraycopy(a, 0, l, 0, mid);
      System.arraycopy(a, mid, r, 0, a.length - mid);

      mergeSort(l);
      mergeSort(r);

      merge (a, l, r);
   }

   private void merge (Comparable [] a, Comparable [] l, Comparable [] r) {
      int ia = 0;
      int il = 0;
      int ir = 0;

      while (il < l.length && ir < r.length) {
         if (l[il].compareTo(r[ir]) < 0) {
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


   //OPERAZIONI SU INSIEMI 


   //UNIONE
   public static ArraySet union (ArraySet s1, ArraySet s2) {
      ArraySet <Comparable> rit = new ArraySet <Comparable> ();

      Object [] s1A = s1.toArray();
      Object [] s2A = s2.toArray(); 

      for (int i = 0; i < s1A.length; i++) {
         rit.add((Comparable)s1A[i]);
      }

      for (int i = 0; i < s2A.length; i++) {
         rit.add((Comparable)s2A[i]);
      }

      return rit;
   }

   //INTERSEZIONE
   //elementi presenti nel primo e nel secondo
   public static ArraySet intersection (ArraySet s1, ArraySet s2) {
      ArraySet <Comparable> rit = new ArraySet <Comparable> ();

      Object [] v = s1.toArray();

      for (int i = 0; i < v.length; i++) {
         if (s2.contains(v[i])){
            rit.add((Comparable)v[i]);
         }
      }

      return rit;
   }

   //SOTTRAZIONE
   //elementi che appartengono al primo ma non al secondo
   public static ArraySet subtract (ArraySet s1, ArraySet s2) {
      ArraySet <Comparable> rit = new ArraySet <Comparable> ();

      Object [] v = s1.toArray();

      for (int i = 0; i < v.length; i++) {
         if (!s2.contains(v[i])){
            rit.add((Comparable)v[i]);
         }
      }
      return rit;
   }
   
   
}