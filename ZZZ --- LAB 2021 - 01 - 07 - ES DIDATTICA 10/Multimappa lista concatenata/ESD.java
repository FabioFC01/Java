public class ESD<K extends Comparable,V extends Comparable> extends D<K,V>
{ // parte privata
 
//costruttore
 public ESD() {
   
 } 
 /** @return true se questa multimappa contiene la chiave specificata,
 false altrimenti
 */ public boolean contains(K key){…}
 /** @return un array ordinato contenente le chiavi univoche di questa
 multimappa o un array di dimensione nulla se questa multimappa
 e’ vuota
 */ public Comparable[] keySet() {…}
 /**@return un array ordinato contenente i valori univoci di questa multimappa
 o un array di dimensione nulla se questa multimappa e’ vuota
*/ public Comparable[] valueSet() {...}
}