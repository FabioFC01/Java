import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
   Classe che illustra la lettura per riga di un file di testo
*/
public class MyFilePrinter1
{
   public static void main(String[] args) throws IOException // notare la clausola throws
   {
      //verifica della presenza del nome del file nella  riga di comando
      if (args.length < 1)
      {
         System.out.println("uso: $ java MyFilePrinter1 fileName");
         return;
      }
     
      // apertura del file - eseguita con due enunciati
      FileReader fr = new FileReader(args[0]); // apertura del file in lettura
      Scanner in = new Scanner(fr);            // creazione dell'esemplare Scanner
 
     //lettura per riga e invio a standard output
     while (in.hasNextLine())
        System.out.println(in.nextLine());

     //chiusura del flusso e del file
     in.close();
   }
}

/*
java MyFilePrinter1 Lol.txt
CIAONE
bella zio
bro      
uello  
*/