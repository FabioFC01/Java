import javax.swing.JOptionPane;

public class Echo{
    public static void main(String[] args){
        //String drom dialog box
        //showInputDialog is a static method
        String s = JOptionPane.showInputDialog("Insert a string");

        //Send string to message box
        JOptionPane.showMessageDialog(null, s);

        //String is sent to standard output
        System.out.println(s);

        //JVM execution will be stopped
        System.exit(0);
    }
}