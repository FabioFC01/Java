/**
  * Classe di prova della classe ESD
  *
  * @see ESD
  * @author A. Luchetta
  * @version 27-12-2020
  *
  */
import java.util.Scanner;
public class ProvaESD
{
   public static void main(String[] args) throws java.io.IOException
   {
      Scanner in = new Scanner(new java.io.FileReader(args[0]));
      
      ESD<String, String> m = new ESD<String, String>();
      
      while (in.hasNextLine())
      {
         Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
         m.insert(tk.next(), tk.next()); 
         tk.close();       
      }
      
      in.close();
         
      Comparable[] k = m.keySet();   

      System.out.println("SIZE: " + m.size());
      
      System.out.println("\nFINDALL: ");
      for (int i = 0; i < k.length; i++)
      {
         if (m.contains((String)k[i]))
         {
            System.out.print(k[i]); 
            Object[] v = m.findAll((String)(k[i]));
            for (int j = 0; j < v.length; j++)
               System.out.print(" + " + v[j]);  
            System.out.println();              
         }
      }
      
      Comparable[] a = m.valueSet();
      System.out.println("\nVALUESET: "); 
      for (int i = 0; i < a.length; i++)
         System.out.print(a[i] + " ");  
      System.out.println();      
      
      System.out.println("\nREMOVEALL: ");
      for (int i = 0; i < k.length; i++)
      {
         System.out.print(k[i]); 
         Object[] v = m.removeAll((String)(k[i]));
         for (int j = 0; j < v.length; j++)
            System.out.print(" + " + v[j]); 
         System.out.println();    
      }      
         
      System.out.println("\nSIZE: " + m.size());                 
   }
}
