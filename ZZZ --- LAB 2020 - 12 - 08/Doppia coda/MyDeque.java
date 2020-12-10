
/*
Codificare la classe MyDeque.java che realizza l'interfaccia Deque, in quattro modi diversi, usando internamente:
- un array riempito parzialmente a ridimensionamento dinamico;
- un array circolare a ridimensionamento dinamico;
- una lista concatenata;
- una doppia lista concatenata.
*/
public class MyDeque implements Deque{
    //variabili di esemplare
    private Object []  v;
    private int vSize;
    public int first;
    public int last;
    private static final int INITIAL_SIZE = 1;

    //metodi
    public MyDeque () {
        makeEmpty();
    }

    public void makeEmpty () {
        v = new Object [INITIAL_SIZE];
        vSize = 0;
        //pos.primo elemento,
        //se devi aggiungere meti a first-1
        first = 0;
        //posizione nella quale aggiungere
        //se è 3 allora l'ultimo indice non null è 2
        last = 1;
    }

    public int size () {
        return vSize;
    }

    public boolean isEmpty () {
        return vSize == 0;
    }

    public void addFirst(Object element) {
        if(first == 0 && v[first] != null){
            resizeFirst();
        }
        if (first < 0){
            resizeFirst();
        }
        if(first == 0 && isEmpty()){
            v[first] = element;
            vSize++;
            return;
        }
        v[--first] = element;
        vSize++;
    }

    public void addLast(Object element) {
        //se si è arivati all'ultima posizione
        if (last >= v.length){
            resize();
        }
        //last è la posizione nel quale si inserisce
        if(first == 0 && last == 0 && isEmpty()){
            v[last-1] = element;
            vSize++;
            return;
        }
        v [last++] = element;
        vSize++;
    }

    private void resize () {
        Object [] newT = new Object [2 * v.length];
        //first --> last-1
        System.arraycopy(v, first, newT, 0, vSize);
        v = newT;
    }

    //per aggiungere alla prima posizione
    private void resizeFirst () {
        int temp = v.length;
        Object [] newT = new Object [2 * v.length];
        //first --> last-1 = first+vSize
        //temp --> temp+vSize
        System.arraycopy(v, first, newT, temp, vSize);
        first = temp;
        //last è il primo null, può essere fuori da array
        last = temp + size();
        v = newT;
    }

    public Object getFirst() throws EmptyDequeException {
        if (isEmpty()){
            throw new EmptyDequeException();
        }

        return v[first];
    }

    public Object getLast() throws EmptyDequeException {
        if (isEmpty()){
            throw new EmptyDequeException();
        }

        if(first == 0 && last == 0){
            return v[last];
        }
        return v[last-1];
    }


    //da finire
    public Object removeFirst() throws EmptyDequeException {
        if (isEmpty()){
            throw new EmptyDequeException();
        }
        //first primo indice con valori
        Object temp = v[first];
        if(first+1 >= v.length){
            resizeFirst();
        }
        //assegnazione null e decrementi
        v[first++] = null;
        vSize--;

        //ritorno
        return temp;

    }

    public Object removeLast() throws EmptyDequeException {
        if (isEmpty()){
            throw new EmptyDequeException();
        }

        //last-1 ultimo indice con valori
        Object temp = v[last-1];
        //assegna il null
        v[last-1] = null;
        //decrementi
        last--;
        vSize--;
        //ritorno
        return temp;
    }
}