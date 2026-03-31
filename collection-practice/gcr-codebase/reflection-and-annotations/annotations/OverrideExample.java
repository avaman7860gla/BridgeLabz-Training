class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    // Overriding method
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class OverrideExample {
    public static void main(String[] args) {

        Dog dog = new Dog();
        // calls overridden method
        dog.makeSound();   
    }
}
