import java.util.Scanner;
import java.util.Locale;

public class Cerchio {
    public static void main (String[] args){
        final String END_OF_PROGRAM = "Q";
      
      System.out.println( "\n************************************\n"   
                          + "*** Q PER TERMINARE IL PROGRAMMA ***\n"
                          + "************************************\n"  );

      System.out.println(   "****************************************************\n"
                          + "*** Usare il punto come carattere di separazione ***\n"
                          + "*** fra parti intera e frazionaria di numeri in  ***\n"
                          + "*** virgola mobile.                              ***\n"
                          + "****************************************************");

      // apertura flusso d'ingresso
      Scanner in = new Scanner(System.in);
      String s = "";
            
      double x;
      double y;         
      double r;
      double x1;
      double y1;         
      double r1;
      
      while (true)
      {
         do
         {
            System.out.print("Introdurre O(x1,y1) e r1: ");
            s = in.nextLine();
            if (s.equalsIgnoreCase(END_OF_PROGRAM))
            {
               in.close();
               return;
            }
               
            Scanner p = new Scanner(s);
            p.useLocale(Locale.US);   
            x = p.nextDouble();
            y = p.nextDouble();         
            r = p.nextDouble();
            p.close();
         } while (r < 0);
         
         MyCircle c1 = new MyCircle(x, y, r); 
         
        do
         {
            System.out.print("Introdurre O(x2,y2) e r2: ");
            s = in.nextLine();
            if (s.equalsIgnoreCase(END_OF_PROGRAM))
            {
               in.close();
               return;
            }
               
            Scanner p = new Scanner(s);
            p.useLocale(Locale.US);    
            x1 = p.nextDouble();
            y1 = p.nextDouble();         
            r1 = p.nextDouble();
            p.close();
         } while (r < 0);
         
         MyCircle c2 = new MyCircle(x1, y1, r1);
         
         if (c1.isCoincident​(c2))
            System.out.println(c1 + " " + c2 + " coincidono");
         else if (c1.isEncircled​(c2))
             System.out.println(c1 + " e' interno a " + c2);
         else if (c2.isEncircled​(c1))
            System.out.println(c2 + " e' interno a " + c1);
         else if (c1.isSecant​(c2))
            System.out.println(c1 + " " + c2 + " sono secanti");   
         else if (c1.isExternal​(c2))
            System.out.println(c1 + " " + c1 +" sono esterni");               
         else if(c1.isTangential​(c2))
            System.out.println(c1 + " " + c2 + " sono tangenti"); 
         else
            System.out.println("ERRORE");   
      }  
    }
}