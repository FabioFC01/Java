import java.util.Scanner;

public class LineCharacterReverser{
    public static void main (String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);

        String inp = in.nextLine();
        int length = inp.length();
        String reverse = "";
        for (int i = length-1; i >= 0; i--){
            reverse = reverse + inp.charAt(i);
        }

        System.out.println(reverse);

        //Close flow
        in.close();
    }
}

/*
ABCDEFGHILMNO    0123456789
9876543210    ONMLIHGFEDCBA
*/