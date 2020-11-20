public class MontyHallRepetition {
    private int repetitions;
    private int winCount;
    private int keep;
    private int change;

    public MontyHallRepetition (int rep) {
        repetitions = rep;
        winCount = 0;
        keep = 0;
        change = 0;

    }

    public String Test () {
        int ret = -2;
        for (int i = 0; i < repetitions; i++){
            MontyHall2 test = new MontyHall2();
            test.firstChoice();
            ret = test.KeepOrChange();
            //0 CAR KEEP
            //1 GOAT KEEP
            //2 CAR CHANGE
            //3 GOAT CHANGE
            //-1 ERROR

            if (ret == 0){
                winCount++;
                keep++;
            }
            if (ret == 2) {
                winCount++;
                change++;
            }
        }

        String retu = "" + winCount + " wins " + "\n" + change + " change " + "\n" + keep + " keep";
        double changePerc = (((double)change/winCount)*100.0);
        double keepPerc =   (((double)keep/winCount)*100.0);
        retu = retu + "\n" + changePerc + " % Change " + "\n" + keepPerc + " % Keep"; 
        return retu;
    }
}