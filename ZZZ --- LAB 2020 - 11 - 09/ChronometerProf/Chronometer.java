/**  
   Realizza un cronometro, ovvero un misuratore di tempo.<br>
   la sequenza di misura corretta e':<br>
   start -> stop -> lettura della misura -> reset
   
   @author A. Luchetta
   @version 25-Nov-2016
 */
public class Chronometer
{
   private static final long NONE = -1L;
   private static final String OFF     = "off    ";  // cronometro fermo
   private static final String RUNNING = "running";  // cronometro in funzione
   private static final String READY   = "ready  ";  // misura disponibile
   private static double MILLIS_TO_SEC = 1E-3;       // conversione millisecondi secondi

   private String state;
   private long startTime;
   private long elapsedTime;

   public Chronometer()
   {
      reset();
   }

   /**
      avvia il cronometro.      
      se il cronometro e' gia' avviato, fa ripartire il conteggio.
   */
   public void start()
   {
      reset();
      state = RUNNING;
      startTime = System.currentTimeMillis();
   }
   
   /**
      ferma il cronometro.
      se il cronometro non e' stato avviato, termina senza fare nulla
   */
   public void stop()
   {
      if (!isRunning())
         return;

      state = READY;
      elapsedTime = System.currentTimeMillis() - startTime;
      startTime = NONE;
   }
   
   /**
      azzera il cronometro.
   */
   public void reset()
   {
      state = OFF;
      startTime = NONE;
      elapsedTime = NONE;
   }
   
   /**
      restituisce il conteggio del tempo se il cronimetro ha completato la 
      sequenza di misura, o zero altrimenti.<br>
      La misura sia espressa in secondi con 4 cifre decimali.
      
   */
   public String getElapsedTime()
   {
      if (!isTimeReady())
         return "0.0";

      return String.format("%.4f", elapsedTime * MILLIS_TO_SEC) + " s";
   }
   
   /**
      verifica se il cronometro e' in funzione
      @return true se il cronometro e' in funzione, false altrimenti
   */
   public boolean isRunning()
   {
      return state.equals(RUNNING);
   }
   
   /**
      verifica se il cronometro ha completato la sequenza di misura e ha una
      misura disponibile.
      @return true se il cronometro ha completato la misura, false altrimenti
   */
   public boolean isTimeReady()
   {
      return state.equals(READY);
   }
   
   /**
      descrizione testuale nella forma "Chronometer state time" dove state e'
      uno degli stati del cronometro: off, running, ready e time e' il tempo
      misurato
   */
   public String toString()
   {
      return "Chronometer " + state + " time = " + getElapsedTime();
   }   

}