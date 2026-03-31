// Interface
interface Worker {
    void performDuties(); // every worker must implement this
}


class Person {
    String name;
    int id;

    // constructor
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + " (ID: " + id + ")");
    }
}

class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id); // call Person constructor
    }

    public void performDuties() {
        System.out.println("cooking food");
    }
}

// Waiter is a Person and also a Worker
class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("serving food");
    }
}

public class RestraurantManagement {
    public static void main(String[] args) {
        // Create a Chef and a Waiter
        Chef chef = new Chef("Raj", 101);
        Waiter waiter = new Waiter("Rahul", 102);

        // Introduce them
        chef.introduce();
        waiter.introduce();

        // Perform their duties
        chef.performDuties();
        waiter.performDuties();

        // Polymorphism
        System.out.println();

        Worker[] staff = {chef, waiter};
        for (Worker w : staff) {
            w.performDuties();
        }
    }
}
