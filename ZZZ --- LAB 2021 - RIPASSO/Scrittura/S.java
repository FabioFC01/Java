public class S {
   public static void main (String [] args){
      Comparable [] boh = {9,8,7,6,5,4,3,2,1,0};
      mergeSortIterativo(boh, boh.length);


      for (Comparable e : boh) {
         System.out.println(e);
      }
      
   }

   
public static void mergeSortIterativo (Comparable [] a, int n){
   //for current size of subarrays to be merged curr_size
   //varies from 1 to n/2
   int curr_size;

   //for picking starting index of left subarrays to be merged
   int left_start;

   //n-1 is the last index of the array of length n
   //dimension of curr_size is doubled every time
   for (curr_size = 1; curr_size <= n-1; curr_size *= 2){
      //pick starting points
      //inizialmente left_start salta di 2 alla volta, ha senso
      //initially left_start jumps 2 at a time, makes sense
      // < , not <= because of right array
      for (left_start = 0; left_start < n-1; left_start += 2*curr_size) {
         //find ending point of left subarray
         //mid + 1 is the starting point of right array
         int mid = Math.min(left_start + curr_size - 1, n-1);

         int right_end = Math.min(left_start + (2*curr_size) - 1, n-1);

         //merge subarrays
         //arr[left_start - mid]
         //arr[mid + 1, right_end]
         merge(a, left_start, mid, right_end);
      }
   }
}

// merge
static void merge(Comparable [] a, int l, int m, int r) 
{
   //[l ...m] - [m+1 ... r]
   //    L           R 

   int i, j, k;
   //length of L
   int n1 = m - l + 1;
   //length of R
   int n2 = r - m;
     
   /* create temp arrays */
   Comparable L[] = new Comparable[n1];
   Comparable R[] = new Comparable[n2];
     
   /* Copy data to temp arrays L[]
   and R[] */
   for (i = 0; i < n1; i++)
      L[i] = a[l + i];
   for (j = 0; j < n2; j++)
      R[j] = a[m + 1+ j];
     
        /* Merge the temp arrays back into
        arr[l..r]*/
   i = 0;
   j = 0;
   k = l;
   while (i < n1 && j < n2)
   {
      if (L[i] .compareTo(R[j]) <= 0) {
            a[k++] = L[i++];
         }
      else {
         a[k++] = R[j++];
      }
   }
     
        /* Copy the remaining elements of 
        L[], if there are any */
   while (i < n1) {
      a[k++] = L[i++];
   }
     
        /* Copy the remaining elements of
        R[], if there are any */
   while (j < n2) {
      a[k++] = R[j++];
   }

} 

}