//Import
import java.lang.Math; 
import java.util.Scanner;

public class Compleanni{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        //First line written
        System.out.print("Insert number of people:  ");

        //dichiarazione variabili
       final int persone = scan.nextInt();          //THE MOST important variable in this program
       scan.close();

        final int daysInAYear = 367;  //perchè Math.random crea tra 0 e 1, 1 non compreso
        int [] days = new int [367];    //array for every day of the year to control bDays
        int [] people = new int [persone];
        int bDay = 0;
        double sameBDay = 0;
        double peopleWithSameBDays = 0;

        //Genera numeri interi casuali tra 0 e 366, ovvero le date di compleanno
        for(int i = 0; i < persone; i++){
            people [i] = (int)((Math.random()) * daysInAYear);
        }

        //Control how many people have bday on the same day
        for (int i = 0; i < persone; i++){
            bDay = people[i];
            days[bDay]++;
        }

        //Do the calculations
        for(int i = 0; i <= 366; i++){
            if(days[i] > 1){
                sameBDay = sameBDay + 1;
                peopleWithSameBDays += (days[i]);  
            }

        }
        //Output
        System.out.println();
        System.out.println("----------------         Final results          -----------------");
        System.out.println (persone  +  "  people.");
        System.out.println (sameBDay + "   days with more than one birthday.");
        System.out.println ((sameBDay/(3.66)) + "% of the days had some shared bdays.");
        System.out.println (peopleWithSameBDays + "   people had their BDays shared with at least one other person.");
        System.out.println((double)(peopleWithSameBDays/(persone)*100) + "  %  of people had their BDays shared ");
        System.out.println();

    }
}