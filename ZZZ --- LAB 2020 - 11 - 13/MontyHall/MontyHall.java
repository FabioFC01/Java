public class MontyHall {
    //declaration
    private boolean [] doors = new boolean [3];
        //true - car
        //false - goat
    int choice; //first door choice
    int opened; // first door opened
    

    //costructor
    public MontyHall () {
        for (int x = 0; x < doors.length; x++) {
            doors[x] = false;
        }
        int car = (int)(Math.random() * (3)); // between 0 and 2

        doors [car] = true;

        choice = -1;
        opened = -1;

        //output
        for (int x = 0; x < doors.length; x++) {
            if(doors[x] == false) {
                System.out.println("Goat");
            }
            if(doors[x] == true) {
                System.out.println("Car");
            }
        }
    }

    public void firstChoice () {        
        //scegli la prima porta, apre un'altra con goat
        choice = (int)(Math.random() * (3)); // between 0 and 2
        //output first choice
        System.out.println("First choice : " + (choice +1));

        if (doors[choice] == false) { //se la scelta è goat
            for (int j = 0; j < doors.length; j++){
                if ((doors[j] == false) && ( j != choice) ) {
                    opened = j;             //opened è l'altra goat
                }
            }
        }

        if (doors[choice] == true) { //se la scelta è car
            int [] goat = new int [2]; // array con pos. di goat
            int contatore = 0; 
            for (int j = 0; j < doors.length; j++){
                if (doors[j] == false) {
                    goat [contatore] = j;
                    contatore++;
                }
            }

            //scelta casuale
            int secondChoice = (int) (Math.random()* (2)); // between 0 and 1

            // scelta
            opened = goat[secondChoice];    //opened prende un goat casuale tra i due

            
        }

        //output opened
            if(doors[opened] == false) {
                System.out.println("Opened : Goat  (" + (opened +1) + ")");
            }
            if(doors[opened] == true) {
                System.out.println("Opened : Car   (" + (opened +1) + ")");
            }
    }

    public void KeepOrChange () {
        //tieni la porta scelta o scegli l'altra rimasta
        boolean choice2 = false;
            //false = keep
            //true = change
        int rand = (int)(Math.random() * (2)); //betw. 0 and 1
        if (rand == 0) {
            choice2 = false;    //keep
            System.out.println("Second choice : KEEP");
        }
        if (rand == 1){
            choice2 = true; //change
            System.out.println("Second choice : CHANGE");
        }

        if (choice2 == false) { // se è keep
            if (doors[choice] == true){
                System.out.println("Your prize is a CAR!!!");
            }
            if(doors[choice] == false){
                System.out.println("Your prize is a goat :( ");
            }
        }

        if (choice2 == true){   //se è change
            int finalChoice = -1;
            for (int i = 0; i < doors.length; i++){
                if ((i != opened) && (i != choice)){
                    finalChoice = i;
                }
            }

        System.out.println("---------------------------------");

            if (doors[finalChoice] == true){
                System.out.println("Your prize is a CAR!!!");
            }
            if(doors[finalChoice] == false){
                System.out.println("Your prize is a goat :( ");
            }
        }

    }

}