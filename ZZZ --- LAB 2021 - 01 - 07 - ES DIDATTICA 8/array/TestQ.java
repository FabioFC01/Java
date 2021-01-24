/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe TestQ
  * Classe di prova della classe Q
  *
  * @author A. Luchetta
  * @version 15-Feb-2015
  *
  */
public class TestQ
{
   public static void main(String[] args) throws java.io.IOException
   {
      // generazione di una coda per memorizzare String  
      Q<String> q = new Q<String>(); 
 
      // apertura del flusso di ingresso
      java.util.Scanner s = new java.util.Scanner(new java.io.FileReader(args[0]));
      
      // lettura da file e inserimento token nella coda
      while (s.hasNextLine()) 
      {  
         java.util.Scanner tok = new java.util.Scanner(s.nextLine());
         while (tok.hasNext())
            q.enqueue(tok.next());       // prova del metodo enqueue 
         tok.close();   
      }                                            

      // chiusura del flusso di ingresso
      s.close();
      
      // prova del metodo size
      System.out.println("***size = " + q.size());
                                
      // prova del metodo toArray
      System.out.print("***toArray = ");
      Object[] v = q.toArray();                         
      for (int i = 0; i < v.length;i++) 
         System.out.print(v[i] + " ");                
                           
      // prova dei metodo front e queue
      System.out.print("\n***front + dequeue = "); 
      while (!q.isEmpty())
         System.out.print(q.front() + "/" + q.dequeue() + " ");
      
      // prova del metodo size
      System.out.println("\n***size = " + q.size());
   }   
}  
