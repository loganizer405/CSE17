import java.util.Objects;

public class Employee extends Person {
    private int id;
    private String hireDate;

    //constructors
    Employee() {
        super();
        id = 0;
        hireDate = "00/00/0000";
    }

    Employee(String name, int age, int id, String hireDate) {
        super(name, age);
        this.id = id;
        this.hireDate = hireDate;
    }

    public int getID() {
        return id;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String toString() {
        return "Employee information:\nName: " + getName() + "\nAge: " + getAge() + "\nID: " + id + "\nHire date: " + hireDate;
    }

    public boolean equals(Object obj) {
        return this.id == ((Employee) obj).getID();
    }
}
