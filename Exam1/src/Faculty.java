public class Faculty extends Employee {
    private String rank;
    private double salary;

    //constructors
    Faculty() {
        super("", 0);
        rank = "";
        salary = 0.0;
    }

    Faculty(String name, int id, String rank, double salary) {
        super(name, id);
        this.rank = rank;
        this.salary = salary;
    }

    public String getRank() { //returns rank
        return rank;
    }

    public double getSalary() { //returns salary
        return salary;
    }

    public void setRank(String rank) { //sets rank
        this.rank = rank;
    }

    public void setSalary(double salary) { //sets salary
        this.salary = salary;
    }

    public String toString() {
        //returns the toString() from Employee (including name and ID) and add rank and salary
        return super.toString() + ", Rank: " + rank + ", Salary: $" + salary;
    }
}
