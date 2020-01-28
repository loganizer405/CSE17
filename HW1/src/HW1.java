/**
 * Program name: HW1
 * Uses inputs, arrays, and number generation (magic square)
 *
 * @author Logan Kramer
 * Date: 1/26/20
 * @version 1.0
 */

import java.util.Scanner;

public class HW1 {

    public static void main(String[] args) {
        System.out.println("Enter size of magic square (odd): ");
        int size = getOddInput(); //get size of magic square
        System.out.println("Magic Square: ");
        display(magicSquare(size)); //print magic square
        System.out.print("Enter list1 length: ");
        int list1Length = getInput("list1"); //get list1 length
        int[] list1 = getNums(list1Length, "list1"); //get list1 contents
        System.out.print("Enter list2 length: ");
        int list2Length = getInput("list2"); //get list2 length
        int[] list2 = getNums(list2Length, "list2"); //get list2 contents
        System.out.print("List 1: ");
        display(list1); //display list1
        System.out.print("List 2: ");
        display(list2); //display list2
        System.out.print("Merged list: ");
        display(merge(list1, list2)); //display merged list

    }

    public static int[] getNums(int length, String message) {
        Scanner input = new Scanner(System.in); //initialize scanner
        String str;
        int[] list;
        String[] strList;
        boolean exception; //to check for exception from non-integers entered
        while (true) { //run until break;
            System.out.print("Enter " + message + " contents: ");
            exception = false; //reset exception
            str = input.nextLine(); //get input line
            strList = str.split(" "); //separate by space
            list = new int[strList.length]; //initialize integer array
            for (int i = 0; i < strList.length; i++) { //run for each substring in strList
                try { //attempt to parse int. if not int, throws exception and moves to the code inside the catch
                    list[i] = Integer.parseInt(strList[i]); //get integer from substring
                }
                catch (NumberFormatException e) { //not integer
                    System.out.println("All values must be integers!");
                    exception = true; //this is to make sure this loop does not complete
                    if(list.length != length) //check for length too
                        System.out.println("Incorrect length entered! (must be " + length + ")");
                    break; //exit for loop so that this all runs again
                }
            }
            //assuming numbers have been parsed, check for length. !exception prevents the message about length from being printed twice
            if (list.length != length && !exception)
                System.out.println("Incorrect length entered! (must be " + length + ")");
            else if (!exception) //if all goes well, exit loop
                break;
        }
        return list;
    }

    public static int getOddInput() {
        Scanner input = new Scanner(System.in); //initialize scanner
        int num;
        while (true) { //run continuously until "break;"
            if (input.hasNextInt()) { //input is integer
                num = input.nextInt();
                if (num % 2 != 1) { //input is not odd
                    System.out.println("You must enter an odd number!");
                    System.out.print("Enter size of magic square (odd): ");
                }
                else //integer is positive and odd
                    break; //exit while loop
            }
            else { //input is not integer
                input.next(); //clear old value, if this is not done the loop is infinite
                System.out.println("You must enter an odd number!");
                System.out.print("Enter size of magic square (odd): ");
            }
        }
        return num;
    }

    public static int getInput(String message) {
        Scanner input = new Scanner(System.in); //initialize scanner
        int num;
        while (true) { //run continuously until "break;"
            if (input.hasNextInt()) { //input is integer
                num = input.nextInt();
                if (num <= 0) { //input is zero or negative
                    System.out.println("You must enter a positive number!");
                    System.out.print("Enter size of " + message + ": ");
                }
                else //integer is positive and nonzero
                    break; //exit while loop
            }
            else { //input is not integer
                input.next(); //clear old value, if this is not done the loop is infinite
                System.out.println("You must enter a positive number!");
                System.out.print("Enter size of " + message + ": ");
            }
        }
        return num;
    }

    public static int[][] magicSquare(int n) {
        int x = n / 2;
        int y = 0;
        int[][] list = new int[n][n];
        list[y][x] = 1;
        for (int i = 2; i < (n * n + 1); i++) {
            y--; //move up one
            x++; //move right one column
            //if out of top right corner, move down one row
            if (x == n && y == -1) {
                y += 2; //move down two
                if (y >= list.length) //if out of bounds, move back to top
                    y = 0;
                x = x == 0 ? list.length - 1 : x - 1; //if x = 0, set x to list.length -1, otherwise subtract one from x
                if (y > list[n - 1].length) //if y is out of bounds, move to left one
                    y = list[n - 1].length - 1;
                list[y][x] = i; //place
                continue; //end iteration
            }
            if (y < 0) //if out of bounds, move to bottom of column
                y = list[n - 1].length - 1;
            if (x >= list.length) //if out of bounds, move to left side
                x = 0;
            //if at a previous location
            if (list[y][x] != 0) {
                y += 2; //move down two
                if (y >= list.length) //if out of bounds, move back to top
                    y = 0;
                x = x == 0 ? list.length - 1 : x - 1; //if x = 0, set x to list.length -1, otherwise subtract one from x
                if (y > list[n - 1].length) //if y is out of bounds, move to left one
                    y = list[n - 1].length - 1;
                list[y][x] = i; //place
                continue; //end iteration
            }

            //since all conditions have been checked, place value
            list[y][x] = i;
        }
        return list;
    }

    public static void display(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++)
                System.out.printf("%2d ", list[i][j]); //print number and space
            System.out.println();
        }
    }

    public static void display(int[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.printf("%2d ", list[i]); //print umber and space
        System.out.println();
    }

    public static int[] merge(int[] list1, int[] list2) {
        int[] list = new int[list1.length + list2.length]; //initialize array with length array1 and array2
        int n = 0; //keeps track of list index
        for (int i = 0; i < list.length; i++) { //run for each item
            if (i >= list1.length) { //if out of list1 values
                for (int j = i; j < list2.length; j++) //add the rest of the list2 values
                    list[n + j - i] = list2[j];
                return list;
            }
            if (i >= list2.length) { //if out of list2 values
                for (int j = i; j < list1.length; j++) //add the rest of the list1 values
                    list[n + j - i] = list1[j];
                return list;
            }
            list[n] = Math.min(list1[i], list2[i]); //assuming there are values for both list1 and list2, take the max first
            list[n + 1] = Math.max(list1[i], list2[i]); //and the min second
            n += 2; //increase index by two for the two added values
        }
        return list;
    }

}
