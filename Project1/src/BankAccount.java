public class BankAccount {
    private String name;
    private int account;
    private double balance;
    BankAccount(){
        name = "";
        account = 0;
        balance = 0.0;
    }
    BankAccount(String n, int acc, double bal){
        name = n;
        account = acc;
        balance = bal;
    }
    public String getName(){ //accessor: returns name
        return name;
    }
    public int getAccount(){ //accessor: returns account
        return account;
    }
    public double getBalance(){ //accessor: returns balance
        return balance;
    }
    public void deposit(double amount){ //mutator: adds amount
        balance += amount;
    }
    public boolean withdraw(double amount){ //mutator: subtracts amount
        if(balance >= amount) { //if there is enough money
            balance -= amount;
            return true;
        }
        return false; //if not enough money
    }
    public String toString(){ //accessor: returns formatted string
        return name + ", " + account + ", " + balance;

    }
}
