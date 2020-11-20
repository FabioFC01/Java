public class RecursiveNumberLister2 {
    public static void main (String [] args){
        String g = RecursiveNumber (46);
        System.out.println(g);
    }

    public static String RecursiveNumber (int n) {
        if (n == 1)
            return "1";
        else {
            String exit = String.format("%32.12f", RecursiveNumber(n-1)) + "  " + n;
            return exit;
    }
}


}