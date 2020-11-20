
public class RecursiveFactorsComputer {
    public static void main (String [] args){
        System.out.println(recursivelyMakeFactors(12)); //2*2*3
        

    }

    
    public static String recursivelyMakeFactors (int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return "";
        }
        else {
            int count = 2;
            while (count <= n) {
                if(n % count == 0) {
                    String exit = count + " * " + recursivelyMakeFactors(n/count);
                    return exit;
                }
                else {
                    count = nextPrime(count);
                }
            }
        }
        return "";


    }

    private static int nextPrime (int n) {
        //ti da il num. primo successivo a n
        int count = n+1;
        int divisori = 0;
        boolean found = false;

        if(n < 1) {
            throw new IllegalArgumentException();
        }
        if ( n == 1) {
            return 2;
        }
        if ( n == 2) {
            return 3;
        }
        if ( n == 3) {
            return 5;
        }
        

        while (found == false){
            divisori = 0;
            for (int i = 3; i < (count); i++){
                if (count % i == 0) {
                    divisori++;
                }
            }
            //controlla num. divisori
            if (divisori == 0) {
                found = true;
            }
            else {
                count++;
            }
        }

        return count;
    }
}