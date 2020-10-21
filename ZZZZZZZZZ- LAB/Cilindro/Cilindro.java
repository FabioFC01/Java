public class Cilindro{
    public static void main (String [] args){
        final double raggio = 10.12;
        final double altezza = 10.87;

        //calculations
        double volume = Math.pow(raggio, 2) * Math.PI * altezza;
        double area = (raggio * 2.0 * Math.PI * altezza) + (2.0 * Math.pow(raggio, 2) * Math.PI);

        //output
        System.out.println("Area : " + area);
        System.out.println("Volume : " + volume);
    }
}