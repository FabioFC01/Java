import java.util.Scanner;
import java.util.NoSuchElementException;

public class TextContainer {
    // parte privata
     
    //parte privata
    private static final int INITIAL_CAPACITY = 1;
    private String[] v;/* riferimento ad array */
    private int vSize;  //num di elementi già nell'array

    //costruttore
    public TextContainer() {
        v = new String [INITIAL_CAPACITY];
        vSize = 0;
    }

    /**
     inserisce una riga nel contenitore di testo
    @param aLine la riga da inserire
    */
    public void add(String aLine){
        if (aLine == null){
            return;
        }
        //se l'array è già pieno
        if(vSize >= v.length){
            String [] newV = new String [ 2 * v.length];  //elementi raddoppiati
            for (int i = 0; i < vSize; i++){
                newV[i] = v[i];
            }
            //si cambia la variabile riferimento
            v = newV;
        }
        //inserimento stringa
        v[vSize] = aLine;
        //incremento
        vSize++;
    }

    /**
     estrae la prima riga del testo
    @return la prima riga del testo se il contenitore non
    e' vuoto, altrimenti genera l'eccezione
    NoSuchElementException
    NB: ad ogni estrazione si compatta a sinistra
    l’array!
    @throws NoSuchElementException
    */
    public String remove() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        //appoggio temp. dell'elemento di indice 0
        String temp = v[0];
        //eliminazione elemento indice 0
        for (int i = 0; i < vSize-1 ; i++){
            v[i] = v[i+1];
        }
        v[vSize-1] = null;
        vSize--;
        //oggetto di ritorno
        return temp;
    }

    /**
     verifica se il contenitore e' vuoto
    @return true se il contenitore e‘
    vuoto, altrimenti false
    */
    public boolean isEmpty() {
        return vSize <= 0; //espressione logica
    }

    /**
     sostituisce nel testo una parola con
    un'altra
    @param find la parola da sostituire
    @param replacement la parola sostitutiva
    @return il numero di sostituzioni eseguite
    @throws IllegalArgumentException
    */
    public int replace(String find, String replacement) {
        if (find == null || replacement == null){
            throw new IllegalArgumentException();
        }

        int count = 0; //contatore parole sostituite
        
        //ciclo
        for (int i = 0; i < vSize; i++){
            Scanner st = new Scanner (v[i]); //flusso aperto
            String tempLine = "";            //stringa vuota
            boolean found = false;

            while(st.hasNext()){            //si scorre la stringa
                String token = st.next();
                if (token.equals(find)){    //se i due token corrispondono
                    token = replacement;
                    count++;                //incremento
                    found = true;
                }
                tempLine = tempLine + token + " ";
                System.out.println(tempLine);
            }
            if (found){
                v[i] = tempLine;
            }
            st.close();
        }

        return count;
    }
    
    public int Stampa (){
    	return (this.vSize);
    }
    
    public String GetString (int indice) {
    	return this.v[indice];
    }
}
