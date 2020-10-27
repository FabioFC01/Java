import java.util.Scanner;

public class MainCalendario{
    public static void main(String [] args){
        //Open flow
        Scanner in = new Scanner (System.in);
    
        System.out.println("Inserire data in formato gg/mm/yyyy");
        String data = in.nextLine();

        //Close flow
        in.close();

        //New object
        Calendario cale = new Calendario(data);

        //Output
        System.out.println("Giorno della settimana corrispondente a quel giorno : " + cale.giornoDellaSettimana());
        System.out.println("Giorni passati da quel giorno : " + cale.giorniDa());

        
    }
}

/*
Inserire data in formato gg/mm/yyyy
20/03/2001
Giorno della settimana corrispondente a quel giorno : Martedi'
Giorni passati da quel giorno : 7161
*/