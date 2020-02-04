/**
 * Program name: HW2
 * Uses classes for student and grade tracking
 * @author Logan Kramer
 * Date: 2/3/20
 * @version 1.0
 */
public class GradeBook{
    private Student[] roster;
    //constructors
    GradeBook(){
        roster = new Student[50];
    }
    GradeBook(Student[] list){
        roster = new Student[list.length];
        for(int i = 0; i < list.length; i++)
            roster[i] = new Student(list[i].getName(), list[i].getID(), list[i].getGPA());
    }
    public String findStudentID(int id){
        for(int i = 0; i < roster.length; i++){
            if(roster[i].getID() == id)
                return roster[i].toString();
        }
        return "";
    }
    public double getAverageGPA(){
        double sum = 0;
        for(int i = 0; i < roster.length; i++)
            sum += roster[i].getGPA();
        return sum / roster.length;
    }
    public void display(){
        System.out.println("Name:\t\t\t\tID:\t\tGPA:");
        for(int i = 0; i < roster.length; i++)
            System.out.printf("%18s\t%4d\t%1.2f\n", roster[i].getName(), roster[i].getID(), roster[i].getGPA());
    }
    public void sortIDs(){
        Student temp;
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
    public int lowestGPA(){
        double low = roster[0].getGPA();
        int index = 0;
        for (int i = 1; i < roster.length - 1; i++){
            if(roster[i].getGPA() < roster[i + 1].getGPA()) {
                low = roster[i + 1].getGPA();
                index = i;
            }
        }
        return index;
    }
    public int highestGPA(){
        double high = roster[0].getGPA();
        int index = 0;
        for(int i = 1; i < roster.length - 1; i++){
            if(roster[i].getGPA() > roster[i + 1].getGPA()) {
                high = roster[i + 1].getGPA();
                index = i;
            }
        }
        return index;
    }

}