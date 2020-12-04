public class RandomSequence implements Sequence {
    public int next () {
        return (int) (Integer.MAX_VALUE * Math.random());
        //Math.random () -->  0 <= x < 1
        //ritorna valore tra 0 e Integer.MAX_VALUE in int
    }
}
