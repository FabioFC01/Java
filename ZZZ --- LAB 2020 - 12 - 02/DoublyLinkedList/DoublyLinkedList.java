public class DoublyLinkedList <E> implements Container{
    //variabili d'esemplare
    private ListNode <E> head, tail;
    private int listSize;

    public DoublyLinkedList(){
        //costruttore
        head = new ListNode <>();
        tail = new ListNode <> (null, null, head);
        head.setNext(tail);
        listSize = 0;
     }

    public void makeEmpty(){
        head.setNext(tail);
        tail.setPrev(head);
        listSize = 0;
    } // O(1)
    public boolean isEmpty(){
        return (head.getNext() == tail) && (tail.getPrev() == head);
    } // O(1)

    public E getFirst(){
        return (E)(head.getNext()).getElement();
    } // O(1)

    public E getLast() {
        return (E)(tail.getPrev()).getElement();
    } // O(1)

    public void addFirst(E obj) {
        //metto obj in head attuale
        head.setElement((E)obj);
        //creazione nuovo nodo
        ListNode <E> newNode = new ListNode <> (null, head, null);
        //il nuovo nodo diventa head
        head = newNode;
        //incremento
        listSize++;
    } // O(1)
    
    public E removeFirst() {
        //prendi oggetto di First
        E temp = (E)(head.getNext()).getElement();
        //head diventa il primo nodo
        head = head.getNext();
        //togli il valore di head
        head.setElement(null);
        //imposta il riferimento di quello
        //che prima era 2° e ora è 1°
        (head.getNext()).setPrev(head);
        //decremento
        listSize--;
        return temp;
    } // O(1)

    public void addLast(E obj) {
        //assegna obj a tail
        tail.setElement(obj);
        //creazione nuovo nodo
        ListNode <E> newNode = new ListNode <> (null, null, tail);
        //il nuovo nodo diventa tail
        tail = newNode;
        //incremento
        listSize++;
    } // O(1)

    public E removeLast(){
        //si prende il valore di last
        E temp = (E)(tail.getPrev()).getElement();
        //si toglie il valore di last
        (tail.getPrev()).setElement(null);
        //tail diventa last
        tail = tail.getPrev();
        //quello che ora è tail
        //toglie il riferimento
        //al tail di prima
        tail.setNext(null);
        //decremento
        listSize--;
        return temp;
    } // O(1)

    public int size (){
        return listSize;
    } //O(1)


    //ListNode
    private static class ListNode <E> {
        private E element;
        private ListNode <E> next; //stranezza
        private ListNode <E> prev;

        public ListNode(E e, ListNode <E> n, ListNode <E> p) {
            element = e;
            next = n;
            prev = p;
        }
        public ListNode() { 
            this(null, null, null);
        }

        public E getElement() { return element; }
        public ListNode <E> getNext() { return next; }
        public ListNode <E> getPrev() { return prev; }
        public void setElement(E e) { element = e; }
        public void setNext(ListNode <E> n) { next = n; }
        public void setPrev(ListNode <E> p) { prev = p; }
        }
}