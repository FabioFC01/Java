import java.util.Scanner;

public class Input{
    public static void main (String [] args){
        //open flow
        Scanner in = new Scanner (System.in);

        String inp = in.nextLine();
        int x = inp.length();

        int spazio = x;
        int parola = 0;
        String parole [] = new String [3];

        for (int i = x-1; i >= 0; i--){
            if(inp.charAt(i) == (int)' '){
                parole[parola] = inp.substring(i+1, spazio);
                spazio = i;
                parola ++;
            }
            if(i == 0){
                parole[parola] = inp.substring(0, spazio);
            }
        }

        System.out.println(parole[0]);
        System.out.println(parole[1]);
        System.out.println(parole[2]);

        in.close();
    }
}

/*
Ciao nonna mia
mia
nonna
Ciao
*/