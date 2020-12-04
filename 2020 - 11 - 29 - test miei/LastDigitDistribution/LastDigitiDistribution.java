public class LastDigitiDistribution {
    private int [] counters;
    private static final int ARRAY_LENGTH = 10;

    public LastDigitiDistribution(){
        counters = new int[ARRAY_LENGTH];
    }

    public void process (Sequence seq, int valuesToProcess){
        for (int i = 1; i <= valuesToProcess; i++){
            int value = seq.next();
            int lastDigit = value % 10; //si prende l'ultima cifra
            counters[lastDigit]++;
            //praticamente l'array di 10 conta le ultime cifre
        }
    }

    public void display (){
        for (int i = 0; i < ARRAY_LENGTH; i++){
            System.out.println(i + " : " + counters[i]);
        }
    }
}