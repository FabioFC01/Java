public class RecursiveMeanComputer {
    public static void main (String [] args){
        int [] a = new int [] {-175, 2 , 4 , 6, 8}; //4
        int [] b = new int [] {-1, 2 , 5 , 6, 11}; //4.6 

        System.out.println(iterativelyComputeMean(a, a.length));
        System.out.println(iterativelyComputeMean(b, b.length));

        System.out.println("---------------" + "\n" + "Ricorsivo");

        System.out.println(recursivelyComputeMean(a, a.length));
        System.out.println(recursivelyComputeMean(b, b.length));
    }
    
    private static double recursivelyComputeMean(int[] a, int aSize) {
        if (aSize == 0) {
            throw new IllegalArgumentException();
        }
        if (aSize == 1){
            return a[0];
        }
        else {
            return ( (recursivelyComputeMean(a, aSize-1) * (aSize-1) ) + a[aSize-1] ) / (aSize);
        }
    }
    private static double iterativelyComputeMean(int[] a, int aSize) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum/(a.length);
    }
}