import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class METest {
    public static void main (String [] args) throws IOException{
        Scanner in = new Scanner (new FileReader("Airlines.txt"));
        ME <String, String> mappa1 = new ME <String, String>  ();

        String compagnia = "";
        String città = "";
        while (in.hasNextLine()){
            compagnia = in.next();
            città = in.next();

            mappa1.put(compagnia, città);
        }
        
        Object [] v = mappa1.keySet();  //compagnia
        Object [] values = mappa1.values(); //città


        System.out.println("SIZE : "+ mappa1.size()); //yes

        System.out.println("ENTRIES : "); //yes
        for (Object chiave : v){
            città = mappa1.get((String)chiave);
            System.out.print(chiave +" / " + città + "\n");
        } //yes
        System.out.println();
        System.out.println();



        System.out.println("VALUES : ");
        for (Object valori : values){
            System.out.print(valori +"   ");
        } //yes
        System.out.println();
        System.out.println();


        Object [] valuesOrdinati = mappa1.valueSet();
        System.out.println("VALUES SET  : ");
        for (Object val : valuesOrdinati){
            System.out.print(val + "   ");
        }
        System.out.println(); ///YESSSSSSS
        System.out.println();


        System.out.println("REMOVE : ");
        for (Object chiave : v) { 
            //compagnia
            System.out.print(chiave  +" / " +  mappa1.remove((String)chiave) + "  ---  ");
        } //yes
        System.out.println();
        System.out.println();

        System.out.println(" SIZE : " + mappa1.size());

        System.out.println("--- END OF PROGRAM ---");

        //funziona tutto
    }
}