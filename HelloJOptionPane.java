/**
 * La classe HelloJOptionPane invia in una finestra la stringa "Hello, World!"
 * 
 * @author Adriano Luchetta 
 * @version 3-Ott-2003
 */

import javax.swing.JOptionPane;

public class HelloJOptionPane
{
    public static void main(String[] args)
    {
       JOptionPane.showMessageDialog(null, "Hello, World!");      
       System.exit(0);
    }    
}
