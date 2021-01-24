/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Classe MainEQ
  * Classe di prova della classe EQ
  *
  * @typeparam T tipo parametrico degli e lementi della classe
  *
  * @author A. Luchetta
  * @version 15-Feb-2015
  *
  */
public class MainEQ
{
   public static void main(String[] args) throws java.io.IOException
   {
      // costante
      final int DEST_QUEUES_NO = 3;

      // generazione della coda di String
      EQ<String> q = new EQ<String>(); 
 
      // apertura del flusso d'ingresso
      java.util.Scanner s = new java.util.Scanner(new java.io.FileReader(args[0])); 
      
      // lettura da file e inserimento dei token nella coda
      while (s.hasNextLine())                  
      {  
         java.util.Scanner tok = new java.util.Scanner(s.nextLine());
         while (tok.hasNext())
            q.enqueue(tok.next());             // prova del metodo enqueue 
         tok.close();   
      }                                             

      // chiusura del flusso d'ingresso
      s.close();
         
      // prova del metodo toSortedArray
      System.out.print("***toSortedArray = ");        
      Object[] v = q.toSortedArray();                         
      for (int i = 0; i < v.length;i++) 
         System.out.print(v[i] + " "); 
         
      // prova del metodo getOnlyUniqueElements   
      System.out.print("\n***getOnlyUniqueElements = ");   
      v = q.getOnlyUniqueElements();                        
      for (int i = 0; i < v.length; i++) 
         System.out.print(v[i] + " ");
      
     // prova del metodo split
     System.out.print("\n***split =");                                     
     EQ[] qs = q.split(DEST_QUEUES_NO);
     for (int i = 0; i < qs.length; i++)
     {  v = qs[i].toArray();
        for (int j = 0; j < v.length; j++)
           System.out.print(" " + v[j]);
        System.out.print(" |");
     } 
     System.out.println();                       
   }   
}  
