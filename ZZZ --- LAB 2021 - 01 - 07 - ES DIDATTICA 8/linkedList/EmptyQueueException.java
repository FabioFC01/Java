/**
  *              FONDAMENTI DI INFORMATICA - CANALE 4 - A.A. 2014-15
  *                      Prova di Programmazione - 17-02-2015
  *
  * Eccezione EmptyQueueException
  *
  * @author A. Luchetta
  * @version 9-Feb-2015
  *
  */
public class EmptyQueueException extends RuntimeException
{  
   /*
      Costruttore
   */
   public EmptyQueueException()
   {
      super();
   } 
   
   /*
      Costruttore
   */
   public EmptyQueueException(String why)
   {
      super(why);
   }  
}  
