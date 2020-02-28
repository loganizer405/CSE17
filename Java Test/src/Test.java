/*
 * Author: Logan Kramer
 * Program Name: Java Test
 * Date: 1/21/20
 * Version: 1.0
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println(1 % 20 + 2);
        System.out.println("test ");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the number of students: ");
        int students = keyboard.nextInt();
        String[] studentNames = new String[students];
        double[] studentGPAs = new double[students];
        int[] studentIDs = new int[students];
        int operation;
        keyboard.nextLine();
        inputData(keyboard, studentNames, studentIDs, studentGPAs);
        do {
            operation = getOperation(keyboard);
            switch (operation) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = keyboard.nextInt();
                    int i = binarySearchStudentID(studentIDs, id);
                    if (i == -1) System.out.println(id + " not found.");
                    else
                        System.out.println("ID found, Name: " + studentNames[i] + ", GPA: " + studentGPAs[i]);
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
                case 5:
                    sortIDs(studentIDs, studentNames, studentGPAs);
                    displayData(studentNames, studentIDs, studentGPAs);
                    break;
                case 6:
                    sortGPAs(studentIDs, studentNames, studentGPAs);
                    displayData(studentNames, studentIDs, studentGPAs);
                    break;
                case 7:
                    int high = highestGPA(studentGPAs);
                    System.out.printf("Highest GPA: %5.2f\n", studentGPAs[high]);
                    System.out.println("Student name: " + studentNames[high]);
                    System.out.println("Student ID: " + studentIDs[high]);
                    break;
                case 8:
                    int low = lowestGPA(studentGPAs);
                    System.out.printf("Lowest GPA: %5.2f\n", studentGPAs[low]);
                    System.out.println("Student name: " + studentNames[low]);
                    System.out.println("Student ID: " + studentIDs[low]);
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
                if (op >= 1 && op <= 8 || op == 9) break;
                else
                    System.out.println("Invalid operation(1-9)");
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
        System.out.println(" 5: Sort students by IDs");
        System.out.println(" 6: Sort students by GPAs");
        System.out.println(" 7: Display student with highest GPA");
        System.out.println(" 8: Display student with lowest GPA");
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
     * @param id   to find* @return index of the element with ID equal to id
     **/
    public static int findStudentID(int[] ids, int id) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }

    /**
     * orders the array names in alphabetical order
     *
     * @param : three arrays for student names, IDs, and GPAs
     *          no return value
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
     * @param i:     first index in the input array
     * @param j:     second index in the input array
     *               no return value
     * @param names: of String, int, or double elements
     */
    public static void swap(String[] names, int i, int j) {
        String temp = names[i];
        names[i] = names[j];
        names[j] = temp;
    }

    public static int binarySearchStudentID(int[] ids, int key) {
        int low = 0;
        int high = ids.length - 1;
        int mid;
        while (high >= low) {
            mid = (high + low) / 2;
            if (ids[mid] == key)
                return mid;
            else if (ids[mid] > key)
                high = mid - 1;
            else //ids[mid] < key
                low = mid + 1;
        }
        //if nothing has been returned
        return -1;
    }

    public static void sortIDs(int[] ids, String[] names, double[] gpas) {
        int minIndex;
        //store temps to switch
        int tempID;
        double tempGPA;
        String tempName;
        for (int i = 0; i < ids.length - 1; i++) {
            //get min index
            minIndex = findMin(ids, i);
            //switch ids, gpas, names
            tempID = ids[i];
            tempName = names[i];
            tempGPA = gpas[i];
            ids[i] = ids[minIndex];
            names[i] = names[minIndex];
            gpas[i] = gpas[minIndex];
            ids[minIndex] = tempID;
            names[minIndex] = tempName;
            gpas[minIndex] = tempGPA;
        }
    }

    public static void sortGPAs(int[] ids, String[] names, double[] gpas) {
        for (int i = 1; i < ids.length; i++) {
            //insertion sort, keep gpas and names
            insert(ids, i);
            insertString(names, i);
            insertDouble(gpas, i);
        }
    }
    public static int highestGPA(double[] gpas){
        double max = gpas[0];
        int index = 0;
        for(int i = 1; i < gpas.length; i++){
            if(gpas[i] > max) {
                max = gpas[i];
                index = i;
            }
        }
        return index;
    }
    public static int lowestGPA(double[] gpas){
        double min = gpas[0];
        int index = 0;
        for(int i = 1; i < gpas.length; i++){
            if(gpas[i] < min) {
                min = gpas[i];
                index = i;
            }
        }
        return index;
    }
    public static void insert(int[] list, int i) {
        int currentVal = list[i];
        while (i > 0 && currentVal < (list[i - 1])) {   // Shift element i-1 into element i
            list[i] = list[i - 1];
            i--;
        }
        //switch back
        list[i] = currentVal;
    }
    public static void insertString(String[] list, int i){
        //same function as above but with string
        String currentVal = list[i];
        while (i > 0) {
            list[i] = list[i - 1];
            i--;
        }
        list[i] = currentVal;
    }
    public static void insertDouble(double[] list, int i){
        //same function as above but double
        double currentVal = list[i];
        while (i > 0 && currentVal < (list[i - 1])) {      // Shift element (i-1) into element (i)
            list[i] = list[i - 1];
            i--;
        }
        list[i] = currentVal;
    }
    public static int findMin(int[] list, int start) {
        //gets min value in a list and returns index(for sort)
        int min = list[start];
        int index = start;
        for (int i = start; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
                index = i;
            }
        }
        return index;
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
