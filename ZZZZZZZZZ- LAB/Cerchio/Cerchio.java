public class Cerchio{
    public static void main(String [] args){
        //declaration
        final double raggio = 10.12;
        final double pi = 3.14159265358979;
        double circonferenza;
        double area;

        //calcolo
        circonferenza = 2.0* raggio * pi;
        area = raggio*raggio*pi;

        //output
        System.out.println("La circonferenza del cerchio di raggio " + raggio + " e' : " + circonferenza);
        System.out.println("L'area del cerchio di raggio " + raggio + " e' : " + area);

    }
}