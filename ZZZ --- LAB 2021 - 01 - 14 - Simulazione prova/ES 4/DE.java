/**
  * Realizza il tipo di dati astratto Multimappa Ordinata, un contenitore di
  * associazioni chiave/valore con chiave non e' necessariamente univoca
  *
  * @typeparam K tipo parametrico della chiave limitato a Comparable
  * @typeparam V tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 12-02-2019
  *
  */
public class DE<K extends Comparable,V extends Comparable> extends D<K,V>
{    
   /**
     * costruttore: inizializza una multimappa estesa vuota
     */
   public DE()
   {
      super();
   }
   
   /**
     * verifica se l'associazione di chiave specificata e' presente in questa
     * multimamma
     * @param key la chiave specificata
     * @return true se questa multimappa contiene la chiave specificata,
     *         false altrimenti
     */
   public boolean contains(K key)
   {
      return findAll(key).length > 0;
   }
 
   /**
     * fornisce le chiavi univoche di questa multimappa
     * @return un array ordinato contenente le chiavi univoche di questa
     *         multimappa
     */
   public Comparable[] keySet()
   {
      // accesso alle chiavi
      Comparable[] k = keys();

      // restituzioni dell'insieme delle chiavi univoche         
      return purge(k);
   } 
   
   /**
     * @return un array ordinato contenente i valori univoci di questa
     * multimappa
     */
   public Comparable[] valueSet()
   {
      final String EMPTY_STRING = "";
      // accesso alle chiavi univoche
      Comparable[] k = keySet();
      
      // multimappa di appoggio
      DE<V,String> m = new DE<V,String>();
            
      // inserimento delle associazioni valore/EMPTY_STRING nella multimappa di
      // appoggio
      for (int i = 0; i < k.length; i++)
      {
         Object[] v = findAll((K)k[i]);
         for (int j = 0; j < v.length; j++)
            m.insert((V)v[j], EMPTY_STRING);
      }
      
      // restituzioni dell'insieme dei valori univoci 
      return m.keySet();
   }    
      
   // eliminazione dei duplicati - O(n)
   private Comparable[] purge(Comparable[] p) 
   {
      // se la dimensione di p e' minore di 2, allora non ci sono duplicati
      if (p.length < 2)
         return p;
           
      int i = 0;
      int j = i + 1;
      while (j < p.length) 
      {
         // se la chiave e' multipla avanzo
         while (j < p.length && p[j].compareTo(p[i]) == 0)
            j++;
               
         // memorizzazione della nuova chiave all'indice corretto
         if (j < p.length)
            p[++i] = p[j++];
 
      }  

      // ridimensionamento dell'array
      Comparable[] r = new Comparable[i + 1]; 
      System.arraycopy(p, 0, r, 0, r.length);        
               
        return r;        
    }     
}
