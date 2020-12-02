/**
  * DoublyLinkedListTester: laboratorio 9
  * Classe di prova della classe DoublyLinkedList
  * Riceve come argomento da riga di comando un numero intero n > 0.
  * Esegue le seguenti operazioni per prova su una struttura dati di tipo DoublyLinkedList
  * - prova del metodo addFirst(): inserimento di n elementi di tipo new Integer(k), 0 <= k < n
  * - prova del metodo size(): invio a standard output del numero di elementi nel contenitore
  * - prova del metodo getFirst(): invio a standard output del primo elemento
  * - prova del metodo getLast(): invio a standard output del primo elemento
  * - prova del metodo removeFirst(): estrazione di tutti gli elementi
  * - prova del metodo addLast(): inserimento di n elementi di tipo new Integer(n-k), 0 <= k < n
  * - prova del metodo size(): invio a standard output del numero di elementi nel contenitore
  * - prova del metodo removeLast(): estrazione di tutti gli elementi
  * @author A. Luchetta
  * @version 24-Nov-2006
  * @see DoublyLinkedList
*/
public class DoublyLinkedListTester
{
   public static void main(String[] args)
   {
      // precondizioni
      if (args.length < 1)
      {
         System.out.println("uso: $java ArrayVectorTester <integer>");
         return;
      }

      int n = 0;
      try
      {
         n = Integer.parseInt(args[0]);
      }
      catch (NumberFormatException e)
      {
         System.out.println("uso: $java ArrayVectorTester <integer>");
         return;
      }
      
      if ( n < 1)
      {
         System.out.println("n = " + n + " valore non ammesso: valori ammessi n > 1");
         return;
      }

      DoublyLinkedList v = new DoublyLinkedList();

      //Inserimento dati: prova del metodo addFirst()
      for (int i = 0; i < n; i++)
         v.addFirst(new Integer(i));

      // prova del metodo size()
      System.out.println("\n*** addFirst() e size(): DATI INSERITI PARI A " + v.size() + "***");

      // prova del metodo getFirst()
      System.out.println("\n*** getFirst(): DATO IN TESTA " + v.getFirst() + "***");
      
      // prova del metodo getLast()
      System.out.println("\n*** getLast(): DATO IN CODA " + v.getLast() + "***");

      // prova del metodo removeFirst()
      System.out.println("\n*** DATI INSERITI ***");
      while (!v.isEmpty())
         System.out.println("removeFirst(): " + v.removeFirst());
         
      // prova del metodo size()
      System.out.println("\n*** removeFirst() e size(): DATI contenuti A " + v.size() + "***");

      //Inserimento dati: prova del metodo addLast()
      for (int i = 0; i < n; i++)
         v.addLast(new Integer( n - i));

      // prova del metodo size()
      System.out.println("\n*** addLast() e size(): DATI INSERITI PARI A " + v.size() + "***");

      // prova del metodo removeLast()
      System.out.println("\n*** DATI ESTRATTI ***");
      while (!v.isEmpty())
         System.out.println("removeLast(): " + v.removeLast());

      // prova del metodo size()
      System.out.println("\n*** removeLast() e size(): DATI INSERITI PARI A " + v.size() + "***");

   }
}
