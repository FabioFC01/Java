/**
  * Classe di prova della classe D
  *
  * @see D
  * @author A. Luchetta
  * @version 24-12-2018
  *
  */
import java.util.Scanner;
public class TestD
{
   public static void main(String[] args) throws java.io.IOException
   {
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      D<String, String> m = new D<String, String>();
      
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         m.insert(tk.next(), tk.next()); 
         tk.close();       
      }
      
      in.close();
         
      Comparable[] k = m.keys();   

      System.out.println("SIZE: " + m.size());
      
      System.out.println("FINDALL: ");
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = m.findAll((String)(k[i]));
         if (v.length > 0)
         {
            System.out.print(k[i] + " "); 
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();
         }             
      }
      
      System.out.println("\nREMOVEALL: ");
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = m.removeAll((String)(k[i]));
         if (v.length > 0)
         {
            System.out.print(k[i]+ " "); 
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();
         }     
      }      
         
      System.out.println("\nSIZE: " + m.size());                 
   }
}
