public class Numeri {
    public static void main (String [] args){
        for (int i = 1; i <= 200; i++){
            if(i % 10 != 0){
                if(i < 10){
                    System.out.print(i + "     ");
                }
                else if (i < 100){
                    System.out.print(i + "    ");
                }
                else{
                    System.out.print(i + "   ");
                }
            }
            else{
                System.out.println(i);
            }
        }
    }
}