public class CMain {
   public static void main (String [] args) {
      C <Integer> coda = new C <Integer> ();

      coda.enqueue(1);
      coda.enqueue(2);
      coda.enqueue(3);
      coda.enqueue(4);
      coda.enqueue(5);
      coda.enqueue(6);
      coda.enqueue(7);
      coda.enqueue(8);
      coda.enqueue(9);
      coda.enqueue(10);
      coda.enqueue(11);

      
      System.out.println(coda.front());

      System.out.println(coda.size());
      System.out.println(coda.isEmpty());

      System.out.println();

      while (!coda.isEmpty()) {
         System.out.println(coda.dequeue());
      }

      //funzica

   }
}
