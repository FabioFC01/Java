import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class ArQueueMain {
    public static void main (String [] args)  throws IOException {
        if(args.length < 1){
            System.out.println("Inserisci nome files di output coda e output pila");
        }
      // apertura del file - eseguita con due enunciati
      FileReader fr = new FileReader("Itinerario.txt"); // apertura del file in lettura
      Scanner in = new Scanner(fr);            // creazione dell'esemplare Scanner
      PrintWriter outCoda = new PrintWriter(args[0]); //OUTPUT file coda
      PrintWriter outPila = new PrintWriter(args[1]); //OUTPUT file coda

      //creazione coda e pila
      ArQueue coda = new ArQueue();
      ArStack pila = new ArStack();

      String temp = "";

      while(in.hasNextLine()){
            temp = in.next();
            coda.enqueue(temp);
            pila.push(temp);
      }

      in.close();

      System.out.println();
      System.out.println();


      System.out.println("OUTPUT CODA");
      while(!coda.isEmpty()){
          temp = (String)coda.dequeue();
          System.out.println(temp);
          outCoda.println(temp);
      }

      outCoda.close();

      System.out.println("OUTPUT PILA");
      while(!pila.isEmpty()){
            temp = (String)pila.pop();
            System.out.println(temp);
            outPila.println(temp);
      }

      outPila.close();



    }
    
}