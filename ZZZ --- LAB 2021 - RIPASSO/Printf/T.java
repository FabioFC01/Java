public class T {
   public static void main (String [] args) {
      for (int i = 0; i < 1002; i++) {
         System.out.printf("%7.2f", (double)i); // aggiunti spazi a sinistra --- es 1001.00
         System.out.println();
      }
   }
}