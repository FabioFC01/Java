//package mappaArray;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FC {
	public static void main(String[]args) throws FileNotFoundException {
		Scanner tok = new Scanner(new FileReader("animali.txt")).useDelimiter("[^a-zA-Z]+");
		MyMap mappa = new MyMap();
		while(tok.hasNext()) {
			String parola = tok.next();
			if(mappa.get(parola) != null) {
				int contatore = (int) mappa.get(parola);
				contatore++;
				mappa.put(parola, contatore);
			} else {
				mappa.put(parola,1);
			}
		}
		Object[] chiavi = mappa.keys();
		for (Object c : chiavi ) {
			System.out.println(c + " " + mappa.get(c));
		}
	}
}
/*
oca 1
lupo 2 
gatto 3
falco 4
cane 5 
 */