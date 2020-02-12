public class Bank {
    private String name;
    private String branch;
    private BankAccount[] bankAccounts;
    public static double monthlyFee;
    Bank(){
        name = "";
        branch = "";
        bankAccounts = new BankAccount[10];
    }
    Bank(String n, String b, BankAccount[] listAccounts){
        name = n;
        branch = b;
        bankAccounts = new BankAccount[listAccounts.length]; //initialize array
        for(int i = 0; i < listAccounts.length; i++) //deep copy
            bankAccounts[i] = new BankAccount(listAccounts[i].getName(), listAccounts[i].getAccount(), listAccounts[i].getBalance());
    }
    public BankAccount findAccount(int account){
        for(BankAccount acc : bankAccounts){ //search accounts
            if(acc.getAccount() == account) //if match, return account
                return acc;
        }
        return null;
    }
    public double viewBalance(int account){
        return findAccount(account) == null ? -1 : findAccount(account).getBalance();
    }
    public void deposit(int account, double amount){
        findAccount(account).deposit(amount);
    }
    public boolean withdraw(int account, double amount){
        return findAccount(account).withdraw(amount);
    }
    public void applyMonthlyFee(){
        for(BankAccount acc : bankAccounts)
            acc.withdraw(monthlyFee);
    }
    public void viewAllAccounts(){
        System.out.println("Name\t\t\tAccount\tBalance");
        for(BankAccount acc : bankAccounts)
            System.out.printf("%14s\t%4d\t$%5.2f\n", acc.getName(), acc.getAccount(), acc.getBalance());
    }
}
