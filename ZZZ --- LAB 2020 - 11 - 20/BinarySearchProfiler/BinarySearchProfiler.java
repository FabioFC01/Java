import java.util.Random;
import java.util.Scanner;

public class BinarySearchProfiler {
    public static void main (String [] args){

        Scanner in = new Scanner (System.in);
        int length = in.nextInt();
        in.close();

        int [] values = sortedIntegerArray(length);
        toString(values);

        int [] ricerche = randomIntegerArray(length);
        int sum = 0;
        int temp = 0;
        int min = Integer.MAX_VALUE;
        int max = -1;
        //chiamata per n volte ricerca lineare
        for (int i = 0; i < length; i++){
            temp = linearSearch(values, ricerche[i]);
            sum += temp;
            if(temp > max){
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("RICERCA LINEARE" );
        System.out.println("Numero minimo ricerche  " + min);
        System.out.println("Numero massimo ricerche  " + max);
        System.out.println("Numero totale ricerche  " + sum);
        System.out.println("Numero medio ricerche  " + ((double)sum/length));
        System.out.println("Numero teorico medio ricerche  " + ((double)1+length)/2);

        //chiamata per n volte la ricerca binaria
        sum = 0;
        temp = 0;
        min = Integer.MAX_VALUE;
        max = -1;

        for (int i = 0; i < length; i++){
            temp = binarySearch(values, ricerche[i]);
            //System.out.print(temp + "   ");
            sum += temp;
            if(temp > max){
                max = temp;
            }
            if (temp < min) {
                min = temp;
            }
        }

        System.out.println();
        System.out.println("----------------------------------");
        System.out.println("RICERCA BINARIA" );
        System.out.println("Numero minimo ricerche  " + min);
        System.out.println("Numero massimo ricerche  " + max);
        System.out.println("Numero totale ricerche  " + sum);
        System.out.println("Numero medio ricerche  " + ((double)sum/length));
        System.out.println("Numero teorico medio ricerche  " + ((double)(Math.log10(length))/(Math.log10(2))));
    }

    /*
    genera un array di numeri interi di dimensione specificata length e con numeri nell'intervallo [0, length - 1] disposti in sequenza casuale.
    Ciascun numero e' presenta una sola volta.
    */
    private static int[] randomIntegerArray(int length) {
        //creazione array lungo n
        int [] values = sortedIntegerArray(length);
        //apri random
        Random rand = new Random();
        int tempValue = -1;
        int tempIndex = -1;
        int tempIndex2 = -1;
        //disordina array
        for (int j = 0; j < (2 * values.length); j++){
            tempIndex = rand.nextInt(values.length);
            tempIndex2 = rand.nextInt(values.length);
            //valore affidato alla variabile temp
            //Scambio
            tempValue = values [tempIndex];
            values[tempIndex] = values [tempIndex2];
            values[tempIndex2] = tempValue;
        }
        System.out.println();

        return values;
    }

    private static int[] sortedIntegerArray(int length) {
        //creazione array lungo n
        int [] values = new int [length];
        //riempimento array
        for(int i = 0; i < values.length; i++){
            values [i] = i;
        }
        return values;
    }

    //ricerca lineare
    private static int linearSearch(int[] a, int t) {
        //metodo vero
        for (int i = 0; i < a.length; i++){
            if(a[i] == t) {
                return (i+1);
            }
        }

        return -1;
    }

    public static void toString (int []a) {
        System.out.println("-------------------");
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }

    
    //ricerca binaria
    private static int binarySearch(int[] a,int cercato) {
        int centro;
        int estremoSx = 0;
        int estremoDx = a.length-1;
        int contatore = 0;
        while(estremoSx <= estremoDx){
            contatore++;
            centro = (estremoDx + estremoSx)/2;
            if(a[centro] == cercato){
                return (contatore);
            }
            if (a[centro] < cercato){
                estremoSx = centro+1;
            }
            else{
                estremoDx = centro-1;
            }
        }
        return -1;
    }

}