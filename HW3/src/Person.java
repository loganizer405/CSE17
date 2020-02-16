public class Person {
    private String name;
    private int age;

    //constructors
    Person() {
        name = "";
        age = 0;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person information:\nName: " + name + "\nAge: " + age;
    }

    public boolean equals(Object obj) {
        return obj instanceof Person && name.equals(((Person) obj).getName());
    }
}
