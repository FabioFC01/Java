import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LeTester  {
   public static void main (String [] args)  throws IOException{
      //flussi
      FileReader fr = new FileReader ("Numbers.txt");
      Scanner in = new Scanner (fr);

      //creazione
      LE <String> list = new LE <String> ();

      while(in.hasNextLine()){
         Scanner riga = new Scanner (in.nextLine());
         while(riga.hasNext()){
            list.add(riga.next());
         }
      }

      //9 8 7 6 5 4 3 2 1 0 
      //0:9 1:8 2:7 3:6 4:5 5:4 6:3 7:2 8:1 9:0 

      //Size
      System.out.println("SIZE   :   " + list.size());

      //Elementi
      System.out.print("ELEMENTI   :   ");
      Iterator iter = list.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + " ");
      }
      System.out.println();

      //Rango elementi
      System.out.print("RANGO ELEMENTI    :   ");
      iter = list.iterator();
      int rango = 0;
      while (iter.hasNext()) {
         System.out.print((rango++) +  ":" + iter.next() + "   ");
      }
      System.out.println();

      //Elementi ordinati
      List <String> listaord = list.toSortedList();
      System.out.print("ELEMENTI ORDINATI   :   ");
      iter = listaord.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + "   ");
      }
      System.out.println();


      //Rango Elementi ordinati
      System.out.print("RANGO ELEMENTI ORDINATI   :   ");
      iter = listaord.iterator();
      rango = 0;
      while (iter.hasNext()) {
         System.out.print((rango++) +  ":" + iter.next() + "   ");
      }
      System.out.println();

      //remove
      System.out.print("REMOVE   :   ");
      iter = list.iterator();

      while (iter.hasNext()){
         System.out.print(iter.next() + " ");
         iter.remove();
      }



      System.out.println();

      System.out.println(list.size()); // 0
      System.out.println(list.isEmpty()); //true
   }
}
