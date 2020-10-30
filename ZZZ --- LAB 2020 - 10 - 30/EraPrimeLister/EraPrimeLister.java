import java.util.Scanner;

public class EraPrimeLister{
    public static void main(String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);
        //declaration and Input
        int n = in.nextInt();
        int num_numeri = n-1;
        int [] num = new int[num_numeri];
        int max = (int)Math.sqrt(n);

        System.out.println("------------------------");
        System.out.println();

        //Close flow
        in.close();

        //Calculation;
        //Riempie l'array, 2 --> n
        for (int j = 0; j < num_numeri; j++){
            num[j] = j+2;
        }
        //Stampa array prima volta
        for (int j = 0; j < num_numeri; j++){
            System.out.println(num[j]);
        }

        for(int i = 2; i <= max; i++){
            for (int j = 0; j < num_numeri; j++){
                //scorre l'array
                if((num[j] % i == 0) && (num[j] / i != 1)){
                    num[j] = 0;
                }
            }
        }

        System.out.println("----------------------------------");
        System.out.println();

        //Stampa array con
        for (int j = 0; j < num_numeri; j++){
            if(num[j] != 0){
                System.out.println(num[j]);
            }
        }


    }
}