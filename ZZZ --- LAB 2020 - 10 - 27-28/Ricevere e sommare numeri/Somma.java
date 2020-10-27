import java.util.Scanner;

public class Somma{
    public static void main (String[] args){
        //open flow
        Scanner in = new Scanner (System.in);

        //Declaration
        double somma = 0.0;
        double numeri [] = new double [3];

        //Input
        System.out.println("Inserisci tre numeri nella stessa riga in virgola mobile :");
        String inp = in.nextLine();
        int lenght = inp.length();
        int spazio = 0;
        int numero = 0;
        String temp;

        for (int i = 0; i < lenght; i++){
            if (inp.charAt(i) == (int)' '){
                temp = inp.substring(spazio, i);
                numeri[numero] = Double.parseDouble(temp);
                spazio = i;
                numero++;
            }
             
            if(i == lenght-1){
                temp = inp.substring(spazio, lenght);
                numeri[2] = Double.parseDouble(temp);
            }
        }

        somma = numeri[0] + numeri[1] + numeri[2];

        System.out.println(numeri[0]);
        System.out.println(numeri[1]);
        System.out.println(numeri[2]);

        System.out.println("-----------------------------");
        System.out.println("La somma è : " + somma);

        //close flow
        in.close ();
    }
}