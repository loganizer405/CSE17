/**
 * Program name: HW2
 * Uses classes for student and grade tracking
 *
 * @author Logan Kramer
 * Date: 2/3/20
 * @version 1.0
 */

import java.util.Scanner;

public class GradeBookTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //initialize students
        Student[] studentList = new Student[5];
        studentList[0] = new Student("Jerry Marcy", 1234, 3.75);
        studentList[1] = new Student("Lily Merchant", 1342, 3.75);
        studentList[2] = new Student("Eleanor Maxwell", 4213, 3.90);
        studentList[3] = new Student("Fred Karl", 2134, 2.00);
        studentList[4] = new Student("Anatoly Marsh", 3421, 3.25);
        //assign to class GradeBook
        GradeBook grades = new GradeBook(studentList);
        //operations
        int operation;
        do {
            operation = getOperation(input);
            switch (operation) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = input.nextInt();
                    boolean found = false;
                    for (int i = 0; i < studentList.length; i++) {
                        if (studentList[i].getID() == id) {
                            //if id matches, print student information
                            System.out.println("ID found, " + studentList[i].toString());
                            found = true;
                        }
                    }
                    if(!found) //if not found, display message
                        System.out.println("ID not found. ");
                    break;
                case 2: //display all info
                    grades.display();
                    break;
                case 3: //display avg gpa to 4 decimal places
                    System.out.printf("Average GPA: %1.4f\n", grades.getAverageGPA());
                    break;
                case 4: //sort gradebook and display
                    grades.sortIDs();
                    grades.display();
                    break;
                case 5: //find lowest gpa and display student
                    System.out.println("Lowest GPA student: " + studentList[grades.lowestGPA()].toString());
                    break;
                case 6: //find highest gpa and display student
                    System.out.println("Highest GPA student: " + studentList[grades.highestGPA()].toString());
                    break;
                case 7: //exit program
                    System.out.println("Exiting program");
                    break;
            }
        } while (operation != 7); //this loop ends when 7 is inputted
    }

    public static int getOperation(Scanner input) {
        int op = 0;
        do { //display menu
            System.out.println("Available operations: ");
            System.out.println("1: Find student ID");
            System.out.println("2: Display all student information");
            System.out.println("3: Display average GPA");
            System.out.println("4: Sort students by ID and display");
            System.out.println("5: Find lowest GPA and display student");
            System.out.println("6: Find highest GPA and display student");
            System.out.println("7: Exit program");
            if (input.hasNextInt()) {
                op = input.nextInt();
                if (op >= 1 && op <= 6 || op == 7) break;  //if within bounds or equal to 7 break this statement
                else
                    System.out.println("Invalid operation (1-7)");
            }
            else {
                input.nextLine();
                System.out.println("Invalid operation (must be integer)");
            }
        } while (true);
        return op;
    }
}