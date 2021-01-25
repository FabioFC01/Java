import java.util.Scanner;

public class T {
   public static void main (String [] args) {
      double a = -2.95;
      char spazio = ' ';
      int spazio_ASCII = spazio;

      int binario_2 = 0B10;
      int esadecimale_15 = 0XF;


      System.out.println(Math.round(a));
      System.out.println(spazio);         // " "
      System.out.println(spazio_ASCII);   // 32

      System.out.println();

      System.out.println(binario_2);
      System.out.println(esadecimale_15);


      Scanner in = new Scanner (System.in).useDelimiter("[^a-zA-z]+");



   }
}