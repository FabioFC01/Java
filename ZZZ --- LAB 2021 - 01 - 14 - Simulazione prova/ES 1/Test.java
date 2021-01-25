public class Test {
   public static void main (String [] args){
      Q<String> ha = new Q<String> ();

      ha.enqueue("1");
      ha.dequeue();

      ha.enqueue("2");

      System.out.println(ha.dequeue());
      System.out.println(ha.size());
      System.out.println(ha.isEmpty());


      ha.enqueue("1");
      ha.enqueue("2");
      ha.enqueue("2");
      ha.enqueue("2");
      ha.enqueue("2");

      System.out.println(ha.dequeue());


      System.out.println(ha.size());

   }
}
