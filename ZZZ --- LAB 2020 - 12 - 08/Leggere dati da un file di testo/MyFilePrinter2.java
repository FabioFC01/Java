import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
   Classe che illustra la lettura per riga di un file di testo
*/
public class MyFilePrinter2
{
   public static void main(String[] args) throws IOException  // notare la clausola throws
   {
      //verifica della presenza del nome del file nella  riga di comando
      if (args.length < 1)
      {
         System.out.println("uso: $ java MyFilePrinter2 fileName");
         return;
      }
      
      // apertura del file  e crezione di esemplare di scanner
      // eseguite in un unico enunciato
      Scanner in = new Scanner(new FileReader(args[0]));
 
     //lettura per riga e invio a standard output
     while (in.hasNextLine())
        System.out.println(in.nextLine());

     in.close();
   }
}


/*
java MyFilePrinter2 Lol.txt
CIAONE
bella zio
bro      
uello   
*/