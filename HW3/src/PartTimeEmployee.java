public class PartTimeEmployee extends Employee {
    private double hourlyWage;
    private double numberOfHours;

    PartTimeEmployee() {
        super();
        hourlyWage = 0.0;
        numberOfHours = 0.0;
    }

    PartTimeEmployee(String name, int age, int id, String hireDate, double hourlyWage, double numberOfHours) {
        super(name, age, id, hireDate);
        this.hourlyWage = hourlyWage;
        this.numberOfHours = numberOfHours;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public double getNumberOfHours() {
        return numberOfHours;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setNumberOfHours(double numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String toString() {
        return "Part time employee information:\nName: " + getName() + "\nAge: " + getAge() + "\nID: " + getID() +
                "\nHire date: " + getHireDate() + "\nHourly wage: $" + hourlyWage + "\nNumber of hours: " + numberOfHours;
    }
}
