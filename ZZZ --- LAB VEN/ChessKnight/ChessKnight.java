public class ChessKnight {
    //private String position;
    //private boolean isReachable;
    private char X;
    private char Y;
    private int xPos;  //a-h
    private int yPos;  //1-8

    ChessKnight(String initial){
        X = initial.charAt(0);
        Y = initial.charAt(1);

        xPos = (int) X;
        yPos = (int) Y;
    }

    public boolean chessValidSquare (int x, int y){
        //a --> 97
        //h --> 104

        //1 --> 49
        //8 --> 56

        boolean let = false;
        boolean num = false;
       

        if (x >= 97 && x <= 104){
            let = true;
        }
        if (y >= 49 && y <= 56){
            num = true;
        }

        if (let == true && num == true){
            return true;
        }
        else{
            System.out.println("Casa non valida");
            return false;
        }
    }

    public boolean reachable (int x, int y, int xPos, int yPos){
        //tutte le 8 massime mosse possibili
        if((x - xPos == 1) && (y - yPos == 2)){
            return true;
        }
        if((x - xPos == 2) && (y - yPos == 1)){
            return true;
        }
        if((x - xPos == 2) && (y - yPos == -1)){
            return true;
        }
        if((x - xPos == 1) && (y - yPos == -2)){
            return true;
        }
        if((x - xPos == -1) && (y - yPos == -2)){
            return true;
        }
        if((x - xPos == -2) && (y - yPos == -1)){
            return true;
        }
        if((x - xPos == -2) && (y - yPos == 1)){
            return true;
        }
        if((x - xPos == -1) && (y - yPos == 2)){
            return true;
        }

        //mossa impossibile
        return false;

    }

    public void moveToSquare (String mossa){
        char X = mossa.charAt(0);
        char Y= mossa.charAt(1);

        int x = (int) X;
        int y = (int) Y;

        boolean valid = chessValidSquare(x, y);
        boolean reachable = reachable(x, y, xPos, yPos);
        if (valid == true){
            if (reachable == true){
                //la mossa è possibile
                xPos = x;
                yPos = y;
            }
            else {
                //mossa impossibile
                System.out.println ("Casa non raggiungibile");
            }
        }

    }
/*
    public void getPosition (){
        System.out.print((char)xPos);
        System.out.print((char)yPos);
        System.out.println();
    }
*/
    
    public String toString() {
        char a = (char)xPos;
        char b = (char)yPos;
        String ret = Character.toString(a) + Character.toString(b);
        return ret;
    }
    
}
