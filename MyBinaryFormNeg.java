import java.util.stream.*;
import java.util.Scanner;

public class MyBinaryFormNeg {

    private String bin = "";
    private int dec;

    private int r0;
    private int r1;
    private int r2;
    private int r3;
    private int r4;
    private int r5;
    private int r6;
    private int r7;

    //Costructor
    MyBinaryFormNeg(int decimal){
        this.dec = decimal;
    }

    public void invert(){
        //if you add 128 to a negative number
        //it will become like a positive one
        //and you will be able to represent it
        //in two's component
        //like it should be
        this.dec += 128;
    }

    public void calculator(){
        r0 = dec % 2;
        dec /= 2;

        r1 = dec % 2;
        dec /= 2;

        r2 = dec % 2;
        dec /= 2;

        r3 = dec % 2;
        dec /= 2;

        r4 = dec % 2;
        dec /= 2;

        r5 = dec % 2;
        dec /= 2;

        r6 = dec % 2;
        dec /= 2;

        bin = "0b1" + r6 + r5 + r4 +
                "_" + r3 + r2 + r1 + r0;
    }


    public String getValue (){
        return bin;
    }


    public static void main(String [] args){
        int decimal;
        String binary;

        System.out.println("********************************");
        System.out.println("Insert a negative number  ");
        System.out.println("-1 >= number > -127");

        Scanner in = new Scanner(System.in);
        decimal = in.nextInt();
        in.close();

        MyBinaryFormNeg numero = new MyBinaryFormNeg(decimal);
        numero.invert();
        numero.calculator();
        binary = numero.getValue();

        System.out.println(binary);
    }
}