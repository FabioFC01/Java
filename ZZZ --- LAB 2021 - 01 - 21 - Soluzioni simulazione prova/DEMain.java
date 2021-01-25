/**
  * Classe di prova della classe DE
  *
  * @see DE
  * @author A. Luchetta
  * @version 27-12-2020
  *
  */
  import java.util.Scanner;
  public class DEMain
  {
     public static void main(String[] args) throws java.io.IOException
     {
        // apertura del flusso d'ingresso
        Scanner in = new Scanner(new java.io.FileReader(args[0]));
        
        // generazione di una multimappa estesa
        DE<String, String> m = new DE<String, String>();
        
        // acquisizione delle associazioni da standard input
        while (in.hasNextLine())  // acquisizione per riga
        {
           // scanner per estrazione dei token dalla riga
           Scanner tk = new Scanner(in.nextLine()).useDelimiter("[#]+");
  
           // inserimento dell'associazione nella multimappa
           m.insert(tk.next(), tk.next());
            
           // chiusura dello scanner per estrazione dei token
           tk.close();       
        }
        
        // chiusura del flusso d'ingresso
        in.close();
           
    
        // invio a standard output del numero di associazioni presenti nella
        // multimappa
        System.out.println("SIZE: " + m.size());
        
        // acquisizione delle chiavi ordinate e univoche
        Comparable[] k = m.keySet();       
        
        // invio a standard output dei valori per chiave
        System.out.println("\nFINDALL: ");
        for (int i = 0; i < k.length; i++)
        {
              System.out.print(k[i]); 
              Object[] v = m.findAll((String)(k[i]));
              for (int j = 0; j < v.length; j++)
                 System.out.print(" + " + v[j]);  
              System.out.println();              
        }
        
        // invio a standard output dell'insieme dei valori
        Comparable[] a = m.valueSet();  // array contenente i valori univoci
        System.out.println("\nVALUESET: "); 
        for (int i = 0; i < a.length; i++)
           System.out.print(a[i] + " - ");  
        System.out.println();      
        
        // rimozione per chiave delle associazioni e invio a standard output
        System.out.println("\nREMOVEALL: ");
        for (int i = 0; i < k.length; i++)
        {
           System.out.print(k[i]); 
           Object[] v = m.removeAll((String)(k[i]));
           for (int j = 0; j < v.length; j++)
              System.out.print(" + " + v[j]); 
           System.out.println();    
        }      
           
        // invio a standard output del numero di associazioni presenti nella
        // multimappa
        System.out.println("\nSIZE: " + m.size());                 
     }
  }