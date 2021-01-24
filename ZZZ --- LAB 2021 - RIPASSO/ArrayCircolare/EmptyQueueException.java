public class EmptyQueueException extends RuntimeException {
   EmptyQueueException() {}
   EmptyQueueException (String err) { super(err); }
}
