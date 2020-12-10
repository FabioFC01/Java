//doppia coda con array circolare

public class MyDeque implements Deque{
    private Object [] v;
    //primo indice con valore,se vSize != 0
    private int first;
    //indice precedente di last è l'ultimo con valori 
    private int back;
    private static final int INITIAL_SIZE = 1;
    //i dati vanno da first --> last - 1
    private int vSize;

    public MyDeque () {
        makeEmpty();
    }

    public void makeEmpty () {
        v = new Object [INITIAL_SIZE];
        first = 0;
        back = 1;
        vSize = increment(first);
    }

    private void resize () {
        Object [] temp = new Object [2 * v.length];
        System.arraycopy(v, 0, temp, 0, v.length);
        //per copiare in maniera corretta array circolare
        if (back <= first){
            System.arraycopy(temp, 0, temp, temp.length/2 , back);
            back += temp.length / 2;
        }

        v = temp;
    }

    public int size () {
        //(back - front + v.length) % v.length <-- fa il prof
        return vSize;
    }

    public boolean isEmpty () {
        return vSize == 0;
    }

    public boolean isFull () {
        return vSize == v.length;
    }

    public int increment (int index) {
        return (1 + index) % v.length;
    } 

    public int decrement (int index) {
        return (index - 1 + v.length) % v.length;
    }

    public void addFirst(Object element) {
        //precondizioni
        if(element == null) {
            throw new IllegalArgumentException();
        }
        //ridimensionamento dinamico
        if (isFull()){
            resize();
        }
        //se è il primo elemento
        if (v[first] == null && vSize == 0){
            v [first] = element;
            vSize++;
            return;
        }
        //decremento
        first = decrement(first);
        //assegnazione
        v[first] = element;
        //aggiornamento vSize
        vSize++;
    }

    public void addLast (Object element){
        //precondizioni
        if(element == null) {
            throw new IllegalArgumentException();
        }
        //ridimensionamento dinamico
        if (isFull()){
            resize();
        }
        //perchè indice back è vuoto
        v[back] = element;
        //incremento
        back = increment(back);
        vSize++;
    }

    public Object getFirst () throws EmptyDequeException {
        //ricordo che il primo elemento è
        //all'indice first
        if (isEmpty()){
            throw new EmptyDequeException();
        }
        return v[first];
    }

    public Object getLast () throws EmptyDequeException {
        //ricordo che l'ultimo elemento è
        //all'indice precedente di back
        if (isEmpty()){
            throw new EmptyDequeException();
        }
        return v[decrement(back)];
    }

    public Object removeFirst() throws EmptyDequeException {
        //ricordo che il primo elemento è
        //all'indice first
        if (isEmpty()){
            throw new EmptyDequeException();
        }
        //assegnazione valore da restituire
        Object temp = v[first];
        //annullamento valore
        v[first] = null;
        //first procede a dx
        first = increment(first);
        //decremento
        vSize--;
        //ritorno
        return temp;
    }

    public Object removeLast() throws EmptyDequeException {
        //ricordo che l'ultimo elemento è
        //all'indice precedente di back
        if (isEmpty()){
            throw new EmptyDequeException();
        }
        //decremento back verso sx
        back = decrement(back);
        //asegnazione
        Object temp = v[back];
        //annullamento
        v[back] = null;
        //decremento
        vSize--;
        //ritorno
        return temp;
    }
}