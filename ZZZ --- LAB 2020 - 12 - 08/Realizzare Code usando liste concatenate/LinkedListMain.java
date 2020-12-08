import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LinkedListMain {
    public static void main (String [] args) throws IOException {
        //verifica della presenza del nome del file nella  riga di comando
        if (args.length < 2) {
            System.out.println("uso: $java LinkedListMain outputCoda outputPila");
            return;
        }

        // apertura del file in lettura in un solo enunciato
        Scanner in = new Scanner(new FileReader("Palazzeschi.txt"));

        // apertura del file in scrittura
        PrintWriter outCoda = new PrintWriter(args[0]);
        PrintWriter outPila = new PrintWriter(args[1]);

        //creazione pila,coda e stringa temp
        String temp = "";
        LinkedLinkQueue coda = new LinkedLinkQueue();
        LinkedListStack pila = new LinkedListStack();

        //lettura
        while(in.hasNextLine()){
            temp = in.nextLine();
            coda.enqueue(temp);
            pila.push(temp);
        }

        //scrittura coda
        while(!coda.isEmpty()){
            outCoda.println((String)coda.dequeue());
        }

        outCoda.close();

        //scrittura pila
        while(!pila.isEmpty()){
            outPila.println((String)pila.pop());
        }

        outPila.close();

    }    
}