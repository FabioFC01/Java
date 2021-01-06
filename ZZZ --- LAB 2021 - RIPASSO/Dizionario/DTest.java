public class DTest {
   public static void main (String [] args){
      //creazione
      D<Integer, String> dizionario = new D();

      //aggiunte
      dizionario.insert(0, "A");
      dizionario.insert(0, "B");
      dizionario.insert(0, "C");
      dizionario.insert(1, "D");
      dizionario.insert(0, "D");
      dizionario.insert(1, "E");

      Object [] chiavi = dizionario.removeAll(1); 
      Object [] zio = dizionario.findAll(0);


      System.out.println("tua madre");
   }
}
