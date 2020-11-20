public class RecursiveNumberLister {
    public static void main (String [] args){
        String g = RecursiveNumber (7);
        System.out.println(g);
    }

    public static String RecursiveNumber (int n) {
        if (n == 1)
            return "1";
        else
            return RecursiveNumber(n-1) + " " + n;
    }
}