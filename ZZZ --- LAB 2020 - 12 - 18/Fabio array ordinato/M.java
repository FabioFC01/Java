/**
  * FONDAMENTI DI INFORMATICA - CANALE 5
  * PROVA PRATICA DI PROGRAMMAZIONE DEL 22.2.2017
  *
  * interfaccia Map - ADT mappa - contenitore di associazioni chiave/valore con
  * chiave univoca
  * la chiave e il valore sono di tipo parametrico
  *
  * typeparam K il tipo parametrico della chiave
  * typeparam V il tipo parametrico del valore
  *
  * @author A. Luchetta
  * @version 16-Dic-2020
  */

  // ----  ARRAY ORDINATO  ----
  public class M <K extends Comparable, V> implements Map <K, V>
  {
      // --- CLASSE INTERNA ENTRY --- 
      private class Entry {
          // variabili di esemplare
          private V value;
          private K key;

          //costruttore
          public Entry (){
              this (null, null);
          }
          public Entry (K k, V v){
              setKey (k);
              setValue(v);
          }

          //metodi modificatori
          public void setKey (K k) { key = k;}
          public void setValue (V v) {value = v;}

          //metodi di accesso
          public K getKey () {return key;}
          public V getValue () { return value;}
      }
      // --- FINE CLASSE INTERNA ENTRY ---

      //variabili di esemplare
      private Object [] v;
      private int vSize;
      private static final int INITIAL_CAPACITY = 1;

      //costruttore
      public M () {
          makeEmpty();
      }

      public void makeEmpty () {
          v = new Object[INITIAL_CAPACITY];
          vSize = 0;
      }


     /**
        restituisce il valore associato alla chiave specificata
        @param key la chiave specificata
        @return valore associato alla chiave specificata key o null se la chiave
                specificata non e' presente nella mappa
     */ 
    public V get(K key) {
         if (key == null){
             throw new IllegalArgumentException();
         }

         int n = search(key);

         if (n < 0) {
             return null;
         }

         V ritorno = ((Entry)v[n]).getValue();

         return ritorno;
     }

     //ricerca binaria
    private  int searchBinary (Object[]a , int from, int to, Object rif) {
        if (to < from) {
            return -1;
        }

        int mid = (from + to) / 2;

        Comparable c = ((Entry)a[mid]).getKey();

        if (c.compareTo(rif) == 0){
            return mid;
        }
        if (c.compareTo(rif) > 0) { //mid è maggiore
            return searchBinary(a, mid + 1, to, rif);        
        }
        else{   //mid è minore
            return searchBinary(a, from, mid - 1, rif);
        }
    }
     
     /**
      * @return indice i dove c'è la chiave, -1 altrimenti
      */
     private int search (K key) {
        if (key == null){
            throw new IllegalArgumentException();
        }


        return searchBinary(v, 0, vSize -1 , key);
     }
     
     /**
        verifica se questa mappa e' vuota
        @return true se questa mappa e' vuota, false altrimenti
     */
    public boolean isEmpty() {
        return vSize <= 0;
    }
     
     /**
        accede alle chiavi di questa mappa
        @return se questa mappa non e' vuota restituisce un array ordinato
                contenente le chiavi delle associazioni presenti o altrimenti un
                array di dimensione nulla.
     */
    public Comparable[] keySet() {

        Comparable [] chiavi = new Comparable [vSize];

        for (int i = 0; i < vSize; i++) {
            chiavi [i] = ((Entry)v[i]).getKey();
        }

        return chiavi;

     }     
  
     /**
        se questa mappa non contiene un'associazione di chiave specificata,
        aggiunge l'associazione di chiave e valore specificati e restituisce null,
        altrimenti sostituisce l'associazione presente di chiave specificata con
        la nuova associazione di valore specificayo e restituisce il vecchio
        valore che e' stato sostituito
        @param key la chiave specificata
        @param value il valore specificato
        @return null se questa mappa non contiene un'associazione di chiave
               specificata o altrimenti il vecchio valore associato alla chiave
        @throws IllegalArgumentException se key o value valgono null
     */
    public V put(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException();
        }

        int n = search(key);
        if (n >= 0){    //esiste già quella chiave
            V ritorno = ((Entry)v[n]).getValue(); 
            ((Entry)v[n]).setValue(value);  //assegnazione nuovo valore

            return ritorno;
        }

        //caso di chiave non esistente
        if (vSize >= v.length) { //ridimensionamento dinamico
            Object [] NewV = new Object [2*v.length];
            System.arraycopy(v, 0, NewV, 0, vSize);
            v = NewV;
        }

        int j = vSize -1;
        //PASSAGGIO IMPORTANTE
        while (j >= 0 && (((Entry)v[j]).getKey()).compareTo(key) > 0){
            v[j+1] = v[j];
            j--;
        }
        v [j+1] = new Entry(key, value); //NOTA IL j+1

        vSize++;
        return null;
    } 
     
     /**
        elimina da questa mappa l'associazione di chiave specificata e ne
        restituisce il valore   
        @param key la chiave specificata
        @return null se in questa mappa non e' presente un'associazione di chiave
                specificata o, altrimenti, il valore associato alla chiave
                specificata
     */
    public V remove(K k) {
        if (k == null) {
            throw new IllegalArgumentException();
        }

        int n = search(k);

        if (n < 0) {
            return null;
        }

        V rit = ((Entry)v[n]).getValue();

        for (int i = n; i < vSize -1 ; i++) {
            v[i] = v[i+1];
        }

        v[vSize -1] = null;
        vSize--;

        return rit;
    }
     
     /**
        fornisce il numero di associazioni presenti in questa mappa
        @return il numero di associazioni contenute in questa mappa
     */
    public int size() {
        return vSize;
    }
     
     /**
        accede ai valori di questa mappa
        @return array contenente i valori della associazioni presenti in questa
                mappa o un array di dimensione nulla se la mappa e' vuota
     */ 
    public Object[] values() {
        Object [] valori = new Object [vSize];
        for (int i = 0; i < vSize; i++) {
            valori[i] = ((Entry)v[i]).getValue();
        }

        return valori;
    }         
  }
  