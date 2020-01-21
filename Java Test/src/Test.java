/*
 * Author: Logan Kramer
 * Program Name: Java Test
 * Date: 1/21/20
 * Version: 1.0
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("test ");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int students = keyboard.nextInt();
        String[] studentNames = new String[students];
        double[] studentGPAs = new double[students];
        int[] studentIDs = new int[students];
        int operation = 0;
        keyboard.nextLine();
        inputData(keyboard, studentNames, studentIDs, studentGPAs);
        do {
            operation = getOperation(keyboard);
            switch (operation) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = keyboard.nextInt();
                    int i = findStudentID(studentIDs, id);
                    if (i == -1) System.out.println(id + " not found.");
                    else
                        System.out.println("IDfound,Name: " + studentNames[i] + ", GPA: " + studentGPAs[i]);
                    break;
                case 2:
                    displayData(studentNames, studentIDs, studentGPAs);
                    break;
                case 3:
                    double avg = averageGPA(studentGPAs);
                    System.out.printf("Average GPA: %5.2f\n", avg);
                    break;
                case 4:
                    sortNames(studentNames, studentIDs, studentGPAs);
                    displayData(studentNames, studentIDs, studentGPAs);
                    break;
                case 9:
                    System.out.println("Thank you for using my program.");
            }
        } while (operation != 9);
    }

    /**
     * fills the input arrays with data entered by the user
     *
     * @param input: Scanner object to read the input data
     * @param names: array of student names
     * @param ids:   array of student ids
     * @param gpas:  array of student GPAs
     *               no return value
     */
    public static void inputData(Scanner input, String[] names, int[] ids, double[] gpas) {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Enter name of student " + (i + 1) + ": ");
            names[i] = input.nextLine();
            do {
                System.out.println("Enter id of student " + (i + 1) + ": ");
                if (input.hasNextInt()) break;
                else {
                    System.out.println("ID must be an integer.");
                    input.nextLine();
                }
            } while (true);
            ids[i] = input.nextInt();
            do {
                System.out.println("Enter gpa of student " + (i + 1) + ": ");
                if (input.hasNextDouble())
                    break;
                else {
                    input.nextLine();
                    System.out.println(" GPA must be a double.");
                }
            }
            while (true);
            gpas[i] = input.nextDouble();
            input.nextLine();
        }
    }

    /**
     * displays the content of the three arrays in tabular format
     *
     * @param names: array of student names
     * @param ids:   array of student ids
     * @param gpas:  array of student GPAs
     *               no return value
     */
    public static void displayData(String[] names, int[] ids, double[] gpas) {
        System.out.printf("%-20s\t%-15s\t%-15s\n", "Student name", "Student ID", "Student GPA");
        for (int i = 0; i < names.length; i++)
            System.out.printf("%-20s\t%-15d\t%-15.2f\n", names[i], ids[i], gpas[i]);
    }

    public static int getOperation(Scanner input) {
        int op = 0;
        do {
            printMenu();
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 4 || op == 9) break;
                else
                    System.out.println("Invalid operation(1-4 or 9)");
            } else {
                input.nextLine();
                System.out.println("Invalid operation(must be integer)");
            }
        } while (true);
        return op;
    }
    // Method to print the menu public

    static void printMenu() {
        System.out.println("\nSelect an operation: ");
        System.out.println(" 1: Find student (id)");
        System.out.println(" 2: View all students");
        System.out.println(" 3: View average GPA");
        System.out.println(" 4: Sort students by name");
        System.out.println(" 9: Exit program");
    }

    /**
     * calculates the average value of the array elements
     *
     * @param gpas: array of student GPAs
     * @return calculated average
     */
    public static double averageGPA(double[] gpas) {
        double average = 0;
        for (int i = 0; i < gpas.length; i++) {
            average += gpas[i];
        }
        return average / gpas.length;
    }

    /**
     * looks for the input id in the array ids
     *
     * @param ids: array of student IDs
     * @param id       to find* @return index of the element with ID equal to id
     **/
    public static int findStudentID(int[] ids, int id) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }

    /**
     * orders the array names in alphabetical order
     * @param : three arrays for student names, IDs, and GPAs
     * no return value
     */
    public static void sortNames(String[] names, int[] ids, double[] gpas) {
        for (int i = 0; i < names.length; i++) {
            int minIndex = i;
            String minName = names[i];
            for (int j = i + 1; j < names.length; j++) {
                if (names[j].compareTo(minName) < 0) {
                    minName = names[j];
                    minIndex = j;
                }
            }
            swap(names, i, minIndex);
            swap(ids, i, minIndex);
            swap(gpas, i, minIndex);
        }
    }

    /**
     * swaps elementsatindicesi and j
     *
     * @param i: first index in the input array
     * @param j: second index in the input array
     *           no return value
     * @param names: of String, int, or double elements
     */
    public static void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    public static void swap(int[] ids, int i, int j) {
        int temp = ids[i];
        ids[i] = ids[j];
        ids[j] = temp;
    }

    public static void swap(double[] gpas, int i, int j) {
        double temp = gpas[i];
        gpas[i] = gpas[j];
        gpas[j] = temp;
    }
}
