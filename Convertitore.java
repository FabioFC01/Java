import java.util.*;

public class Convertitore{
    public static void main (String [] args){
        int num10 = 83;
        int num2 = 0;
        
        //base 2 conversione
        int num = num10;
        int resto = 0;
        String nume2 = "";
        int lun = 0;
        
        while( num != 0){
            resto = num % 2;
            nume2 += resto;
            num = num/2;
        }
        System.out.println();
        lun = nume2.length();
        System.out.println(lun);
        for(int i = lun-1; i >= 0; i--){
            System.out.print(nume2.charAt(i));
        }
        System.out.println();
        System.out.println(nume2);
        
        
    }
}
