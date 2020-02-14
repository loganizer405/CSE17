/**
 * Program name: ALA3
 * Uses classes and a stack
 *
 * @author Logan Kramer
 * Date: 2/6/20
 * @version 1.0
 */

import java.util.Scanner;

public class HTTPServer {
    public static void main(String[] args) {
        Stack requestStack = new Stack(50);
        Scanner input = new Scanner(System.in);
        String regex = "(http(s)?)://w{3}(.)*(.)(com|net|org|gov|edu)";
        //operations
        int operation;
        do {
            operation = getOperation(input);
            switch (operation) {
                case 1: //add url
                    System.out.print("Enter page URL: ");
                    String link = input.nextLine();
                    link = input.nextLine();
                    while(!link.matches(regex)){
                        System.out.println("Invalid URL.");
                        System.out.print("Enter page URL: ");
                        link = input.nextLine();
                    }


                    requestStack.push(link);
                    break;
                case 2: //show last request
                    if (requestStack.empty())
                        System.out.println("Stack is empty. ");
                    else
                        System.out.printf("Last request: %s \n", requestStack.top());
                    break;
                case 3: //remove last request
                    if (requestStack.empty())
                        System.out.println("Stack is empty. ");
                    else
                        System.out.printf("Last request removed. URL: %s \n", requestStack.pop());
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
            }
        } while (operation != 4);

    }

    public static int getOperation(Scanner input) {
        int op;
        do { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: Enter new URL request");
            System.out.println("2: View last URL request");
            System.out.println("3: Remove last URL request");
            System.out.println("4: Exit program");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 3 || op == 4) break;  //if within bounds or equal to 4 break this statement
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
