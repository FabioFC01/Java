/**
  * FONDAMENTI DI INFORMATICA - GR. 4
  * Prova di Programmazione del 29-01-2020
  *
  * Classe SE
  * Realizza un insieme esteso
  *
  * @see S
  * @see java.lang.Comparable
  * @param E il tipo di elementi contenuti nell'insieme
  *
  * @author A. Luchetta
  * @version 20200115
  *
  */
public class SE<E extends Comparable> extends S<E> implements Comparable<SE<E>>
{
   /**
      inizializza questo insieme come insieme vuoto
   */
   public SE()
   {
      super();
   }

   /**
      inizializza questo insieme con gli elementi dell'array specificato
      @param a array specificato
   */
   public SE(E[] a)
   {
      super(a);
   }
   
    /**
      inizializza questo insieme con gli elementi dell'insieme specificato
      @param s insieme specificato
   */
   public SE(Set s)
   {
      super(s);
   }     

   /**
      definisce l'ordine naturale della classe
      @param s l'insieme esteso specificato
      @return un numero negativo se questo insieme precede l'insieme specificato
              zero se questo insieme e l'insieme specificato sono uguali
              un numero negativo se questo insieme segue l'insieme specificato
      @throws NullPointerException se l'insieme specificato vale null
   */           
   @Override // garantisce di sovrascrivere compareTo dell'interf. Comparable
   public int compareTo(SE<E> s) throws NullPointerException
   {
      // gestione delle precondizioni 
      if (s == null)
         throw new NullPointerException();

      // verifica sulla dimensione
      int n = size() - s.size(); 
      if (n != 0)
         return n;

      // generazione degli array per le chiamate a toSortedArray
      Comparable[] a = new Comparable[size()]; 
      Comparable[] b = new Comparable[s.size()];  
                                                 
      // ordinamento
      toSortedArray((E[])a);
      s.toSortedArray((E[])b);             

      // confronto degli elementi ordinati dei due array a partire dai massimi         
      for (int i = size() - 1; i >= 0; i--)        
         if (a[i].compareTo(b[i]) != 0)
            return a[i].compareTo(b[i]);  // gli insiemi sono diversi   
      
      return 0; // gli insiemi sono uguali
   }

   /**
      NOTA 1: realizzazione ricorsiva
      La realizzazione ricorsiva e' meno efficiente di una corrispondente
      realizzazione iterativa a causa della sequenza di chiamate al metodo
      stesso generate dal metodo.
      NOTA 2: Il metodo non  deve modificare questo insieme
      @return l'elemento minimo dell'insieme
      @throws java.util.NoSuchElementException se non esiste un elemento minimo
   */
   @Override  
   public E min() throws java.util.NoSuchElementException
   {
      // gestione delle precondizioni - l'insieme e' vuoto
      if (size() == 0)
         throw new java.util.NoSuchElementException();          
         
      // caso base - l'insieme ha un solo elemento
      Iterator<E> iter = iterator(); 
      if (size() < 2)
         return iter.next();
         
      // rimozione di un elemento - semplificazione del problema
      E m1 = iter.next();  // accesso
      iter.remove();       // rimozione
 
      // passo ricorsivo
      E min = min();
      
      // inserimento dell'elemento precedentemente rimosso
      add(m1);  // il metodo non modifica questo insieme    
      
      // selezione del minimo
      if (m1.compareTo(min) < 0)
         min = m1;
               
      return min;            
   }

   /**
      @param iter l'iteratore specificato
      @return un insieme esteso che contiene gli elementi accessibili di questo
              insieme tramite l'iteratore specificato. Restituisce un insieme
              vuoto se l'iteratore specificato vale null
   */
   public SE<E> subset(Iterator<E> iter)
   {
      // generazione di un insieme esteso vuoto 
      SE<E> s = new SE();

      // gestione delle precondizioni
      if (iter == null)
         return s;
         
      // iterazione e inserimento degli elementi
      while (iter.hasNext())
         s.add(iter.next());
         
      return s;      
   } 
}
