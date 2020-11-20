public class MontyHall2 {
    //declaration
    private boolean [] doors = new boolean [3];
        //true - car
        //false - goat
    private int choice; //first door choice
    private int opened; // first door opened
    

    //costructor
    public MontyHall2 () {
        for (int x = 0; x < doors.length; x++) {
            doors[x] = false;
        }
        int car = (int)(Math.random() * (3)); // between 0 and 2

        doors [car] = true;

        choice = -1;
        opened = -1;

        
    }

    public void firstChoice () {        
        //scegli la prima porta, apre un'altra con goat
        choice = (int)(Math.random() * (3)); // between 0 and 2

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
    }

    public int KeepOrChange () {
        //0 CAR KEEP
        //1 GOAT KEEP
        //2 CAR CHANGE
        //3 GOAT CHANGE
        //-1 ERROR

        //tieni la porta scelta o scegli l'altra rimasta
        boolean choice2 = false;
            //false = keep
            //true = change
        int rand = (int)(Math.random() * (2)); //betw. 0 and 1
        if (rand == 0) {
            choice2 = false;    //keep
        }
        if (rand == 1){
            choice2 = true; //change
        }

        if (choice2 == false) { // se è keep
            if (doors[choice] == true){
                return 0; //CAR KEEP
            }
            if(doors[choice] == false){
                return 1; //GOAT KEEP
            }
        }

        if (choice2 == true){   //se è change
            int finalChoice = -1;
            for (int i = 0; i < doors.length; i++){
                if ((i != opened) && (i != choice)){
                    finalChoice = i;
                }
            }
            if (doors[finalChoice] == true){
                return 2; //se è CAR CHANGE
            }
            if(doors[finalChoice] == false){
                return 3; // se è GOAT CHANGE
            }

            
        }
       return -1;     
    }
}
