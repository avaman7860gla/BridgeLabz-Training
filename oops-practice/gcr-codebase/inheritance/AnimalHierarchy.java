
class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Override Method
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}


class Dog extends Animal {
    // Constructor
    Dog(String name, int age) {
        super(name, age);
    }

    // Override Method
    void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {

    // Constructor
    Cat(String name, int age) {
        super(name, age);
    }

    // Override Method
    void makeSound() {
        System.out.println("Meow");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println("Chirp");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        // Create objects of different animals
        Dog dog = new Dog("Labra", 3);
        Cat cat = new Cat("Whisker", 2);
        Bird bird = new Bird("Sparrow", 1);

        // Call their makeSound methods
        dog.makeSound(); 
        cat.makeSound(); 
        bird.makeSound();

        // Show their names and ages
        System.out.println(dog.name + " is " + dog.age + " years old.");
        System.out.println(cat.name + " is " + cat.age + " years old.");
        System.out.println(bird.name + " is " + bird.age + " years old.");

        // Polymorphism
        Animal a1 = new Dog("Rocky", 4);
        Animal a2 = new Cat("Kitty", 5);
        Animal a3 = new Bird("Parrot", 2);

        a1.makeSound(); 
        a2.makeSound(); 
        a3.makeSound(); 
    }
}

