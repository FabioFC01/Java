public class SequenceDemo {
    public static void main (String [] args){
        LastDigitiDistribution dist1 = new LastDigitiDistribution();
        //process vuole una variabile Sequence, SquareSequence lo implementa
        dist1.process(new SquareSequence(), 1000);
        dist1.display();
        System.out.println();

        LastDigitiDistribution dist2 = new LastDigitiDistribution();
        dist2.process(new RandomSequence(), 1000);
        dist2.display();
    }
}