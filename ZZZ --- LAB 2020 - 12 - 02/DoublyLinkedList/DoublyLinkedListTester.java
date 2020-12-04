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
         v.addLast(new Integer (n-i));

      // prova del metodo size()
      System.out.println("\n*** addLast() e size(): DATI INSERITI PARI A " + v.size() + "***");

      // prova del metodo removeLast()
      System.out.println("\n*** DATI ESTRATTI ***");
      while (!v.isEmpty())
         System.out.println("removeLast(): " + v.removeLast());

      // prova del metodo size()
      System.out.println("\n*** removeLast() e size(): DATI INSERITI PARI A " + v.size() + "***");
      


      //qui comincio io
      System.out.println();
      System.out.println();

      DoublyLinkedList vi = new DoublyLinkedList();
      vi.addLast("Ciao");
      vi.addLast("Tua madre");
      vi.addLast("É");
      vi.addLast("Super simpatica");
      vi.addFirst("Messaggio al primo posto");
      vi.addFirst("No scherzo sono io al primo posto");

      System.out.println(vi.size());     //6 --- YES
      System.out.println(vi.isEmpty()); //false
      System.out.println(vi.getFirst());    //"No scherzo sono io al primo posto"
      //fin qui funziona

      System.out.println(vi.getLast()); //Super simpatica
      //funziona

      vi.removeFirst(); //"No scherzo sono io al primo posto"
      System.out.println(vi.getFirst()); //"Messaggio al primo posto" --- YES
      vi.removeLast(); //Super simpatica
      System.out.println(vi.getLast()); //É  --- YES

      vi.makeEmpty();
      System.out.println(vi.getFirst()); //null ---
      System.out.println(vi.getLast());  //null --- YES
      System.out.println(vi.size()); //0 --- YES

      vi.addFirst(7);
      System.out.println(vi.getFirst()); //7 ---
      System.out.println(vi.getLast());  //7 --- YES
      System.out.println(vi.size());     //1 --- YES

      System.out.println();
      vi.addFirst("Tua madre");
      System.out.println(vi.size());     //2
      System.out.println(vi.getFirst()); //Tua madre
      System.out.println(vi.getLast());  //7

     

      //test con parametri
      System.out.println();
      System.out.println();

      //questo ha i parametri
      DoublyLinkedList <String> v2 = new DoublyLinkedList <String> ();
      v2.addLast("1");
      v2.addLast("2");
      v2.addLast("3");
      v2.addLast("4");
      v2.addLast("5");

      System.out.println(v2.getFirst()); //1
      System.out.println(v2.getLast());   //5
      System.out.println(v2.size()); //5
      System.out.println(v2.isEmpty()); //false

      String temp = v2.getFirst();
      System.out.println(temp); //1
   }
}

/*
java DoublyLinkedListTester 7    

*** addFirst() e size(): DATI INSERITI PARI A 7***

*** getFirst(): DATO IN TESTA 6***

*** getLast(): DATO IN CODA 0***  

*** DATI INSERITI ***
removeFirst(): 6
removeFirst(): 5
removeFirst(): 4
removeFirst(): 3
removeFirst(): 2
removeFirst(): 1
removeFirst(): 0

*** removeFirst() e size(): DATI contenuti A 0***

*** addLast() e size(): DATI INSERITI PARI A 7***

*** DATI ESTRATTI ***
removeLast(): 1
removeLast(): 2
removeLast(): 3
removeLast(): 4
removeLast(): 5
removeLast(): 6
removeLast(): 7

*** removeLast() e size(): DATI INSERITI PARI A 0***


6
false
No scherzo sono io al primo posto
Super simpatica
Messaggio al primo posto
Ã?
null
null
0
7
7
1

2
Tua madre
7


1
5
5
false
1
*/