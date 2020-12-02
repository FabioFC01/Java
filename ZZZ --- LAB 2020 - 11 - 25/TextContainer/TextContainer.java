//import java.util.Scanner;
import java.util.NoSuchElementException;

public class TextContainer implements Container {
    static final int INITIAL_SIZE = 1;
    private String [] parole;
    private int arraySize;

    //first costructor
    public TextContainer () {
        makeEmpty();
    }

    //second costructor
    public TextContainer(java.util.Scanner reader, java.lang.String delimiter) {
        this();

        reader.useDelimiter("[" + delimiter + "]+");
        while(reader.hasNext()){
            this.add(reader.next());
        }

    }

    //metodo add
    public void add (String word) {
        //ridimensionamento array
        if (arraySize >= parole.length){
            parole = resize(parole, 2 * parole.length);
        }

        //aggiunta
        parole[arraySize] = word;
        arraySize++;
    }

    //metodo isEmpty
    public boolean isEmpty () {
        return arraySize == 0;
    }

    //metodo makeEmpty
    public void makeEmpty () {
        parole = new String [INITIAL_SIZE];
        arraySize = 0;
    }

    //metodo size
    public int size () {
        return arraySize;
    }

    //metodo removeLast
    public String removeLast ()  throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        String temp = parole[arraySize - 1];
        parole [arraySize - 1] = null;  //garbage collector
        arraySize--;
        return temp;
    }

    //metodo sort
    public void sort () {
        //ridimensionamento
        parole = resize(parole, arraySize);

        //ordinamento
        mergeSort(parole);
    }

    //metodo mergeSort
    private void mergeSort (String [] a) {
        //caso base
        if(a.length < 2){
            return;
        }

        //dividiamo circa a metà
        int mid = a.length/2;

        //creazione sottostringhe
        String [] left = new String [mid];
        String [] right = new String [a.length - mid];

        //copia array
        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, a.length - mid);

        //passi ricorsivi
        mergeSort(left);
        mergeSort(right);

        //fusione
        merge (a, left , right);
    }

    //metodo merge
    private void merge (String []a , String [] left, String [] right) {
        int ia = 0;
        int iLeft = 0;
        int iRight = 0;

        //finchè i due array non sono arrivati in fondo
        while (iLeft < left.length && iRight < right.length) {
            //se left precede right
            if (left [iLeft].compareTo(right[iRight]) < 0 ){
                a[ia++] = left[iLeft++];
            }
            else {
                a[ia++] = right [iRight++];
            }
        }

        //uno dei due array è arrivato in fondo
        while(iLeft < left.length) {
            a[ia++] = left[iLeft++];
        }
        while(iRight < right.length) {
            a[ia++] = right[iRight++];
        }
    }

    private String [] resize (String [] oldArray, int newLength) {
        int minLength = oldArray.length < newLength ? oldArray.length : newLength;
        String[] newAr = new String[newLength];
     
        for (int i = 0; i < minLength; i++)
            newAr[i] = oldArray[i];
       
        return newAr;

    }
}