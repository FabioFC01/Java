import java.util.Scanner;

public class TextContainerTester {
    public static void main (String [] args){
        //standard input
        Scanner in = new Scanner(System.in);
        //istanza oggetto di classe TextContainer
        TextContainer text = new TextContainer();
        //legge e stampa il testo da standard input
        System.out.println("\n*** TESTO ORIGINALE ***");
        while(in.hasNextLine())  {
             String line = in.nextLine();
            text.add(line);
            System.out.println(line);
        }

        //close flow
        in.close();
        
        System.out.println("\n***FINE TESTO ORIGINALE***");
        
	System.out.println(text.Stampa());
        System.out.println(text.GetString(5));
        System.out.println(text.GetString(6));
        System.out.println(text.GetString(7));
        System.out.println(text.GetString(8));
        
        //sostituzione parola
        int n = 0;
        if (args.length > 1) {  // se ci sono almeno 2 arg.
             System.out.println("\n*** TESTO MODIFICATO: ***");
            System.out.println("sostituzione di " + args[0] + " con " + args[1]);
            n = text.replace(args[0], args[1]);
        }

        //invio a standard output
        System.out.println();
        while(!text.isEmpty())
            System.out.println(text.remove());

        System.out.println("\n**FINE TESTO MODIFICATO**\n");
        System.out.println("n. " + n + " sost. effettuate");
        
       
       }
        
        
}


