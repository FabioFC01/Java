public class Ordinamento {

/**
      ordinamento per fusione degli elementi di un array di numeri interi. O(n*log n).
      @param a l'array da ordinare
   */
  public static void mergeSort(Comparable[] a)
  {
     // caso base
     if (a.length < 2) return;

     // dividiamo (circa) a meta'
     int mid = a.length / 2;

    // creazione di array temporanei

     Comparable[] left = new Comparable[mid];
     Comparable[] right = new Comparable[a.length - mid];
     System.arraycopy(a, 0, left, 0, mid);
     System.arraycopy(a, mid, right, 0, a.length - mid);

     // passi ricorsivi: problemi piu' semplici
     // si tratta di doppia ricorsione
     mergeSort(left);
     mergeSort(right);


     // fusione
     merge(a, left, right);
  }

  /*
     fonde due sottoarray ordinati
     @param a l'array ordinato
     @param b sottoarray ordinato
     @param c sottoarray ordinato
  */
  private static void merge(Comparable[] a, Comparable[] b, Comparable[] c)
  {
     int ia = 0, ib = 0, ic = 0;

     //finché ci sono elementi in b e c
     while (ib < b.length && ic < c.length)
        if (b[ib].compareTo(c[ic]) < 0)  // enunciato di comparazione
           a[ia++] = b[ib++];
        else
           a[ia++] = c[ic++];

     //qui uno dei due array non ha più elementi
     while (ib < b.length)
        a[ia++] = b[ib++];
     while (ic < c.length)
        a[ia++] = c[ic++];
  }
}