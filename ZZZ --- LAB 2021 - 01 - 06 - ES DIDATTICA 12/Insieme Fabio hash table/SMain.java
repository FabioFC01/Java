public class SMain {
   public static void main (String [] args) {
      //insieme 1
      SE<String> insieme1 = new SE();
      
      insieme1.add("Charlie");
      insieme1.add("Bravo");
      insieme1.add("Delta");

      //insieme 2
      SE <String> insieme2 = new SE();

      insieme2.add("Delta");
      insieme2.add("Charlie");
      insieme2.add("Bravo");
      insieme2.add("Alpha");

      System.out.println("SIZE S1/S2 : " + insieme1.size() + "/" + insieme2.size());

      //array per ordinare
      String [] i1o = new String [insieme1.size()];
      String [] i2o = new String [insieme2.size()];
      insieme1.toSortedArray(i1o);
      insieme2.toSortedArray(i2o);
      
      //stampa elementi normali
      Comparable [] i1 = new Comparable [insieme1.size()];
      insieme1.toArray(i1);
      Comparable [] i2 = new Comparable [insieme2.size()];
      insieme2.toArray(i2);
      System.out.print("INSIEME 1 :");
      for (Object a : i1) {
         System.out.print(a + " - ");
      }
      System.out.println();
      System.out.print("INSIEME 2 :");
      for (Object a : i2) {
         System.out.print(a + " - ");
      }
      System.out.println();

      //stampa ordinati
      System.out.print("INSIEME ORDINATO 1 :");
      for (String a : i1o) {
         System.out.print(a + " - ");
      }
      System.out.println();

      System.out.print("INSIEME ORDINATO 2 :");
      for (String a : i2o) {
         System.out.print(a + " - ");
      }
      System.out.println();


      //creazione insieme3 = insieme1
      SE <String> insieme3 = new SE<String>(insieme1);


      System.out.println("S1 precede S2 : " + insieme1.compareTo(insieme2)); //-1
      System.out.println("S1 è uguale a S3 : " + insieme1.compareTo(insieme3)); //0


      //insieme4
      Iterator <String> iter = insieme2.iterator();
      SE <String> insieme4 = insieme2.subset(iter);

      System.out.println("S2 è uguale a S4 : " + insieme2.compareTo(insieme4)); //0




      System.out.println("bella");
   }  
}