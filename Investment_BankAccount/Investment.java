public class Investment{
    public static void main (String [] args){
        final double INITIAL_BALANCE = 20000;
        final double RATE = 0.05;

        BankAccount acnt = new BankAccount (INITIAL_BALANCE);
        int year = 0;

        while (acnt.getBalance() < 2 * INITIAL_BALANCE){
            year++;

            double interest = acnt.getBalance() * RATE;
            acnt.deposit(interest);
        }

        System.out.println("L'investimento " + "raddoppia in " + year + " anni");
    }
}