import java.util.Scanner;

public class Dati{
    public static void main(String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);

        //Declarations
        System.out.println("Inserire intero, parola e numero a virgola mobile in una riga");
        System.out.println("-----------------------------------------------------------");
        String input = in.nextLine();

        int num;
        String parola;
        double num2;

        int length = input.length();
        int i = 0;
        int space = 0;
        //find first space
        while(input.charAt(i)!=(int)' '){
            i++;
        }
        //int found
        num = Integer.parseInt(input.substring(0, i));
        i++;
        space = i;
        //find second space
        while(input.charAt(i)!=(int)' '){
            i++;
        }
        //String found
        parola = input.substring(space, i);
        i++;
        space = i;
        //double found
        num2 = Double.parseDouble(input.substring(space, length));

        //Output
        System.out.println(num);
        System.out.println(parola);
        System.out.println(num2);

        //close flow
        in.close();
    }
}

//int, parola, numero virgola mobile

/*
Inserire intero, parola e numero a virgola mobile in una riga
-----------------------------------------------------------
7 YEEEEAAAAAAAAAAHHHHHHHHH 8.95301
7
YEEEEAAAAAAAAAAHHHHHHHHH
8.95301
*/