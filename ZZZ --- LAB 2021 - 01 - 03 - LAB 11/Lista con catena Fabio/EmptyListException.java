public class EmptyListException extends RuntimeException {
   
   EmptyListException() {
   }
   
   EmptyListException (String motivo) {
      super(motivo);
   }
}
