/**
  * FONDAMENTI DI INFORMATICA - GRUPPO 4
  * Prova di Programmazione del 29-01-2020
  *
  * Classe di Prova 
  *
  * @see SE
  * @see S
  */
public class SETester
{
   public static void main(String[] args)
   {
      final String[] STR1 = {"Charlie", "Bravo", "Alpha", "Charlie"};
      final String[] STR2 = {"Delta", "Charlie", "Bravo", "Alpha"};
      // prova dei costruttori e del metodo add
      SE<String> s1 = new SE<String>(STR1);
      SE<String> s2 = new SE<String>(STR2);
      SE<String> s3 = new SE<String>(s1);
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
    
      // prova del metodo compareTo      
      if (s1.compareTo(s2) < 0) System.out.println("S1 PRECEDES S2");
      else if (s1.compareTo(s2) > 0) System.out.println("S1 FOLLOWS S2"); 
      else System.out.println("S1 EQUALS S2");                  
      if (s1.compareTo(s3) < 0) System.out.println("S1 PRECEDES S3");
      else if (s3.compareTo(s2) > 0) System.out.println("S1 FOLLOWS S3"); 
      else System.out.println("S1 EQUALS S3");    
      // prova del metodo subset                 
      System.out.print("SUBSET S4 ");
      iter = s2.iterator();
      System.out.print("MISSING " + iter.next() + ": ");
      SE<String> s4 = s2.subset(iter);
      iter = s4.iterator();         
      while (iter.hasNext()) System.out.print(iter.next() + " ");
      System.out.println();
      // prova del metodo remove      
      System.out.print("REMOVED = ");
      iter = s2.iterator();
      while (iter.hasNext()) {
         System.out.print(iter.next() + " ");         
         iter.remove();
      }                 
      System.out.println("\nSIZE: " + s2.size());  
      // prova del metodo min      
      System.out.println("MIN S1: " + s1.min());
   }
}
