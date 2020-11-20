import java.util.Random;

public class IntegerArraySorter {
    public static void main (String [] args){
        int [] value = new int [15];
        value = randomIntegerArray(value.length);
        sort(value);

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
        for(int i = 0; i < values.length; i++){
            System.out.print(values[i] + "   ");
        }
        System.out.println();

        return values;
    }


            /*
        genera un array di numeri interi di dimensione specificata length e con valori nell'intervallo [0, length - 1] 
        disposti in ordine crescente. Ciascun numero e' presenta una sola volta.
        */
    private static int[] sortedIntegerArray(int length) {
        //creazione array lungo n
        int [] values = new int [length];
        //riempimento array
        for(int i = 0; i < values.length; i++){
            values [i] = i;
        }
        return values;
    }

    private static void sort(int[] a) {
        //usiamo metodo merge sort
        Mergesort(a);
        
        //stampa
        System.out.println("--------------------------");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }

    private static void Mergesort (int[] a){
        //caso base
        if(a.length < 2){
            return;
        }
        int mid = a.length/2;
        int [] left = new int [mid];
        int [] right = new int [a.length - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);

        Mergesort(left);
        Mergesort(right);

        Merge (a, left, right);


    }    

    private static void Merge (int[] a, int [] b , int [] c) {
        int ia = 0;
        int ib = 0;
        int ic = 0;

        while (ib < b.length && ic < c.length){
            if (b[ib] < c[ic]){
                a[ia++] = b [ib++];
            }
            else{
                a[ia++] = c [ic++];
            }
        }
        //un array non ha più elementi
        while (ib < b.length){
            a[ia++] = b[ib++];
        }
        while (ic < c.length){
            a[ia++] = c[ic++];
        }
    }

}