import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class Time {
    public static void main(String[] args) {
        String format = "%-8.8s";

        //Varie zone
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");

        //prende l'ora di adesso e i vari fusi orari
        LocalTime now = LocalTime.now();
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println("Current Time : " + now);
        System.out.println("Berlin Time : " + now1);
        System.out.println("Brazil Time : " + now2);

        //calcola i minuti tra Berlino e Brasile
        long minutesBetween = ChronoUnit.MINUTES.between(now2, now1);

        //calcola le ore tra Berlino e Brasile
        long hoursBetween = ChronoUnit.HOURS.between(now2, now1);

        //Output
        System.out.println("Minutes Between Berlin and Brazil : " + minutesBetween +"mins");
        System.out.println("Hours between Berlin and Brasil   : " + hoursBetween ) ;

        //Prende l'ora dopo qualche comando
        LocalTime ora = LocalTime.now();

        //Calcola tempo passato
        float durationCommands = ChronoUnit.MICROS.between(now, ora);

        //Ora attuale e distacco dall'inizio programma
        System.out.println("Current Time : " + ora);
        System.out.println("---------------------------");
        System.out.println();
        System.out.println( "Time between 9 istuctions in microseconds  :  " + durationCommands);
        System.out.println( "Time between 9 istuctions in milliseconds  :  " + durationCommands/1000);
        System.out.println( "Time between 9 istuctions in seconds       :  " + durationCommands/1000000);



    }
}

/*
Current Time : 19:44:00.501017700
Berlin Time : 19:44:00.504009700
Brazil Time : 14:44:00.504009700
Minutes Between Berlin and Brazil : 300mins
Hours between Berlin and Brasil   : 5
Current Time : 19:44:00.506002800
---------------------------

Time between 9 istuctions in microseconds  :  4985.0
Time between 9 istuctions in milliseconds  :  4.985
Time between 9 istuctions in seconds       :  0.004985
*/