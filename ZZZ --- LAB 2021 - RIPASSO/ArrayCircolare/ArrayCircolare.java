public class ArrayCircolare <E>  implements Container {
   //variabili di esemplare
   static final int INITIAL_CAPACITY = 1;
	protected Object[] v;
   protected int front, back;
   
   //costruttore
	public ArrayCircolare (){ 
		makeEmpty();
   }
   
   //makeEmpty
   public void makeEmpty () {
      v = new Object[INITIAL_CAPACITY];
		front = back = 0;
   }

   //isEmpty
	public boolean isEmpty() {
		return (back == front);
   }

   //size
   public int size() {
		return (back - front + v.length) % v.length;
	}
   
   //front
	public E front() {
		if (isEmpty())
			throw new EmptyQueueException();
		return (E)v[front];
   }

   //addlast
   public void addLast(E obj) {
		if (increment(back) == front) {
         Object [] newV = new Object [2*v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
			// se si ridimensiona l’array e la zona utile
			// della coda si trova attorno alla sua fine,
			// la seconda metà del nuovo array rimane vuota
			// e provoca un malfunzionamento della coda,
			// che si risolve spostandovi la parte della
			// coda che si trova all’inizio dell’array
			if (back < front) {
				System.arraycopy(v, 0, v, v.length/2, back);
				for (int i = 0; i < back; i++)
						v[i] = null; //perchè sennò sarebbero doppi
				back += v.length/2; //sposto back
			}
      }
      
		v[back] = obj;
		back = increment(back);
   }
   
   //addFirst
   public void addFirst (E obj) {
      if (decrement(front) == back) {
         Object [] newV = new Object [2*v.length];
         System.arraycopy(v, 0, newV, 0, v.length);
         v = newV;
			// se si ridimensiona l’array e la zona utile
			// della coda si trova attorno alla sua fine,
			// la seconda metà del nuovo array rimane vuota
			// e provoca un malfunzionamento della coda,
			// che si risolve spostandovi la parte della
			// coda che si trova all’inizio dell’array
			if (back < front) {
				System.arraycopy(v, 0, v, v.length/2, back);
				for (int i = 0; i < back; i++)
						v[i] = null; //perchè sennò sarebbero doppi
				back += v.length/2; //sposto back
			}
      }

      front = decrement(front);
		v[front] = obj;
		
   }
   
   //remove First
	public E remFirst() {
		E obj = front();
		v[front] = null; // garbage collector
		front = increment(front);
		return obj;
   }

   //removeLast
   public E remLast () {
      if (isEmpty()){
         return null;
      }
      back = decrement(back);
      E ret = (E)v[back];
      v[back] = null; //garbage collector

      return ret;
   }
   
   //increment
   protected int increment(int index) {
		return (index + 1) % v.length;
   }

   //decrement
   protected int decrement (int index) {
      int h = index - 1;
      if (h == -1) {
         h = v.length-1;
      }
      return h;
   }



}