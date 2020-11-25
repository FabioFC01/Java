import java.util.Scanner;
import java.util.NoSuchElementException;

public class StudentSortedContainer implements Container {
    //declaration
    private static final int INITIAL_SIZE = 1;
    private Studente [] studenti;
    private int aSize;

    //costructor
    public StudentSortedContainer () {
        makeEmpty();
    }

    //metodo isEmpty()
    public boolean isEmpty() {
        return aSize == 0;
    }

    //metodo makeEmpty
    public void makeEmpty() {
        studenti = new Studente [INITIAL_SIZE];
        aSize = 0;
    }

    //metodo size
    public int size() {
        return aSize;
    }

    //metodo add primo
    public void add(java.lang.String nome, int matr) {
        if(nome == null) {
            throw new IllegalArgumentException();
        }
        if (aSize >= studenti.length) {
            studenti = resize(studenti, 2 * studenti.length);
        }
        Studente temp = new Studente(nome, matr);

        if(isEmpty()){
            studenti[0] = temp;
            aSize++;
            return;
        }
        
        int i;
        //ordine decrescente di matricola - FUNZIONA
        for (i = aSize; i>0 && temp.compareTo(studenti[i-1]) > 0; i-- ){
            studenti [i] = studenti [i-1];
        }
        studenti [i] = temp;
        aSize++;
    }

    //metodo add secondo
    public void add(String studentString, String delimiters){
        if(studentString == null){
            throw new IllegalArgumentException();
        }
        Scanner in = new Scanner (studentString);
        in.useDelimiter("[" + delimiters + "]+");
        String nome, matricola;
        if(in.hasNext()){
            nome = in.next();
        }
        else {
            in.close();
            throw new NoSuchElementException();
        }
        if(in.hasNext()){
            matricola = in.next();
        }
        else {
            in.close();
            throw new NoSuchElementException();
        }
        in.close();

        this.add(nome, Integer.parseInt(matricola));
    }

    //metodo resize
    private Studente [] resize (Studente [] old, int newLength){
        int min = old.length < newLength ? old.length : newLength;
        Studente [] nuovo = new Studente [newLength];

        for (int i = 0; i < min; i++){
            nuovo[i] = old[i];
        }

        return nuovo;
    }

    //metodo println
    public String toString () {
        String temp = "";
        //stampa con indici crescenti
        for (int i = 0; i < aSize; i++){
            temp += studenti[i].toString() + "\n";
        }
        return temp;
    }

    //metodo findName
    public String findName(int matr) {
        for (int i = 0; i < aSize; i++) {
            if (studenti[i].matricola() == matr){
                return studenti[i].nome();
            }
        }
        throw new NoSuchElementException();
    }

    //metodo removeMin
    public Studente removeMin() {
        if(aSize == 0){
            throw new NoSuchElementException();
        }
        Studente temp = studenti[aSize-1];
        studenti[aSize-1] = null;
        aSize--;
        return temp;
    }




    public static void main (String [] args){
        StudentSortedContainer test = new StudentSortedContainer();
        test.add("Antonio", 5060);
        test.add("Monica Lovato", 5061);
        test.add("Fabio", 5062);
        test.add("Luigi", 5063);
        test.add("Ciccione", 5064);
        test.add("Antonina", 5065);
        //fin qui funziona

        System.out.println(test.isEmpty()); //false
        System.out.println(test.size());    // 6
        System.out.println(test);

        //fin qui ok
        test.makeEmpty();
        System.out.println(test);
        //ok

        test.add("Fabio/7845", "/");
        test.add("Fabiuccio/7846", "/");
        test.add("Fabio-7842", "-");
        test.add("Fabia?7843", "?");
        test.add("Elisa:7844", ":");
        test.add("Fabio-7841", "-");

        System.out.println(test.isEmpty()); //false
        System.out.println(test.size());    // 6
        System.out.println(test);
        //ok

        System.out.println(test.findName(7844));    //Elisa
        //ok

        System.out.println(test.removeMin());   // 7841 : Fabio - ok

        System.out.println(test.isEmpty()); //false
        System.out.println(test.size());    // 5
        System.out.println(test);

        test.makeEmpty();

        System.out.println(test.isEmpty()); //true
        System.out.println(test.size());    // 0
        System.out.println(test);

        //FIN QUI TUTTO BENEE
        //Testiamo da file txt
        Scanner in = new Scanner (System.in);
        while(in.hasNextLine()){
            test.add(in.nextLine(), ":");
        }
        in.close();

        System.out.println(test.isEmpty()); //false
        System.out.println(test.size());    // 7
        System.out.println(test);


    }
}
