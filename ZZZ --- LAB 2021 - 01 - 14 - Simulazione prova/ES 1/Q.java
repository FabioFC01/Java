// COCIANCICH FABIO MATR 2016268
//coda con array
public class Q <T> implements Queue<T> {
   private Object []v;
   private int size;
   private final static int INITIAL_SIZE = 1;
   private int f;
   private int b;

   //costruttore
   public Q () {
      makeEmpty();
   }

   public void makeEmpty () {
      v = new Object [INITIAL_SIZE];
      size = 0;
      f = 0;
      b = 0;
   }

      /**
     @return true se il contenitore e' vuoto, false altrimenti
  */
  public boolean isEmpty() {
     return size <= 0;
  }

  /**
     @return numero di elementi nel contenitore
  */
  public int size() {
     return size;
  }
  
  /**
     inserisce nella coda l'elemento specificato
     @param x elemento specificato
     @throws java.lang.IllegalArgumentException se l'elemento specificato vale null
  */
  public void enqueue(T x) {
     if (x == null) {
        throw new IllegalArgumentException();
     }
     if (b >= v.length){
        Object [] newV = new Object [2*v.length];
        System.arraycopy(v, f, newV, 0, size);
        v = newV;
        f = 0;
        b = size;
     }

     v[b++] = x;
     size++;
  }
  
  /**
     @return il fronte della coda
     @throw EmptyQueueException se la coda e' vuota
  */
  public T front() {
     if (isEmpty()){
        throw new EmptyQueueException();
     }
      return ((T)v[f]);
  }  
  
  /**
     ispezione, estraendolo, l'elemento in fronte alla coda
     @return elemento in fronte alla coda
     @throw EmptyQueueException se la coda e' vuota
  */
  public T dequeue() throws EmptyQueueException {
   if (isEmpty()){
      throw new EmptyQueueException();
   }

   T ret = (T)v[f];

   v[f++] = null;
   size--;

   return ret;
  }
}