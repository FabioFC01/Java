/**
 * TextContainerTester.java
 * classe di prova della classe TextContainer
 *
 * @author Adriano Luchetta
 * @version 20-Nov-2004
 * @version 10-Nov-2005
 * @version 18-Nov-2006
 */

import java.util.Scanner;

public class TextContainerTester
{
   public static void main(String[] args)
   {
      final String INDENT = ">>> ";

      Scanner in = new Scanner(System.in);
      String delimiters = " \t\n\r,.;:?!\\-()";
      TextContainer text = new TextContainer(in, delimiters);
      in.close();

      // ordinamento lessicografico
      TextContainer inverseText = new TextContainer();
      TextContainer sortedText = new TextContainer();
      while (!text.isEmpty())
      {
         String word = text.removeLast();
         inverseText.add(word);
         sortedText.add(word);
      }
      sortedText.sort();

      // eliminazione delle occorrenze multiple e stampa
      TextContainer inverseNoRepetitionText = new TextContainer();
      TextContainer inverseSortedText = new TextContainer();

      String current = "";
      while (!sortedText.isEmpty())
      {
         String next = sortedText.removeLast();
         inverseSortedText.add(next);
         if (next.compareTo(current) != 0)
         {
            inverseNoRepetitionText.add(next);
            current = next;
         }
      }

      System.out.println("\n*** STAMPA DELLE PAROLE IN ORDINE DI ACQUISIZIONE ***");
      System.out.println("Numero delle parole nel testo originale: " + inverseText.size());
      while (!inverseText.isEmpty())
         System.out.println(INDENT + inverseText.removeLast());

      System.out.println("\n*** STAMPA DELLE PAROLE IN ORDINE LESSICOGRAFICO ***");
      System.out.println("Numero delle parole nel testo ordinato: " + inverseSortedText.size());
      while (!inverseSortedText.isEmpty())
         System.out.println(INDENT + inverseSortedText.removeLast());

      System.out.println("\n*** STAMPA DELLE PAROLE IN ORDINE LESSICOGRAFICO SENZA RIPETIZIONI ***");
      System.out.println("Numero delle parole non ripetute: " + inverseNoRepetitionText.size());
      while (!inverseNoRepetitionText.isEmpty())
         System.out.println(INDENT + inverseNoRepetitionText.removeLast());
   }
}