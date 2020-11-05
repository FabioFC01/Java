public class MyCircle {
    //declarations
    private double x;
    private double y;
    private double r;

    //costructors
    public MyCircle (double xc, double yc, double radius){
        x = xc;
        y = yc;
        r = radius;
    }

    //verifica se questo cerchio e il cerchio specificato sono coincidenti
    public boolean 	isCoincident​(MyCircle c) {
        if ((x == c.x) && (y == c.y) && (r == c.r)){
            return true;
        }
        else{
            return false;
        }
    }

    //verifica se questo cerchio e' interno al cerchio specificato
    public boolean 	isEncircled​(MyCircle c) {
        //bisogna che OO' < R.impl - r.expl
        double distanceBetweenOrigins = Math.sqrt( ((x - c.x)*(x - c.x)) + ((y - c.y)*(y - c.y)) );
        if(r < c.r){
            return ( distanceBetweenOrigins < (c.r - r) );
        }
        else{
            return false;
        }    
    }

    //verifica se questo cerchio e il cerchio specificato sono esterni
    public boolean 	isExternal​(MyCircle c) {
        //bisogna che OO' > R + r
        double distanceBetweenOrigins = Math.sqrt( ((x - c.x)*(x - c.x)) + ((y - c.y)*(y - c.y)) );
        return ( distanceBetweenOrigins > ( r + c.r ) );
    }


    //verifica se questo cerchio e il cerchio specificato sono secanti, ovvero se hanno due punti in comune.
    public boolean 	isSecant​(MyCircle c) {
        //|R – r| < OO’ < r + R

        //calcola |R - r|
        double distanceBetweenOrigins = Math.sqrt( ((x - c.x)*(x - c.x)) + ((y - c.y)*(y - c.y)) );
        double differenceRadius = 0;
        if ( r > c.r){
            differenceRadius = r - c.r;
        }
        else{
            differenceRadius = c.r - r;
        }

        return ((distanceBetweenOrigins > (differenceRadius)) && (distanceBetweenOrigins < (r + c.r) ) );
    }

    //verifica se questo cerchio e il cerchio specificato sono tangenti, ovvero se hanno un solo punto in comune.
    public boolean 	isTangential​(MyCircle c) {
        //|R – r| = OO’   ||   OO’ = r + R

        //calcola |R - r|
        double distanceBetweenOrigins = Math.sqrt( ((x - c.x)*(x - c.x)) + ((y - c.y)*(y - c.y)) );
        double differenceRadius = 0;
        if ( r > c.r){
            differenceRadius = r - c.r;
        }
        else{
            differenceRadius = c.r - r;
        }
        return ( (differenceRadius == distanceBetweenOrigins) || (distanceBetweenOrigins == (r + c.r)) );
    }

    public String 	toString() {
        //O=(..,...) r=..
        String finale = "O=(" + x + "," + y + ") r=(" + r + ")";
        return finale;
    }
}