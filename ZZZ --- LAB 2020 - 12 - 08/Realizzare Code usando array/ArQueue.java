public class ArQueue implements Queue  {
        private Object [] v;
        public int front;
        public int tail;

        public void makeEmpty() {
            v = new Object[1];
            front = 0;
            tail = 0;
        }

        public ArQueue () {
            makeEmpty();
        }

        public boolean isEmpty () {
            return front == tail;
        }

        public int size () {
            return tail - front;
        }

        public Object front() throws EmptyQueueException{
            if (isEmpty()){
                throw new EmptyQueueException();
            }
            return v[front];
        }

        public void enqueue(Object obj){
            if(tail == v.length-1){
                increment();
            }
            v[tail++] = obj;
        }

        public Object dequeue() throws EmptyQueueException{
            if (isEmpty()){
                throw new EmptyQueueException();
            }
            Object temp = v[front];
            v[front++] = null;
            return temp;
        }

        private void increment () {
            Object [] NewV = new Object[2 * v.length];
            int temp = tail - front;
            System.arraycopy(v, 0, NewV, front, size());
            v = NewV;
            front = 0;
            tail = temp;
        }



}