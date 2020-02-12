import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;

/**
 * Program name: Project1
 * Programming project 1, uses classes for bank tracking
 *
 * @author Logan Kramer
 * Date: 2/9/20
 * @version 1.0
 */
public class TestBank {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank.monthlyFee = 20;
        BankAccount[] listAccounts = new BankAccount[5];
        listAccounts[0] = new BankAccount("John Blake", 12534, 1200);
        listAccounts[1] = new BankAccount("Sarah Brown", 44422, 2045);
        listAccounts[2] = new BankAccount("Emma Johnson", 33322, 450);
        listAccounts[3] = new BankAccount("Suzan Jones", 55500, 23000);
        listAccounts[4] = new BankAccount("Mary Chen", 11111, 550);
        Bank myBank = new Bank("MyBank", "Bethlehem", listAccounts);
        //operations
        int mainOperation;
        int operation;
        do {
            mainOperation = getMainOperation(input);
            switch (mainOperation) {
                case 1: //manage account
                    BankAccount acc;
                    while (true) { //get account
                        acc = myBank.findAccount(getNum(input));
                        if (acc != null) //if account found
                            break;
                        System.out.println("Account not found!");
                    }
                    do { //run until 4 is entered and return to main menu
                        operation = getOperation(input);
                        switch (operation) {
                            case 1: //view balance
                                System.out.printf("Balance: $%.2f\n", acc.getBalance());
                                break;
                            case 2: //deposit
                                //get amount
                                int depositAmount;
                                do {
                                    System.out.print("Enter amount to deposit: ");
                                    if(input.hasNextInt()){
                                        depositAmount = input.nextInt();
                                        if(depositAmount <= 0) //if negative
                                            System.out.println("Must enter a positive integer! ");
                                        else //if positive, break loop
                                            break;
                                    }
                                    else { //if not an integer
                                        input.nextLine();
                                        System.out.println("Must enter an integer! ");
                                    }
                                } while (true);
                                acc.deposit(depositAmount); //deposit
                                System.out.printf("New balance: $%.2f\n", acc.getBalance());
                                break;
                            case 3: //withdraw
                                //get amount
                                int withdrawAmount;
                                do {
                                    System.out.print("Enter amount to withdraw: ");
                                    if (input.hasNextInt()) {
                                        withdrawAmount = input.nextInt();
                                        if (withdrawAmount <= 0) //if negative
                                            System.out.println("Must enter a positive integer! ");
                                        else //if positive, break loop
                                            break;
                                    }
                                    else { //if not an integer
                                        input.nextLine();
                                        System.out.println("Must enter an integer! ");
                                    }
                                } while (true);
                                if(acc.withdraw(withdrawAmount)) //if successful
                                    System.out.printf("New balance: $%.2f\n", acc.getBalance());
                                else
                                    System.out.println("Withdraw failed! Not enough credit.");
                                break;
                            case 4: //back to main menu
                                System.out.println("Returning to main menu...");
                                break;
                        }
                    } while (operation != 4);
                    break;
                case 2: //apply monthly fee
                    myBank.applyMonthlyFee();
                    System.out.println("Successfully applied monthly fee.");
                    break;
                case 3: //view accounts
                    myBank.viewAllAccounts();
                    break;
                case 4: //exit program
                    System.out.println("Exiting program...");
                    break;
            }
        } while (mainOperation != 4); //this loop ends when 7 is inputted
    }

    public static int getNum(Scanner input) {
        do {
            System.out.print("Enter account number: ");
            if (input.hasNextInt()) {
                int acc = input.nextInt();
                if (acc >= 100000 || acc < 5000)
                    System.out.println("Must enter a five digit integer!");
                else
                    return acc;
            }
            else {
                input.nextLine();
                System.out.println("Must enter an integer!");
            }
        } while (true);
    }

    public static int getMainOperation(Scanner input) {
        int op;
        do { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: Manage account");
            System.out.println("2: Apply monthly fee");
            System.out.println("3: View all accounts");
            System.out.println("4: Exit program");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 3 || op == 4) break;  //if within bounds or equal to 7 break this statement
                else
                    System.out.println("Invalid operation (1-4)");
            }
            else {
                input.nextLine();
                System.out.println("Invalid operation (must be integer)");
            }
        } while (true);
        return op;
    }

    public static int getOperation(Scanner input) {
        int op;
        do { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: View balance");
            System.out.println("2: Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4: Return to main menu");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 3 || op == 4) break;  //if within bounds or equal to 7 break this statement
                else
                    System.out.println("Invalid operation (1-4)");
            }
            else {
                input.nextLine();
                System.out.println("Invalid operation (must be integer)");
            }
        } while (true);
        return op;

    }
}