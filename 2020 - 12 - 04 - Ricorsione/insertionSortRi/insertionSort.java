public class insertionSort {
    public static void insertionSortRi(int[] a, int n){
        if ( n > 1){
            insertionSortRi(a,n-1);
            int value = a[n-1];
            int i;
            for (i = n-2; i >= 0 && a[i] > value; i--){
                a[i+1] = a[i];
            }
            a[i+1] = value;
        }
    }
    public static void main (String [] args){
        int [] a = new int [] {2,1,3,11,5,7,8,9};
        insertionSortRi(a, a.length);

        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
    }
}