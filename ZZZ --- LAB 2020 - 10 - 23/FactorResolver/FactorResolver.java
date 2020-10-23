import java.util.Scanner;

public class FactorResolver{

    public static boolean Primo (int num){
        boolean primo = true;
        if(num == 2){
            return true;
        }
        for (int i = (int)((num/2)+1); i >= 2; i--){
            if(num % i == 0){
                primo = false;
            }
        }
        return primo;
    }

    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        //declaration
        int num = in.nextInt();
        in.close();

        int rimasto = num;
        int ultimoDivisore = 2;

        String factors = "";

        while (rimasto != ultimoDivisore){
            if (Primo(ultimoDivisore) == true) {
                if ( rimasto % ultimoDivisore == 0){
                    rimasto /= ultimoDivisore;
                    factors =  ultimoDivisore + " * " + factors;
                }
                else{
                    ultimoDivisore++;
                }
            
            }
            else{
                ultimoDivisore++;
            }
        
        }
        factors = ultimoDivisore + " * " + factors;

        
        System.out.println(factors.substring(0,factors.length()-2));

    }
}