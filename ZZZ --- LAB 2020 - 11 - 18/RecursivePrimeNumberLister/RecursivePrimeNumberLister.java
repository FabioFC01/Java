import java.lang.Math;

public class RecursivePrimeNumberLister {
    public static void main (String [] args){
        final int DIMENSIONI = 100;
        int [] ritorno = new int [DIMENSIONI];
        ritorno = recursiveListPrimeNumbers(DIMENSIONI);

        for (int i = 0; i < ritorno.length; i++){
            if(ritorno[i] != 0){
                System.out.println(ritorno[i]);
            }
        }
    }

    public static int[] recursiveListPrimeNumbers(int n) {
        //da 1 a n, con n >=1, estremi compresi
        int [] a = new int [n-1];
        if(n < 1) {
            throw new IllegalArgumentException();
        }
        if(n == 2) {
            int [] ritorno1 = new int [] {2};
            return ritorno1;
        }
        else {
            if(isprime(n)) {
                a [0] = n;
                int [] ritorno = new int [n-2]; 
                ritorno = recursiveListPrimeNumbers(n-1);
            
                System.arraycopy(ritorno, 0, a, 1, ritorno.length);
            }
            else{
                int [] ritorno = new int [n-2]; 
                ritorno = recursiveListPrimeNumbers(n-1);
            
                System.arraycopy(ritorno, 0, a, 0, ritorno.length);
            }
            
            return a;
        }
    }

    public static boolean isprime( int n) {
        int i;
        for(i=2; i<= Math.pow (n , 0.5) ; i++){
            if(n%i == 0)
                    return false;
        }
                
        return true;
    }
}

/* 
output senza controllo dell'if alla riga 10
97
89
83
79
73
71
67
61
59
53
47
43
41
37
31
29
23
19
17
13
11
7
5
3
2
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
0
*/


/*
stampa con controllo if alla riga 10

97
89
83
79
73
71
67
61
59
53
47
43
41
37
31
29
23
19
17
13
11
7
5
3
2
*/