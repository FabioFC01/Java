/**
  * FONDAMENTI DI INFORMATICA - GRUPPO 4
  * Prova di Programmazione del 29-01-2020
  *
  * Classe di Prova 
  *
  * @See S
  */
public class STester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      // prova dei costruttori e del metodo add
      S<String> s1 = new S<String>(STR1);
      S<String> s2 = new S<String>(STR2);
      S<String> s3 = new S<String>(s1);
      // prova del metodo size            
      System.out.println("SIZE S1/S2 = " +s1.size() + "/" +s2.size());
      // prova dei metodi iterator, hasNext e next            
      System.out.print("ELEMENTS S1 = ");
      Iterator<String> iter = s1.iterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println(); 
      System.out.print("ELEMENTS S2 = ");
      iter = s2.iterator();
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println(); 
      // prova del metodo toSortedArray
      System.out.print("SORTED ELEMENTS S1 = ");
      String[] st = new String[s1.size()]; 
      s1.toSortedArray(st);   
      for (String p : st) System.out.print(p + " ");
      System.out.println();     
      System.out.print("SORTED ELEMENTS S2 = ");
      st = new String[s2.size()]; 
      s2.toSortedArray(st); 
      for (String p : st) System.out.print(p + " ");
      System.out.println();   
      // prova del metodo remove      
      System.out.print("REMOVED = ");
      iter = s2.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + " ");         
         iter.remove();
      }        
      System.out.println();          
      System.out.println("SIZE: " + s2.size());
      
      // prova del metodo min      
      System.out.println("MIN S1: " + s1.min());      
   }
}
