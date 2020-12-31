/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 1.2.2017
  *
  * classe MEMain - classe di prova della classe ME
  *
  * @see ME
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class MEMain // Classe di prova della mappa estesa
{
   public static void main(String[] args) throws java.io.IOException
   {
      ME<String,String> m = new ME<String, String>();
      java.util.Scanner in = new java.util.Scanner(new java.io.FileReader("airlines.txt"));
      while (in.hasNextLine())
      {
         java.util.Scanner tok = new java.util.Scanner(in.nextLine());
         m.put(tok.next(), tok.next());
      }
      
      System.out.println("SIZE = " + m.size());
      
      System.out.print("ENTRIES: ");
      Object[] keys = m.keySet();
      for (Object e: keys)
         System.out.print(e + "/" + m.get((String)e) + " ");
      System.out.println();
      
      System.out.print("VALUES: ");
      Object[] values = m.values(); 
      for (Object e: values)
         System.out.print(e + " ");
      System.out.println();
      
      System.out.print("VALUESET: ");
      values = m.valueSet(); 
      for (Object e: values)
         System.out.print(e + " ");
      System.out.println();    
      
      System.out.print("REMOVE: ");
      int i = 0;
      while (!m.isEmpty())
         System.out.print(keys[i] + "/" + m.remove((String)keys[i++]) + " ");
      System.out.println(); 
      
      System.out.println("SIZE = " + m.size());    
   }  
}
