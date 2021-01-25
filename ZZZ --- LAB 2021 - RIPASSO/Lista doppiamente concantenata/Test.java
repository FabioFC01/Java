public class Test {
   public static void main (String [] args) {
      PDC <Integer> lista = new PDC <Integer> ();

      lista.addFirst(1);
      lista.addLast(2);

      System.out.println(lista.getFirst());
      System.out.println(lista.getLast());

      System.out.println(lista.removeLast());
      System.out.println(lista.removeFirst());
      



   }
}
