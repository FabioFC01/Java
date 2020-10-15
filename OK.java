/**
 * La classe Hi richiede in un dialogBox il nome dello studente e produce il
 * messaggio "Hi nomeStudente" in un messageBox
 * 
 * @author Adriano Luchetta 
 * @version 6-Ott-2007
 */

import javax.swing.JOptionPane;

public class OK
{
    public static void main(String[] args)
    {
       String nomeStudente =  JOptionPane.showInputDialog(null, "", "INSERISCI IL TUO NOME", JOptionPane.INFORMATION_MESSAGE);
       JOptionPane.showMessageDialog(null, "OK " + nomeStudente +", hai compilato ed eseguito correttamente!");
       System.exit(0);
    }    
}
