import java.util.Scanner;

public class MontyHallTester {
    public static void main (String [] args){
        Scanner in = new Scanner (System.in);
        //Initialization
        int repetition;

        System.out.print("Quante ripetizioni del MontyHall vuoi fare? ");
        repetition = in.nextInt();

        //close flow
        in.close();

        MontyHallRepetition ciaone = new MontyHallRepetition(repetition);
        String ritorno = ciaone.Test();

        System.out.println(ritorno);
    }
}