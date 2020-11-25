/**
  * Studente.java -- associa in modo immutabile nome e numero di matricola
  * due oggetti sono uguali quando hanno la stessa matricola
  *
  * @author Franco Bombi
  *
  * @version 2012 Comparable<T>
  * @version 2005 java 5.0
  * @version 2002-03
  */

  public class Studente implements Comparable<Studente> {
      
     private final String nome;
     private final int matricola;
  
     public Studente(String n, int m)
     {
        nome = n;
        matricola = m;
     }
  
     /**
       restituisce il numero di matricola
       @return numero di matricola
     */
     public int matricola() { return matricola; }
  
     /**
       ritorna il nome
       @return nome
     */
     public String nome() { return nome; }
  
     /**
       ritorna la stringa "matricola:nome"
       @return stringa
     */
     public String toString() { return matricola + ":" + nome; }
  
     /**
       confronta in base al numero di matricola
       @param s studente
       @return ordine
     */
     public int compareTo(Studente s)
     {
        return matricola - s.matricola;
     }
}