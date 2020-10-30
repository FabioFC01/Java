import java.util.Scanner;

public class TriangularNumber {
    public static void main (String[] args){
        System.out.print("Inserire numero di numeri triangolari da stampare :");
        //open flow
        Scanner in = new Scanner (System.in);
        int max = in.nextInt();

        System.out.println("------------------------------------------------------");
        System.out.println();

        //close flow
        in.close();

        //declaration
        int result = 0;
        for (int i = 1; i <= max; i++){
            result += i;
            System.out.println(result);
        }

    }
}