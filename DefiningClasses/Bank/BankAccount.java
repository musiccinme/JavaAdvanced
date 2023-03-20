package DefiningClasses.Bank;

public class BankAccount {
    private static int accountCount = 1;
    private int id;
    private double balance;
    private final static double DEFAULT_INTEREST= 0.02;
    private static double interest = DEFAULT_INTEREST;

    BankAccount(){
        this.id = accountCount++;
    }

    public int getId() {
        return id;
    }

    public static void setInterest(double interest) {
        BankAccount.interest = interest;
    }

    double getInterest(int years) {
        return years * BankAccount.interest * this.balance;
    }

    void deposit(double amount){
        this.balance += amount;
    }


}