/*
fabio@ubuntu:~/Documents/lab/lab7/TextContainer$ java TextContainerTester < Dante.txt la cicca

*** TESTO ORIGINALE ***
LA DIVINA COMMEDIA
di Dante Alighieri
INFERNO

Inferno: Canto I

  Nel mezzo del cammin di nostra vita
mi ritrovai per una selva oscura
ché la diritta via era smarrita.
  Ahi quanto a dir qual era è cosa dura
esta selva selvaggia e aspra e forte
che nel pensier rinova la paura!
  Tant'è amara che poco è più morte;
ma per trattar del ben ch'i' vi trovai,
dirò de l'altre cose ch'i' v'ho scorte.
  Io non so ben ridir com'i' v'intrai,
tant'era pien di sonno a quel punto
che la verace via abbandonai.
  Ma poi ch'i' fui al piè d'un colle giunto,
là dove terminava quella valle
che m'avea di paura il cor compunto,
  guardai in alto, e vidi le sue spalle
vestite già de' raggi del pianeta
che mena dritto altrui per ogne calle.
  Allor fu la paura un poco queta
che nel lago del cor m'era durata
la notte ch'i' passai con tanta pieta.
  E come quei che con lena affannata
uscito fuor del pelago a la riva
si volge a l'acqua perigliosa e guata,
  così l'animo mio, ch'ancor fuggiva,
si volse a retro a rimirar lo passo
che non lasciò già mai persona viva.

***FINE TESTO ORIGINALE***
33

  Nel mezzo del cammin di nostra vita
mi ritrovai per una selva oscura
ché la diritta via era smarrita.

*** TESTO MODIFICATO: ***
sostituzione di la con cicca
LA 
LA DIVINA 
LA DIVINA COMMEDIA 
di 
di Dante 
di Dante Alighieri 
INFERNO 
Inferno: 
Inferno: Canto 
Inferno: Canto I 
Nel 
Nel mezzo 
Nel mezzo del 
Nel mezzo del cammin 
Nel mezzo del cammin di 
Nel mezzo del cammin di nostra 
Nel mezzo del cammin di nostra vita 
mi 
mi ritrovai 
mi ritrovai per 
mi ritrovai per una 
mi ritrovai per una selva 
mi ritrovai per una selva oscura 
ché 
ché cicca 
ché cicca diritta 
ché cicca diritta via 
ché cicca diritta via era 
ché cicca diritta via era smarrita. 
Ahi 
Ahi quanto 
Ahi quanto a 
Ahi quanto a dir 
Ahi quanto a dir qual 
Ahi quanto a dir qual era 
Ahi quanto a dir qual era è 
Ahi quanto a dir qual era è cosa 
Ahi quanto a dir qual era è cosa dura 
esta 
esta selva 
esta selva selvaggia 
esta selva selvaggia e 
esta selva selvaggia e aspra 
esta selva selvaggia e aspra e 
esta selva selvaggia e aspra e forte 
che 
che nel 
che nel pensier 
che nel pensier rinova 
che nel pensier rinova cicca 
che nel pensier rinova cicca paura! 
Tant'è 
Tant'è amara 
Tant'è amara che 
Tant'è amara che poco 
Tant'è amara che poco è 
Tant'è amara che poco è più 
Tant'è amara che poco è più morte; 
ma 
ma per 
ma per trattar 
ma per trattar del 
ma per trattar del ben 
ma per trattar del ben ch'i' 
ma per trattar del ben ch'i' vi 
ma per trattar del ben ch'i' vi trovai, 
dirò 
dirò de 
dirò de l'altre 
dirò de l'altre cose 
dirò de l'altre cose ch'i' 
dirò de l'altre cose ch'i' v'ho 
dirò de l'altre cose ch'i' v'ho scorte. 
Io 
Io non 
Io non so 
Io non so ben 
Io non so ben ridir 
Io non so ben ridir com'i' 
Io non so ben ridir com'i' v'intrai, 
tant'era 
tant'era pien 
tant'era pien di 
tant'era pien di sonno 
tant'era pien di sonno a 
tant'era pien di sonno a quel 
tant'era pien di sonno a quel punto 
che 
che cicca 
che cicca verace 
che cicca verace via 
che cicca verace via abbandonai. 
Ma 
Ma poi 
Ma poi ch'i' 
Ma poi ch'i' fui 
Ma poi ch'i' fui al 
Ma poi ch'i' fui al piè 
Ma poi ch'i' fui al piè d'un 
Ma poi ch'i' fui al piè d'un colle 
Ma poi ch'i' fui al piè d'un colle giunto, 
là 
là dove 
là dove terminava 
là dove terminava quella 
là dove terminava quella valle 
che 
che m'avea 
che m'avea di 
che m'avea di paura 
che m'avea di paura il 
che m'avea di paura il cor 
che m'avea di paura il cor compunto, 
guardai 
guardai in 
guardai in alto, 
guardai in alto, e 
guardai in alto, e vidi 
guardai in alto, e vidi le 
guardai in alto, e vidi le sue 
guardai in alto, e vidi le sue spalle 
vestite 
vestite già 
vestite già de' 
vestite già de' raggi 
vestite già de' raggi del 
vestite già de' raggi del pianeta 
che 
che mena 
che mena dritto 
che mena dritto altrui 
che mena dritto altrui per 
che mena dritto altrui per ogne 
che mena dritto altrui per ogne calle. 
Allor 
Allor fu 
Allor fu cicca 
Allor fu cicca paura 
Allor fu cicca paura un 
Allor fu cicca paura un poco 
Allor fu cicca paura un poco queta 
che 
che nel 
che nel lago 
che nel lago del 
che nel lago del cor 
che nel lago del cor m'era 
che nel lago del cor m'era durata 
cicca 
cicca notte 
cicca notte ch'i' 
cicca notte ch'i' passai 
cicca notte ch'i' passai con 
cicca notte ch'i' passai con tanta 
cicca notte ch'i' passai con tanta pieta. 
E 
E come 
E come quei 
E come quei che 
E come quei che con 
E come quei che con lena 
E come quei che con lena affannata 
uscito 
uscito fuor 
uscito fuor del 
uscito fuor del pelago 
uscito fuor del pelago a 
uscito fuor del pelago a cicca 
uscito fuor del pelago a cicca riva 
si 
si volge 
si volge a 
si volge a l'acqua 
si volge a l'acqua perigliosa 
si volge a l'acqua perigliosa e 
si volge a l'acqua perigliosa e guata, 
così 
così l'animo 
così l'animo mio, 
così l'animo mio, ch'ancor 
così l'animo mio, ch'ancor fuggiva, 
si 
si volse 
si volse a 
si volse a retro 
si volse a retro a 
si volse a retro a rimirar 
si volse a retro a rimirar lo 
si volse a retro a rimirar lo passo 
che 
che non 
che non lasciò 
che non lasciò già 
che non lasciò già mai 
che non lasciò già mai persona 
che non lasciò già mai persona viva. 

LA DIVINA COMMEDIA
di Dante Alighieri
INFERNO

Inferno: Canto I

  Nel mezzo del cammin di nostra vita
mi ritrovai per una selva oscura
ché cicca diritta via era smarrita. 
  Ahi quanto a dir qual era è cosa dura
esta selva selvaggia e aspra e forte
che nel pensier rinova cicca paura! 
  Tant'è amara che poco è più morte;
ma per trattar del ben ch'i' vi trovai,
dirò de l'altre cose ch'i' v'ho scorte.
  Io non so ben ridir com'i' v'intrai,
tant'era pien di sonno a quel punto
che cicca verace via abbandonai. 
  Ma poi ch'i' fui al piè d'un colle giunto,
là dove terminava quella valle
che m'avea di paura il cor compunto,
  guardai in alto, e vidi le sue spalle
vestite già de' raggi del pianeta
che mena dritto altrui per ogne calle.
Allor fu cicca paura un poco queta 
che nel lago del cor m'era durata
cicca notte ch'i' passai con tanta pieta. 
  E come quei che con lena affannata
uscito fuor del pelago a cicca riva 
si volge a l'acqua perigliosa e guata,
  così l'animo mio, ch'ancor fuggiva,
si volse a retro a rimirar lo passo
che non lasciò già mai persona viva.

**FINE TESTO MODIFICATO**

n. 6 sost. effettuate




*/
