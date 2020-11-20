import java.util.Random;
import javax.swing.JOptionPane;

public class RecursiveMinFinder {
    public static void main (String [] args) {
        //inserisci grandezza array e val. massimo
        Random rand = new Random();
        int GRANDEZZA = Integer.parseInt(args[0]);
        int MAX       = Integer.parseInt(args[1]);
        int [] a = new int [GRANDEZZA];

        String exitString = "Dim : " + GRANDEZZA;
        exitString += "\n" + "Max : " + MAX;
        exitString += "\n";
        exitString += "Array : [ ";

        //riempine 50
        for (int i = 0; i < GRANDEZZA; i++){
            a[i] = rand.nextInt(MAX);
            System.out.println (a[i]);
            exitString += a[i] + "  ";
        }
        exitString += " ]";

        int min = recursivelyFindMin(a, GRANDEZZA);
        System.out.println ("------------------------");

        exitString += "\n";
        exitString += "Valore minimo : " + min;
        System.out.println (min);

        JOptionPane panel = new JOptionPane(exitString);
        panel.showMessageDialog(null, exitString);
    }

    private static int recursivelyFindMin(int[] a, int aSize) {
        if (aSize == 0) {
            throw new IllegalArgumentException();
        }
        if (aSize == 1){
            return a[0];
        } 
        else {
            int nostroMin = a[aSize-1];
            int minRec = recursivelyFindMin(a, aSize-1);
            if (minRec < nostroMin) {
                return minRec;
            }
            else {
                return nostroMin;
            }
        }
    }
}