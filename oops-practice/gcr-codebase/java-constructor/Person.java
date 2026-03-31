class Person {

    // Instance variables
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Method to display person details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {

        // Creating an object using parameterized constructor
        Person p1 = new Person("Alice", 30);

        // Creating a copy of p1 using copy constructor
        Person p2 = new Person(p1);

        // Displaying details of both persons
        p1.display();
        p2.display();
    }
}
