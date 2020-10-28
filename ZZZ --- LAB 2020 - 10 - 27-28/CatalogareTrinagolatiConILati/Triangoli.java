import java.util.Scanner;
import java.lang.Math;

public class Triangoli{
    public static void main (String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);

        //Input and declaration
        System.out.print("Inserire lato 1 del triangolo : ");
        double l1 = in.nextDouble();
        System.out.print("Inserire lato 2 del triangolo : ");
        double l2 = in.nextDouble();
        System.out.print("Inserire lato 3 del triangolo : ");
        double l3 = in.nextDouble();

        double MAX = 0;
        double medio = 0;
        double min = 0;
        double catetiSommati = 0;
        boolean latiTuttiDiversi = false;

        //Close flow
        in.close();

        //Calculation
        //Max lato
        if(l1 >= l2 && l1 >= l3){
            MAX = l1;
            if(l2 >= l3){
                medio = l2;
                min = l3;
            }
            else{
                medio = l3;
                min = l2;               
            }
            
        }
        if(l2 >= l1 && l2 >= l3){
            MAX = l2;
            if(l1 >= l3){
                medio = l1;
                min = l3;                
            }
            else{
                medio = l3;
                min = l1;                
            }
        }
        if (l3 >= l1 && l3 >= l2){
            MAX = l3;
            if(l1 >= l2){
                medio = l1;
                min = l2;                
            }
            else{
                medio = l2;
                min = l1;
            }
        }

        //Verify that it's a triangle
        if (MAX >= (medio + min)){
            System.out.println("Non è un triangolo");
            return;
        }

        //Trinagolo equilatero
        if (l1 == l2 && l2 == l3){
            System.out.print("Triangolo equilatero");
        }

        //calcola la rad. quadrata dei cateti
        catetiSommati = Math.sqrt((medio*medio)+(min*min));

        //controlla se i lati sono tutti diversi
        if(l1 != l2 && l2 != l3 && l1 != l3){
            latiTuttiDiversi = true;
        }

        if(catetiSommati == MAX && latiTuttiDiversi){
            System.out.println("Triangolo scaleno rettangolo");
        }

        if(l1 == l2 ^ l2 == l3) {
            System.out.print("Triangolo isoscele");
        }
        if((MAX*MAX) - (catetiSommati*catetiSommati) > 0 ){
            System.out.println(" ottusangolo");
        }
        if((MAX*MAX) - (catetiSommati*catetiSommati) < 0 ){
            System.out.println(" acutangolo");
        }


    }
}