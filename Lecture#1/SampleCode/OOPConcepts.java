/**
 * Topic 9: Object-Oriented Programming Concepts in Java
 * This program demonstrates basic OOP concepts:
 * 1. Classes and Objects
 * 2. Attributes and Methods
 * 3. Constructors
 * 4. Encapsulation (Getter and Setter methods)
 */
public class OOPConcepts {
    public static void main(String[] args) {
        System.out.println("Java OOP Concepts Examples");
        System.out.println("=========================");
        
        // Creating objects from the Person class
        System.out.println("\n1. Creating Objects:");
        
        // Using constructor with parameters
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Alice", 30);
        
        // Display person details
        System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge() + " years old");
        System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge() + " years old");
        
        // Using methods
        System.out.println("\n2. Using Methods:");
        person1.sayHello();
        person2.sayHello();
        
        // Changing object state using setter methods
        System.out.println("\n3. Modifying Object State:");
        System.out.println("Before change - Person 1 age: " + person1.getAge());
        person1.setAge(26);
        System.out.println("After change - Person 1 age: " + person1.getAge());
        
        // Creating object using default constructor
        Person person3 = new Person();
        System.out.println("\nPerson 3 (default constructor): " + person3.getName() + ", " + person3.getAge() + " years old");
        person3.setName("Bob");
        person3.setAge(22);
        System.out.println("After setting values - Person 3: " + person3.getName() + ", " + person3.getAge() + " years old");
        
        // Working with Student class (demonstration of inheritance would be in later lectures)
        System.out.println("\n4. Creating Different Class Object:");
        Student student1 = new Student("Emma", 20, "Computer Science");
        System.out.println("Student: " + student1.getName() + ", " + student1.getAge() + " years old, Major: " + student1.getMajor());
        student1.study();
    }
}

/*
 * Person class demonstrating basic OOP concepts
 */
class Person {
    // Attributes (instance variables)
    private String name;
    private int age;
    
    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }
    
    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Method
    public void sayHello() {
        System.out.println(name + " says: Hello!");
    }
    
    // Getter methods (accessors)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods (mutators)
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {  // Basic validation
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
}

/*
 * Student class 
 */
class Student {
    private String name;
    private int age;
    private String major;
    
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
    
    public void study() {
        System.out.println(name + " is studying " + major);
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
} 