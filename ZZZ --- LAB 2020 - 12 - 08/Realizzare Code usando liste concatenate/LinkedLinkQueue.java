import javax.management.QueryEval;

//coda
//FIFO
public class LinkedLinkQueue implements Queue {
    //classe interna
    private class Nodo {
        private Object element;
        private Nodo next;

        public Nodo (Object e, Nodo n) {
            element = e;
            next = n;
        }

        public Nodo () {
            this(null, null);
        }

        public void setElement (Object e) {
            element = e;
        }

        public void setNext (Nodo n) {
            next = n;
        }

        public Object geteElement () {
            return this.element;
        }

        public Nodo getNext () {
            return this.next;
        }
    }
    //fine classe interna


    //inizio classe Catena
    private Nodo head, tail;
    private int QueueSize;

    public LinkedLinkQueue () {
        //inizializzazione coda
        head = new Nodo();
        tail = new Nodo();
        head.setNext(tail);
        QueueSize = 0;
    }

    public void makeEmpty () {
        head.setNext(tail);
        QueueSize = 0;
    }

    public int size () {
        return QueueSize;
    }

    public boolean isEmpty() {
        return QueueSize == 0;
    }

    public Object front() throws EmptyQueueException {
        if (isEmpty()){
            throw new EmptyQueueException();
        }
        return head.getNext().geteElement();
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()){
            throw new EmptyQueueException();
        }
        Object temp = front();

        //head diventa il valore dopo
        head = head.getNext();
        //valore di head diventa null
        head.setElement(null);
        //decremento e ritorno
        QueueSize--;

        return temp;
    }

    public void enqueue(Object obj) {
        //inserisci obj in tail
        tail.setElement(obj);
        //crea nuovo nodo
        tail.next = new Nodo();
        //tail diventa il nodo dopo
        tail = tail.getNext();
        //incremeneto
        QueueSize++;
    }
}