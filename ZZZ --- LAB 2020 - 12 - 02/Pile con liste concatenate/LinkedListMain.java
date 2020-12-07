/**
  * LinkedListMain
  * Classe di prova delle classi LinkedListStack
  * @author Adriano Luchetta
  * @version 11-Dic-2013
  * @see LinkedListStack
  */
  import java.util.Scanner;
  public class LinkedListMain
  {
     public static void main(String[] args)
     {
        Scanner in = new Scanner(System.in);
  
        Stack s = new LinkedListStack();
  
        while (in.hasNextLine())
        {
           Scanner tok = new Scanner(in.nextLine());
           while (tok.hasNext())
           {
              String token = tok.next();
              s.push(token);
           }
           tok.close();
        }
  
        in.close();
  
        System.out.println("*** RITORNO righe = " + s.size() + " ***");
        while (!s.isEmpty())
           System.out.println((String)s.pop());  
     }
  }
  