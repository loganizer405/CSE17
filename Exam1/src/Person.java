public class Person {
    private String name;

    //constructors
    Person() {
        name = "";
    }

    Person(String name) {
        this.name = name;
    }

    public String getName() { //get name
        return name;
    }

    public void setName(String name) { //set name
        this.name = name;
    }

    public String toString() {
        return "Name: " + name;
    }
}
