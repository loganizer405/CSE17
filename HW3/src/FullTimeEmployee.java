public class FullTimeEmployee extends Employee {
    private double annualSalary;

    FullTimeEmployee() {
        super();
        annualSalary = 0.0;
    }

    FullTimeEmployee(String name, int age, int id, String hireDate, double annualSalary) {
        super(name, age, id, hireDate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public double getMonthlySalary() {
        return annualSalary / 12;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public String toString() {
        return "Full time employee information:\nName: " + getName() + "\nAge: " + getAge() + "\nID: " + getID() +
                "\nHire date: " + getHireDate() + "\nAnnual salary: $" + annualSalary;
    }
}
