public class EmptyQueueException extends RuntimeException
{
   public EmptyQueueException()
   {
   
   }
   
   public EmptyQueueException(String why)
   {
      super(why);  
   }   
}
