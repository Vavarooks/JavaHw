public class BankTest{
    public static void main(String[] args){
    // In the constructor, be sure to increment the account count.

    BankAccount account1 = new BankAccount(10,100);
    System.out.println("You have: "+ account1.singleChecking()+ ", and "+ account1.singleSaving() + " in your account.");
    BankAccount account2 = new BankAccount(420,360);
    System.out.println("You have: "+ account2.singleChecking()+ ", and "+ account2.singleSaving() + " in your account.");
    BankAccount account3 = new BankAccount(37,520);
    System.out.println("You have: "+ account3.singleChecking()+ ", and "+ account3.singleSaving() + " in your account.");

    account1.depositC(180);
    account1.depositS(555);
    account1.withdrawC(42);
    account1.withdrawS(72);

    System.out.println("Checking: $" + account1.singleChecking());
    System.out.println("Savings: $" + account1.singleSaving());
    System.out.println("Single Account, $" + account1.singleAcc());
    System.out.println("Number of accounts: "+ BankAccount.totalAcc());
    System.out.println("Total Money: "+ BankAccount.totalAll());
    }
}