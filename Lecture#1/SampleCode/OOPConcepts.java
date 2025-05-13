/**
 * Topic 9: Object-Oriented Programming Concepts in Java
 * This program demonstrates the four pillars of OOP:
 * 1. Encapsulation - Bundling data and methods that operate on the data within a single unit
 * 2. Inheritance - Creating new classes from existing classes
 * 3. Polymorphism - Using a single interface for different data types
 * 4. Abstraction - Hiding implementation details and exposing only functionality
 * 
 * Along with basic OOP concepts:
 * - Classes and Objects
 * - Attributes and Methods
 * - Constructors
 */
public class OOPConcepts {
    public static void main(String[] args) {
        System.out.println("JAVA OOP CONCEPTS EXAMPLES");
        System.out.println("==========================");
        
        // Creating objects from the Person class
        System.out.println("\n1. CREATING OBJECTS:");
        
        // Using constructor with parameters
        Person person1 = new Person("John", 25);
        Person person2 = new Person("Alice", 30);
        
        // Display person details
        System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge() + " years old");
        System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge() + " years old");
        
        // Using methods
        System.out.println("\n2. USING METHODS:");
        person1.sayHello();
        person2.sayHello();
        
        // Changing object state using setter methods (Encapsulation)
        System.out.println("\n3. ENCAPSULATION EXAMPLE:");
        System.out.println("Before change - Person 1 age: " + person1.getAge());
        person1.setAge(26);
        System.out.println("After change - Person 1 age: " + person1.getAge());
        
        // Try to set invalid age
        System.out.println("Trying to set invalid age (-5):");
        person1.setAge(-5); // This will be rejected due to validation
        System.out.println("Age after invalid attempt: " + person1.getAge());
        
        // Creating object using default constructor
        Person person3 = new Person();
        System.out.println("\nPerson 3 (default constructor): " + person3.getName() + ", " + person3.getAge() + " years old");
        person3.setName("Bob");
        person3.setAge(22);
        System.out.println("After setting values - Person 3: " + person3.getName() + ", " + person3.getAge() + " years old");
        
        // Inheritance Example
        System.out.println("\n4. INHERITANCE EXAMPLE:");
        Student student1 = new Student("Emma", 20, "Computer Science");
        System.out.println("Student: " + student1.getName() + ", " + student1.getAge() + " years old, Major: " + student1.getMajor());
        student1.sayHello(); // Method inherited from Person but overridden in Student
        student1.study();    // Method specific to Student
        
        // Create a teacher
        Teacher teacher1 = new Teacher("Prof. Smith", 45, "Computer Science");
        System.out.println("\nTeacher: " + teacher1.getName() + ", " + teacher1.getAge() + " years old, Department: " + teacher1.getDepartment());
        teacher1.sayHello();  // Method inherited from Person but overridden in Teacher
        teacher1.teach();     // Method specific to Teacher
        
        // Polymorphism Example
        System.out.println("\n5. POLYMORPHISM EXAMPLE:");
        System.out.println("Different objects calling the same method with different implementations:");
        
        Person[] people = new Person[3];
        people[0] = person1;  // Person object
        people[1] = student1; // Student object (treated as Person)
        people[2] = teacher1; // Teacher object (treated as Person)
        
        // Polymorphic behavior
        for (Person p : people) {
            p.sayHello(); // Each object responds according to its own implementation
        }
        
        // Abstraction Example
        System.out.println("\n6. ABSTRACTION EXAMPLE:");
        // We cannot instantiate an abstract class
        // Shape shape = new Shape(); // This would cause an error
        
        // But we can create objects of concrete subclasses
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        // We can call the abstract method which is implemented differently in each subclass
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}

/*
 * Person class demonstrating encapsulation
 */
class Person {
    // Attributes (instance variables) - private for encapsulation
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
 * Student class inheriting from Person - example of inheritance
 */
class Student extends Person {
    private String major;
    
    public Student(String name, int age, String major) {
        super(name, age); // Call parent constructor
        this.major = major;
    }
    
    // Override parent method - example of polymorphism
    @Override
    public void sayHello() {
        System.out.println(getName() + " the student says: Hello there!");
    }
    
    public void study() {
        System.out.println(getName() + " is studying " + major);
    }
    
    // Getter and setter for the new field
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
}

/*
 * Teacher class inheriting from Person - another example of inheritance
 */
class Teacher extends Person {
    private String department;
    
    public Teacher(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
    // Override parent method - example of polymorphism
    @Override
    public void sayHello() {
        System.out.println(getName() + " the professor says: Welcome to class!");
    }
    
    public void teach() {
        System.out.println(getName() + " is teaching in the " + department + " department");
    }
    
    // Getter and setter for the new field
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}

/*
 * Abstract class Shape - example of abstraction
 */
abstract class Shape {
    // Abstract method that must be implemented by subclasses
    public abstract double calculateArea();
}

/*
 * Circle class inheriting from Shape
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

/*
 * Rectangle class inheriting from Shape
 */
class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
} 