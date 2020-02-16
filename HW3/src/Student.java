public class Student extends Person {
    private int id;
    private String major;
    private double gpa;

    Student() {
        super();
        id = 0;
        major = "";
        gpa = 0.0;
    }

    Student(String name, int age, int id, String major, double gpa) {
        super(name, age);
        this.id = id;
        this.major = major;
        this.gpa = gpa;
    }

    public int getID() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public double getGPA() {
        return gpa;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return "Student information:\nName: " + getName() + "\nAge: " + getAge() + "\nID: " + id +
                "\nMajor: " + major + "\nGPA: " + gpa;
    }

    public boolean equals(Object obj) {
        return this.id == ((Student) obj).getID();
    }
}
