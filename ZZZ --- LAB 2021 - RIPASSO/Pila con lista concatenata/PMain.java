public class PMain {
   public static void main (String [] args) {
      P <Integer> pila = new P <Integer> ();

      pila.push(1);
      pila.push(2);
      pila.push(3);
      pila.push(4);
      pila.push(5);
      pila.push(6);
      pila.push(7);
      pila.push(8);

      System.out.println(pila.pop()); //8
      System.out.println(pila.size()); //7

      //---

      System.out.println(pila.pop()); //7
      System.out.println(pila.pop()); //6
      System.out.println(pila.pop()); //5
      System.out.println(pila.pop()); //4
      System.out.println(pila.pop()); //3
      System.out.println(pila.pop()); //2
      System.out.println(pila.pop()); //1
      System.out.println(pila.pop()); //error



      
   }
}
