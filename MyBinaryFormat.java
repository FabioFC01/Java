import java.util.stream.*;
import java.util.Scanner;

public class MyBinaryFormat {

    private String bin;
    private int dec;
    private int resto;
    private int base = 2;    
    private String bina = "";
    private String digit_spacer = "_";
    private String positive_sign = "0";
    private String binary_mark = "b0";

    //Costructor
    MyBinaryFormat(int decimal){
        this.bin = "";
        this.dec = decimal;
        this.resto = 0;
    }

    public void calculator(){
        resto = dec % base;
        bin += resto;
        dec /= base;

        resto = dec % base;
        bin += resto;
        dec /= base;

        resto = dec % base;
        bin += resto;
        dec /= base;

        resto = dec % base;
        bin += resto;
        dec /= base;

        //insert _ character
        bin += digit_spacer;

        resto = dec % base;
        bin += resto;
        dec /= base;

        resto = dec % base;
        bin += resto;
        dec /= base;

        resto = dec % base;
        bin += resto;
        dec /= base;

        //insert "0b0"
        bin += positive_sign + binary_mark;
    }


    public void invertString(){
        int length = bin.length();
        for ( int i = 0; i < length; i++){
            bina += bin.substring(length-(i+1), length-i);
        }
    }

public String getValue (){
        return bina;
    }


    public static void main(String [] args){
        int decimal;
        String binary;

        System.out.println("********************************");
        System.out.println("Insert a positive number  ");
        System.out.println("0 <= number < 127");

        Scanner in = new Scanner(System.in);
        decimal = in.nextInt();
        in.close();

        MyBinaryFormat numero = new MyBinaryFormat(decimal);
        numero.calculator();
        numero.invertString();
        binary = numero.getValue();

        System.out.println(binary);
    }
}