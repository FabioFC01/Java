import java.util.Scanner;

public class RecursiveSubStringFinder {
    public static void main (String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);

        String s = in.next();
        String sub = in.next();

        //close flow
        in.close();

        int result = RecursiveSubString(s,sub,0);

        System.out.println(result + "  " + (result + sub.length() - 1));
        
    }

    public static int RecursiveSubString (String s, String sub, int i) {
        int k = i;
        if (s == null || sub == null) {
            throw new IllegalArgumentException();
        }
        if((i + sub.length())  <=  s.length() ) {
            if(sub.equals(s.substring(i, i + sub.length()))){
                return i;
            }
        }
        if ((i + sub.length())  >  s.length() ) {
            return -1;
        }
        k++; 
        return RecursiveSubString (s, sub, k);
    }
}