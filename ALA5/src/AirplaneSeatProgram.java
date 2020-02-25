/**
 * Program name: ALA5
 * Uses exception handling and file IO
 *
 * @author Logan Kramer
 * Date: 2/24/20
 * @version 1.0
 */

import java.util.Scanner;

public class AirplaneSeatProgram {
    public static void main(String[] args) {
        Airplane myAirplane = new Airplane("seatsmap.txt"); //create new AIrplane object
        int operation;
        String seat;
        Scanner input = new Scanner(System.in); //initialize scanner
        myAirplane.readMapFromFile("seatsmap.txt"); //get map
        System.out.println(myAirplane.toString());
        do {
            operation = getOperation(input);
            switch (operation) {
                case 1: //reserve a seat
                    while (true) {
                        System.out.print("Enter seat number: ");
                        seat = input.next();
                        try {
                            if (!myAirplane.reserveSeat(seat)) //if reserveSeat() returns false, the seat is already taken
                                System.out.println("Seat already taken! ");
                            else {
                                System.out.println("Seat successfully reserved.");
                                break;
                            }
                        }
                        catch (InvalidSeatException e) { //if seat is not valid, print message and get new seat
                            System.out.println("Incorrect seat entered! Format:[1-9][A-H]");
                        }
                    }
                    break;
                case 2: //free a seat
                    while (true) {
                        System.out.print("Enter seat number: ");
                        seat = input.next();
                        try {
                            if (!myAirplane.freeSeat(seat)) //if freeSeat() returns false, seat is already free
                                System.out.println("Seat already free! ");
                            else {
                                System.out.println("Seat successfully freed.");
                                break;
                            }
                        }
                        catch (InvalidSeatException e) { //if seat is not valid, print message and get new seat
                            System.out.println("Incorrect seat entered! Format:[1-9][A-H]");
                        }
                    }
                    break;
                case 3: //exit program
                    myAirplane.saveMap("seatsmap.txt"); //save file
                    System.out.println("Saving file and exiting program...");
                    break;
            }
        } while (operation != 3); //exit when operation is 3
    }

    public static String getSeat(Scanner input, Airplane airplane) {
        String str;
        while (true) {
            try {
                str = input.nextLine();
                if (airplane.checkSeat(str))
                    return str;
            }
            catch (InvalidSeatException e) {
                System.out.println("Invalid seat entered! Enter format [1-9][A-H]");
            }
        }
    }

    public static int getOperation(Scanner input) {
        int op;
        do { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: Reserve a seat");
            System.out.println("2: Free a seat");
            System.out.println("3: Exit program");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 3) break;  //if within bounds break this statement
                else
                    System.out.println("Invalid operation (1-3)");
            }
            else {
                input.nextLine();
                System.out.println("Invalid operation (must be integer)");
            }
        } while (true);
        return op;
    }
}