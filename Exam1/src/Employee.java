public class Employee extends Person {
    private int id;

    //constructors
    Employee() {
        super();
        id = 0;
    }

    Employee(String name, int id) {
        super(name);
        this.id = id;
    }

    public int getID() { //returns ID
        return id;
    }

    public void setID(int id) { //sets ID
        this.id = id;
    }

    public String toString() {
        //returns the toString() from Person (includes name) and add on ID
        return super.toString() + ", ID: " + id;
    }
}
