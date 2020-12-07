/**
  * ArMain
  * Classe di prova della classe ArStack
  * @author Adriano Luchetta
  * @version 11-Dic-2013
  * @see ArStack
  */
  import java.util.Scanner;
  public class ArMain
  {
     public static void main(String[] args)
     {    
        System.out.println("Pila con array"); 
        System.out.println("Premi CTRL + C per terminare la lista"); 
        Scanner in = new Scanner(System.in);
  
        Stack s = new ArStack();
        String temp;
  
        while (in.hasNextLine())
        {
           Scanner tok = new Scanner(in.nextLine());
           while (tok.hasNext())
           {
              String token = tok.next();
              s.push(token);
           }
           tok.close();
           /*temp = in.nextLine();
           s.push(temp);*/
        }
  
        in.close();    
  
        System.out.println("*** RITORNO stazioni = " + s.size() + " ***");
        while (!s.isEmpty())
           System.out.println((String)s.pop());
     }
  }
  