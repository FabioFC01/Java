/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 22.2.2017
  *
  * classe ME - mappa estesa - contenitore di associazioni chiave/valore con chiave univoca
  * la chiave e il valore sono di tipo parametrico
  *
   *
  * typeparam K il tipo parametrico della chiave
  * typeparam V il tipo parametrico del valore
  *
  * @see M
  * @see Map
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */
public class ME<K extends Comparable, V extends Comparable> extends M<K, V>
{ 
   /**
      Verifica se una associazione di chiave specificata e' presente in questa
      mappa
      @param k la chiave specificata
      @return true se la chiave specificata e' presente in questa mappa, false
              altrimenti.
   */ 
   public boolean containsKey(K k)
   {
      // verifica di presenza
      return get(k) != null;
   }
   
   /**
      Verifica se una associazione di valore specificato e' presente in questa
      mappa
      @param k la chiave specificata
      @return true se il valore specificato e' presente in questa mappa, false
              altrimenti.
   */ 
   public boolean containsValue(V v)
   {
      // generazione dell'array dei valori ordinato e senza duplicati
      Object[] r = valueSet();
      
      // ricerca binaria
      return search(r, 0, r.length - 1, v) >= 0;
   }
   
   // ricerca binaria 
   private static int search(Object[] a, int from, int to, Object t)
   {
      if (from > to)
         return -1;
         
      int mid = (from + to) / 2;
      Comparable c = (Comparable)a[mid];      
      if (c.compareTo(t) == 0) 
         return mid;
      else if (c.compareTo(t) < 0)
         return search(a, mid + 1, to, t)   ;
      else
         return search(a, from, mid - 1, t);           
   }
   
   public V put (K k, V v)
   {
      return super.put(k, v);
   }
   
   /**
      accesso ai valori di questa mappa
      @return array contenente i valori della associazioni presenti nella mappa
             disposti secondo il loro ordine naturale e senza duplicati.
   */ 
   public Comparable[] valueSet()
   {  
      // generazione dell'array dei valori
      Object[] v = values();
      
      // mappa temporanea di appoggio
      M m = new M(); 
      
      // inserimento associazioni value/""
      for (int i = 0; i < v.length; i++)
         m.put(((Comparable)v[i]), ""); // valore qualsiasi Comparable
      
      // generazione di array ordinato e senza duplicati
      Comparable[] ret = m.keySet();
                        
      return ret;      
   }
}
