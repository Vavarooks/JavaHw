public class BankAccount{
    // The class should have the following attributes:'
    // (double) checking balance, (double) savings balance.

    private static double checking;
    private static double saving;
    public static int accountsMade;
    private static double totalMoney = 0;

    public BankAccount(double checkingAcc, double savingAcc){
        this.checking = checkingAcc;
        this.saving = savingAcc;
        this.totalMoney += checkingAcc;
        this.totalMoney += savingAcc;
        this.accountsMade ++;
    }

    public static double totalAll(){
        return this.totalMoney;
        // Create a method to see the total money from the checking and saving.
    }

    public static double singleAcc(){
        return this.checking + this.saving;
    }

    public static int totalAcc(){
        return this.accountsMade;
    }

    public double singleChecking(){
        return this.checking;
        // Create a getter method for the user's checking account balance.
    }

    public double singleSaving(){
        return this.saving;
         // // Create a getter method for the user's saving account balance.
    }
    
    // Create a method that will allow a user to deposit money into the checking account
    public double depositC(double val){

    this.checking += val;
    this.totalMoney += val;
    return this.checking;

    }
    
     // Create a method that will allow a user to deposit money into the saving account
    public double depositS(double val){

        this.saving += val;
        this.totalMoney += val;
        return this.saving;

    }

    // Create a method to withdraw money from savings balance.Do not allow them to withdraw money if there are insufficient funds.
    public double withdrawS(double val){

    if(saving >= val){
        this.saving -= val;
        this.totalMoney -= val;
    }
    return saving;

    }

    // Create a method to withdraw money from checkings balance. Do not allow them to withdraw money if there are insufficient funds.
    public double withdrawC(double val){

    if(checking >= val){
        this.checking -= val;
        this.totalMoney -= val;
    }
    return checking;
    }

}