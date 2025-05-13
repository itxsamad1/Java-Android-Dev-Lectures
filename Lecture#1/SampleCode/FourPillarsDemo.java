/**
 * Simple demonstration of the Four Pillars of OOP:
 * 1. Encapsulation
 * 2. Inheritance
 * 3. Polymorphism
 * 4. Abstraction
 */
public class FourPillarsDemo {
    public static void main(String[] args) {
        System.out.println("===== FOUR PILLARS OF OOP =====");
        
        // ENCAPSULATION
        System.out.println("\n1. ENCAPSULATION");
        System.out.println("-------------------");
        System.out.println("Hiding data and methods within a class and controlling access through public methods");
        
        Animal dog = new Animal("Dog", 4);
        System.out.println("Created animal: " + dog.getSpecies() + " with " + dog.getLegs() + " legs");
        dog.setLegs(3); // A dog could lose a leg
        System.out.println("Updated legs: " + dog.getLegs());
        
        try {
            dog.setLegs(-1); // Invalid value
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // INHERITANCE
        System.out.println("\n2. INHERITANCE");
        System.out.println("-------------------");
        System.out.println("A child class inherits properties and methods from a parent class");
        
        Dog fido = new Dog("Fido", "Labrador");
        System.out.println(fido.getSpecies() + " named " + fido.getName() + " of breed " + fido.getBreed() + " has " + fido.getLegs() + " legs");
        fido.makeSound(); // Method from parent class
        fido.fetch();     // Method specific to Dog class
        
        // POLYMORPHISM
        System.out.println("\n3. POLYMORPHISM");
        System.out.println("-------------------");
        System.out.println("Objects of different classes respond to the same method in different ways");
        
        Animal[] animals = new Animal[3];
        animals[0] = new Animal("Generic Animal", 4);
        animals[1] = new Dog("Rex", "German Shepherd");
        animals[2] = new Cat("Whiskers");
        
        // Same method call, different implementations
        for (Animal animal : animals) {
            System.out.print(animal.getSpecies() + ": ");
            animal.makeSound();
        }
        
        // ABSTRACTION
        System.out.println("\n4. ABSTRACTION");
        System.out.println("-------------------");
        System.out.println("Hiding implementation details and showing only functionality to the user");
        
        // Cannot instantiate an abstract class
        // Vehicle v = new Vehicle(); // This would cause a compilation error
        
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle();
        
        System.out.println("Car speed: " + car.getMaxSpeed() + " mph");
        System.out.println("Bicycle speed: " + bicycle.getMaxSpeed() + " mph");
        
        car.move();
        bicycle.move();
    }
}

// Classes for demonstration

// Encapsulation example
class Animal {
    private String species;
    private int legs;
    
    public Animal(String species, int legs) {
        this.species = species;
        this.legs = legs;
    }
    
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
    
    // Getters and setters
    public String getSpecies() {
        return species;
    }
    
    public int getLegs() {
        return legs;
    }
    
    public void setSpecies(String species) {
        this.species = species;
    }
    
    public void setLegs(int legs) {
        if (legs < 0) {
            throw new IllegalArgumentException("Number of legs cannot be negative");
        }
        this.legs = legs;
    }
}

// Inheritance example
class Dog extends Animal {
    private String name;
    private String breed;
    
    public Dog(String name, String breed) {
        super("Dog", 4); // Call parent constructor
        this.name = name;
        this.breed = breed;
    }
    
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
    
    // Override method from parent (polymorphism)
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getBreed() {
        return breed;
    }
}

// Another inheritance example
class Cat extends Animal {
    private String name;
    
    public Cat(String name) {
        super("Cat", 4);
        this.name = name;
    }
    
    // Override method from parent (polymorphism)
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
    
    public String getName() {
        return name;
    }
}

// Abstraction example
abstract class Vehicle {
    // Abstract method - no implementation here
    public abstract void move();
    
    // Concrete method
    public abstract int getMaxSpeed();
}

// Concrete implementation of abstract class
class Car extends Vehicle {
    private String brand;
    
    public Car(String brand) {
        this.brand = brand;
    }
    
    @Override
    public void move() {
        System.out.println("Car is driving on the road");
    }
    
    @Override
    public int getMaxSpeed() {
        return 120;
    }
}

// Another concrete implementation
class Bicycle extends Vehicle {
    @Override
    public void move() {
        System.out.println("Bicycle is being pedaled");
    }
    
    @Override
    public int getMaxSpeed() {
        return 20;
    }
} 