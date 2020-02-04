/**
 * Program name: HW2
 * Uses classes for student and grade tracking
 *
 * @author Logan Kramer
 * Date: 2/3/20
 * @version 1.0
 */
public class Student {
    //variables
    private String name;
    private int id;
    private double gpa;
    //constructors
    Student() {
        name = "";
        id = 0;
        gpa = 0;
    }

    Student(String n, int idNum, double gpaNum) {
        name = n;
        id = idNum;
        gpa = gpaNum;
    }

    //get and set methods
    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public double getGPA() {
        return gpa;
    }

    public void setName(String n) {
        name = n;
    }

    public void setID(int idNum) {
        id = idNum;
    }

    public void setGPA(double gpaNum) {
        gpa = gpaNum;
    }

    public String toString() {
        return "Name: " + name + ", ID: " + id + ", GPA: " + gpa;
    }

}
