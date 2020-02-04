/**
 * Program name: HW2
 * Uses classes for student and grade tracking
 *
 * @author Logan Kramer
 * Date: 2/3/20
 * @version 1.0
 */
public class GradeBook {
    private Student[] roster;

    //constructors
    GradeBook() {
        roster = new Student[50];
    }

    GradeBook(Student[] list) {
        roster = new Student[list.length]; //initialize array
        for (int i = 0; i < list.length; i++) //copy all values
            roster[i] = new Student(list[i].getName(), list[i].getID(), list[i].getGPA());
    }

    public String findStudentID(int id) {
        //binary search, returns student info if found or empty string if not found
        for (Student student : roster) {
            if (student.getID() == id)
                return student.toString();
        }
        return "";
    }

    public double getAverageGPA() {
        double sum = 0;
        //adds sum of all gpas then returns it divided by the number of gpas
        for (Student student : roster)
            sum += student.getGPA();
        return sum / roster.length;
    }

    public void display() {
        //print all student information
        System.out.println("Name:\t\t\t\tID:\t\tGPA:");
        for (Student student : roster)
            System.out.printf("%18s\t%4d\t%1.2f\n", student.getName(), student.getID(), student.getGPA());
    }

    public void sortIDs() {
        Student temp;
        //sort list by increasing id
        for (int i = 0; i < roster.length; i++) {
            for (int j = i + 1; j < roster.length; j++) {
                if (roster[i].getID() > roster[j].getID()) {
                    temp = roster[i];
                    roster[i] = roster[j];
                    roster[j] = temp;
                }
            }
        }
    }

    public String lowestGPA() {
        double low = roster[0].getGPA();
        int index = 0;
        //find lowest gpa and keep track of index
        for (int i = 1; i < roster.length; i++) {
            if (low > roster[i].getGPA()) {
                low = roster[i].getGPA();
                index = i;
            }
        }
        //return string with student info
        return roster[index].toString();
    }

    public String highestGPA() {
        double high = roster[0].getGPA();
        int index = 0;
        //find highest gpa and keep track of index
        for (int i = 1; i < roster.length; i++) {
            if (high < roster[i].getGPA()) {
                high = roster[i].getGPA();
                index = i;
            }
        }
        //return string with student info
        return roster[index].toString();
    }

}