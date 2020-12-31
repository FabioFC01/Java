import java.util.Scanner;
import java.io.FileReader;
import java.io.FileReader;
import java.io.IOException;

public class FC {
    public static void main (String [] args) throws IOException{ //attento alla eccezione

        Scanner tok = new Scanner(new FileReader("animali.txt")).useDelimiter("[^a-zA-Z]+");
        MyMap  mappa = new MyMap ();

        String temp = "";

        while(tok.hasNext()){
            temp = tok.next();

            if (mappa.get(temp) != null){
                int contatore = (int) mappa.get(temp);
                contatore++;
                mappa.put(temp, contatore);
            }
            else{
                mappa.put(temp , 1);
            }
        }

        Object [] robe = mappa.keys();

        for (Object i : robe){
            System.out.println(i + "  " + mappa.get(i));
        }
    }
}
/***
 * il trucco in questo programma di merda è che la chiave è la parola e 
 * il valore intero è il numero di volte che appare
 */