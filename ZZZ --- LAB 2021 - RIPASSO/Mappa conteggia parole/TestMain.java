import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestMain {
   public static void main (String [] args) throws FileNotFoundException, IOException{
      //costruzione mappa hashtable
      M <String, Integer> mappa = new M <String, Integer> ();

      //facciamo partire scanner e filereader
      FileReader n = new FileReader("k.txt");
      Scanner in = new Scanner (n);

      //scannerizziamo tutto
      while (in.hasNextLine()) {
         Scanner riga = new Scanner (in.next()).useDelimiter("[.,;:-_'’»«<>]+");
         while(riga.hasNext()) {
            //analisi parole singole
            String word = riga.next().toLowerCase(); //parola in minuscolo

            //otteniamo il numero di apparizioni della parola
            Integer contatore = mappa.get(word);

            if (contatore == null) {
               mappa.put(word, 1);
            }
            else {
               mappa.put(word, contatore + 1);
            }
         }
      }

      //scriviamo su file che è meglio
      FileWriter wr = new FileWriter("exit.txt");
      PrintWriter wri = new PrintWriter(wr);

      while (!mappa.isEmpty()) {
         String [] result = mappa.max();
         wri.println(result[0]);
         System.out.println(result[0]);
         mappa.remove(result[1]);
      }



      //fine
      System.out.println("yooo");

   }
}
