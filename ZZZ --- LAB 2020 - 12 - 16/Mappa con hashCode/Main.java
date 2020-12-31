public class Main {
    public static void main (String [] args){
        M <Integer, String> mappa = new M <Integer, String> ();
        System.out.println(mappa.isEmpty());
        mappa.put(20, "Ciao");
        mappa.put(21, "Bella");
        String ritorno = mappa.get(21);
        Object [] bella = mappa.keys();
        System.out.println(ritorno);
        //sta roba funziona
    }
}