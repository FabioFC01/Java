public class ArraySetMain {
   public static void main (String [] args){
      //creazione
      ArraySet <String> ar = new ArraySet <String> ();

      ar.add("A");
      ar.add("A");
      ar.add("B");
      ar.add("B");
      ar.add("A");
      ar.add("D");
      ar.add("C");
      ar.add("A");
      // A B D C

      Object [] robe = ar.toArray(); //yes
      String [] ordinato = new String [ar.size()];
      int boh = ar.toSortedArray(ordinato);

      System.out.println("ciaone");

   }
}
