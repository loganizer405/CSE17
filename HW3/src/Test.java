/**
 * Program name: HW3
 * Uses classes for people, students, employees (part time and full time) and prints information
 *
 * @author Logan Kramer
 * Date: 2/16/20
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Person[] listOfPeople = new Person[10];
        listOfPeople[0] = new Student("Lucy Treston", 20, 12345, "CSE", 3.75);
        listOfPeople[1] = new Student("Mark Brown", 18, 12344, "ISE", 3.50);
        listOfPeople[2] = new FullTimeEmployee("Jerry Zurcker", 25, 3333333, "03/10/2017", 500000);
        listOfPeople[3] = new PartTimeEmployee("Sharon Luft", 22, 6666666, "01/01/2010", 32.0, 100);
        listOfPeople[4] = new Student("Emma Packard", 19, 12355, "CSB", 3.0);
        listOfPeople[5] = new Student("Felix Hirpara", 22, 55123, "CSE", 2.75);
        listOfPeople[6] = new PartTimeEmployee("Jade Farrar ", 29, 1111111, "07/22/2012", 22.0, 45);
        listOfPeople[7] = new Student("Junita Stoltzman", 21, 44123, "ISE", 2.5);
        listOfPeople[8] = new PartTimeEmployee("Brian Lin", 31, 7777777, "02/01/2014", 35.0, 31);
        listOfPeople[9] = new FullTimeEmployee("Alicia Bubash", 35, 5555555, "08/01/2018", 125000);
        for (Person p : listOfPeople) {
            System.out.println(p.toString());
            System.out.println();
        }
        displayStudents(listOfPeople, 3.0);
        displayPartTimeEmployees(listOfPeople);
        displayFullTimeEmployees(listOfPeople);
    }

    public static void displayStudents(Person[] list, double gpa) {
        System.out.println("List of students with GPA greater than " + gpa + ": ");
        for (Person p : list) {
            if ((p instanceof Student) && //if class is Student
                    ((Student) p).getGPA() >= gpa) //and the gpa is greater than argument gpa
                System.out.println(p.getName()); //print student name
        }
        System.out.println();
    }

    public static void displayPartTimeEmployees(Person[] list) {
        System.out.println("List of part time employees");
        for (Person p : list)
            if (p instanceof PartTimeEmployee) //if type PartTimeEmployee
                System.out.println(p.getName()); //print employee name
        System.out.println();
    }

    public static void displayFullTimeEmployees(Person[] list) {
        System.out.println("List of full time employees");
        for (Person p : list)
            if (p instanceof FullTimeEmployee) //if type FullTimeEmployee
                System.out.println(p.getName()); //print employee name
        System.out.println();
    }
}
