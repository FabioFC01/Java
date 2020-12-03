public class DoublyLinkedList implements Container{
    //variabili d'esemplare
    private ListNode head, tail;
    private int listSize;

    public DoublyLinkedList(){
        //costruttore
        head = new ListNode();
        tail = new ListNode(null, null, head);
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

    public Object getFirst(){
        return (head.getNext()).getElement();
    } // O(1)

    public Object getLast() {
        return (tail.getPrev()).getElement();
    } // O(1)

    public void addFirst(Object obj) {
        //metto obj in head attuale
        head.setElement(obj);
        //creazione nuovo nodo
        ListNode newNode = new ListNode(null, head, null);
        //il nuovo nodo diventa head
        head = newNode;
        //incremento
        listSize++;
    } // O(1)
    
    public Object removeFirst() {
        //prendi oggetto di First
        Object temp = (head.getNext()).getElement();
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

    public void addLast(Object obj) {
        //assegna obj a tail
        tail.setElement(obj);
        //creazione nuovo nodo
        ListNode newNode = new ListNode(null, null, tail);
        //il nuovo nodo diventa tail
        tail = newNode;
        //incremento
        listSize++;
    } // O(1)

    public Object removeLast(){
        //si prende il valore di last
        Object temp = (tail.getPrev()).getElement();
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
    private class ListNode {
        private Object element;
        private ListNode next; //stranezza
        private ListNode prev;

        public ListNode(Object e, ListNode n, ListNode p) {
            element = e;
            next = n;
            prev = p;
        }
        public ListNode() { 
            this(null, null, null);
        }

        public Object getElement() { return element; }
        public ListNode getNext() { return next; }
        public ListNode getPrev() { return prev; }
        public void setElement(Object e) { element = e; }
        public void setNext(ListNode n) { next = n; }
        public void setPrev(ListNode p) { prev = p; }
        }
}