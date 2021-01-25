import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//COCIANCICH FABIO - 2016268
public class DEMain {
   public static void main (String [] args) throws IOException{
      FileReader re = new FileReader(args[0]);
      Scanner in = new Scanner (re);

      String chiave = "";
      String valore = "";

      String elencoChiavi = "";
      String chiavePrecedente = "";

      //creazione multimappa
      DE <String, String> mappa = new DE<String, String> ();

      while (in.hasNextLine()) {
         Scanner riga = new Scanner (in.nextLine()).useDelimiter("[#]+");
         chiave = riga.next();
         valore = riga.next();
         elencoChiavi += chiave +"#";
         mappa.insert(chiave, valore);         
      }

      Object [] chiaviUnivoche = mappa.keySet();
      in.close();
      re.close();

      //size
      System.out.println("SIZE  : " + mappa.size());
      System.out.println();
      System.out.println();

      //findall
      System.out.println("FIND ALL");

      for (Object e : chiaviUnivoche) {
         Object [] g = mappa.findAll((String)e);
         System.out.print((String)e + "  -  ");
         for (Object i : g) {
            System.out.print(i + "  ");
         } 
         System.out.println();
       }

      System.out.println();
      System.out.println();
      System.out.println();

      //value set
      System.out.println("VALUE SET");

      Object [] val = mappa.valueSet(); //array ordinato
      for (Object e : val) {
         System.out.print(e + "  -  ");
      }
      System.out.println();

      Object [] chiavi = mappa.keys();

      System.out.println();
      System.out.println();


      //remove all
      System.out.println("REMOVE ALL");
      for (Object o : chiaviUnivoche) {
         Object [] n = mappa.removeAll((String)o);
         System.out.print((String)o + "  -  ");
         for (Object i : n) {
            System.out.print(i + "  ");
         } 
         System.out.println();
      }

      System.out.println();
      System.out.println();

      //isEmpty
      System.out.println(mappa.isEmpty());






   }
}