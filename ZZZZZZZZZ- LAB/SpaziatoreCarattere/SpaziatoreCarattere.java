public class SpaziatoreCarattere {
    public static void main (String [] args){
        int n = 780;

        //oppure String s = n + "";
        String s = Integer.toString(n);

        //output
        System.out.println(s.charAt(0) + " " + s.charAt(1) + " " + s.charAt(2));
    }
}