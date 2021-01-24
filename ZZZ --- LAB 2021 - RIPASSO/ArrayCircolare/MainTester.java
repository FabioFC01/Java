public class MainTester {
   public static void main (String [] args){
      ArrayCircolare <String> ar = new ArrayCircolare <String> ();
      ar.addLast("0");
      ar.addLast("1");
      ar.addLast("2");
      ar.addLast("3");
      ar.addLast("4");

      ar.addFirst("-1");
      ar.addFirst("-2");
     

      ar.remFirst();
     

      ar.remLast();
      ar.remLast();

      

      System.out.println(ar.size());
      System.out.print("lol");

      //mi pare funzioni tutto
   }
}
