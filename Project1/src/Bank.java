/**
 * Program name: Project1
 * Programming project 1, uses classes for bank tracking
 *
 * @author Logan Kramer
 * Date: 2/9/20
 * @version 1.0
 */
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
    Bank(String name, String branch, BankAccount[] listAccounts){
        this.name = name;
        this.branch = branch;
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
    public double viewBalance(int account){ //accessor: returns balance if account found, otherwise returns -1
        return findAccount(account) == null ? -1 : findAccount(account).getBalance();
    }
    public void deposit(int account, double amount){ //mutator: deposits amount into account
        findAccount(account).deposit(amount);
    }
    public boolean withdraw(int account, double amount){ //mutator: withdraws amount from account
        return findAccount(account).withdraw(amount);
    }
    public void applyMonthlyFee(){ //mutator: withdraws monthly fee from each account
        for(BankAccount acc : bankAccounts)
            acc.withdraw(monthlyFee);
    }
    public void viewAllAccounts(){ //accessor: prints accounts in table
        System.out.println("Name\t\t\tAccount\tBalance");
        for(BankAccount acc : bankAccounts)
            System.out.printf("%14s\t%4d\t$%5.2f\n", acc.getName(), acc.getAccount(), acc.getBalance());
    }
}
