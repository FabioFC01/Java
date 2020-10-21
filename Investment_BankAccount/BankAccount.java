public class BankAccount {
    private double balance;

    public BankAccount (){
        balance = 0;
    }

    public BankAccount ( double bal){
        balance = bal;
    }

    public double getBalance () {
        return balance;
    }

    public void deposit (double money) {
        balance += money;
    }

    public void withdraw (double money) {
        balance -= money;
    }
}
