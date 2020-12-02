 /**
  * MyVectorTester
  *
  * Classe di prova della classe MyVector.
  * @see MyVector
  *
  * @version 9-Dec-2013
  * @author Adriano Luchetta
  */
  import java.util.Scanner;
  public class MyVectorTester
  {
     public static void main(String[] args)
     {
        Scanner in = new Scanner(System.in);
        MyVector v1 = new MyVector();
        MyVector v2 = new MyVector();
  
        // prova dei metodi add(Object) e add(int, Object)
         System.out.println(">>> PROVA DEI METODI ADD <<<");
         int k = 1;
        while (in.hasNext())
         {
           String s = in.next();
             Integer ik = new Integer(k++);
             System.out.println("v1.add(): aggiungo in coda " + s);
             System.out.println("v2.add(0,e): aggiungo in testa " + ik);		 
            v1.add(s);
             v2.add(0, ik);
        }
  
        // Prova dei metodi capacity e size
         System.out.println(">>> PROVA DEI METODI capacity E size <<<");
        System.out.println("Capacity = " + v1.capacity());
        System.out.println("Size = " + v1.size());
  
        // Prova del metodo elementAt
         System.out.println(">>> PROVA DEL METODO elementAT <<<");
        System.out.println("*** elementAt: Sequenza diretta ***"); 
        int size = v1.size();
        for (int i = 0; i < size; i++)
           System.out.println(v1.elementAt(i));
  
         System.out.println("*** elementAt: Sequenza inversa ***"); 
        for (int i = 0; i < size; i++)
           System.out.println(v2.elementAt(i));
           
        // Prova del metodo toArray
         System.out.println(">>> PROVA DEL METODO toArray <<<");
         System.out.println("*** toArray: Sequenza diretta ***"); 
        Object[] t = v1.toArray();
        for (int i = 0; i < t.length; i++)
           System.out.println(t[i]);
  
         System.out.println("*** toArray: Sequenza inversa ***"); 
        t = v2.toArray();
        for (int i = 0; i < t.length; i++)
           System.out.println(t[i]);
           
        // Prova del metodo toString
         System.out.println(">>> PROVA DEL METODO toString <<<");
         System.out.println("*** toString: Sequenza diretta ***");
        System.out.println(v1);
  
         System.out.println("*** toString: Sequenza inversa ***");
        System.out.println(v2);	  
  
        // Prova del metodo remove
         System.out.println(">>> PROVA DEL METODO remove <<<");
        System.out.println("*** remove: Sequenza diretta ***"); 
        while (!v1.isEmpty())
           System.out.println(v1.remove(0));
  
         System.out.println("*** remove: Sequenza inversa ***"); 
        while (!v2.isEmpty())
           System.out.println(v2.remove(0));
   
        // Prova dei metodi capacity e size
         System.out.println(">>> PROVA DEI METODI capacity E size <<<");	  	  
        System.out.println("Capacity = " + v1.capacity());
        System.out.println("Size = " + v1.size());		 
     }
  }
  