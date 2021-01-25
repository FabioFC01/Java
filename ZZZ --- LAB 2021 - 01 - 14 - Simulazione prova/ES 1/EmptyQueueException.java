public class EmptyQueueException extends RuntimeException {
      EmptyQueueException() {

      }
      EmptyQueueException (String s) {
         super(s);
      }
}
