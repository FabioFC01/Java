import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
/**
   Classe che illustra la lettura e scrittura per riga di file di testo
*/
public class MyFileWriter
{
   public static void main(String[] args) throws IOException
   {
      //verifica della presenza del nome del file nella  riga di comando
      if (args.length < 2)
      {
         System.out.println("uso: $java MyFileWriter fileName1 fileName2");
         return;
      }
     
      // apertura del file in lettura in un solo enunciato
      Scanner in = new Scanner(new FileReader(args[0]));

      // apertura del file in scrittura
      PrintWriter out = new PrintWriter(args[1]);
 
     //lettura e scrittura per riga
     while (in.hasNextLine())
        out.println(in.nextLine());

     //chiusura del file in lettura
     in.close();

     //chiusura del file in scrittura
     out.close();
   }
}
