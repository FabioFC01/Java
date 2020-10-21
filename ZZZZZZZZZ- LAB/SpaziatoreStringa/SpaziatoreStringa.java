public class SpaziatoreStringa {
    public static void main (String [] args){
        int n = 780;

        //oppure String s = n + "";
        String s = Integer.toString(n);

        //output
        System.out.println(s.substring(0, 1) + " " + s.substring(1, 2) + " " + s.substring(2, 3));
    }
}