import java.util.Random;

public class ItMergeSorter {
    //
    private int [] numeri;

    public ItMergeSorter (int size){
        if(size < 1){
            throw new IllegalArgumentException();
        }
        numeri = new int [size];
        this.fill();
        this.randomize();
    }

    public void fill () {
        for (int i = 0; i < numeri.length; i++){
            numeri [i] = i+1;
        }
    }

    public void randomize () {
        Random rand = new Random();
        int a, b;
        int temp;

        //scambi
        for (int i = 0; i < 2 * numeri.length; i++){
            a = rand.nextInt(numeri.length);
            b = rand.nextInt(numeri.length);

            temp = numeri[a];
            numeri [a] = numeri[b];
            numeri [b] = temp;
        }
    }

    public String toString () {
        String output = "";
        if(numeri.length < 20) {
            for (int i = 0; i < numeri.length; i++){
                output += numeri[i] + "  ";
            } 
        }
        return output;
    }

    public int[] getArray(){
        return numeri;
    }

    /* Iterative mergesort function to sor
    t arr[0...n-1] */
    static void mergeSort(int arr[], int n) {
         
        // For current size of subarrays to
        // be merged curr_size varies from 
        // 1 to n/2
        int curr_size; 
                     
        // For picking starting index of 
        // left subarray to be merged
        int left_start;
                         
         
        // Merge subarrays in bottom up 
        // manner. First merge subarrays 
        // of size 1 to create sorted 
        // subarrays of size 2, then merge
        // subarrays of size 2 to create 
        // sorted subarrays of size 4, and
        // so on.

        //n-1 è l'ultimo indice dell'array di lunghezza n
        for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size)  {
             
            // Pick starting point of different
            // subarrays of current size
            //inizialmente left_start salta di 2 alla volta, ha senso
            for (left_start = 0; left_start < n-1; left_start += 2*curr_size) {
                // Find ending point of left 
                // subarray. mid+1 is starting 
                // point of right
                int mid = Math.min(left_start + curr_size - 1, n-1);
         
                int right_end = Math.min(left_start  + 2*curr_size - 1, n-1);

                // Merge Subarrays arr[left_start...mid]
                // & arr[mid+1...right_end]
                merge(arr, left_start, mid, right_end);
            }
        }
    }
     
    /* Function to merge the two haves arr[l..m] and
    arr[m+1..r] of array arr[] */
    static void merge(int arr[], int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
     
        /* create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];
     
        /* Copy data to temp arrays L[]
        and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
     
        /* Merge the temp arrays back into
        arr[l..r]*/
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k++] = L[i++];
            }
            else
            {
                arr[k++] = R[j++];
            }
        }
     
        /* Copy the remaining elements of 
        L[], if there are any */
        while (i < n1)
        {
            arr[k++] = L[i++];
        }
     
        /* Copy the remaining elements of
        R[], if there are any */
        while (j < n2)
        {
            arr[k++] = R[j++];
        }
    }
     
    /* Function to print an array */
    static void printArray(int A[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.printf("%d ", A[i]);
        System.out.printf("\n");
    }


    public static void main (String [] args){
        //test
        ItMergeSorter num = new ItMergeSorter(5);
        System.out.println("Array disordinato");
        System.out.println(num);
        System.out.println("Array ordinato");
        int [] numeri = num.getArray();
        mergeSort(numeri,numeri.length);
        printArray(numeri, numeri.length);
    }
}