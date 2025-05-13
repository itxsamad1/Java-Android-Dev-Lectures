/**
 * Topic 9: Object-Oriented Programming Concepts in Java
 * 
 * FOUR PILLARS OF OBJECT-ORIENTED PROGRAMMING
 * ===========================================
 * 
 * 1. ENCAPSULATION - Bundling data and methods that operate on the data within a single unit
 *    - Hiding internal state and requiring all interaction to be performed through an object's methods
 *    - Implemented using private fields and public getter/setter methods
 *    - Benefits: Data protection, hiding implementation details, modularity
 * 
 * 2. INHERITANCE - Creating new classes from existing classes
 *    - Child classes inherit fields and methods from parent classes
 *    - Supports code reuse and establishing hierarchical relationships
 *    - Implemented using the 'extends' keyword
 *    - Benefits: Code reuse, method overriding, hierarchical classification
 * 
 * 3. POLYMORPHISM - Using a single interface for different data types
 *    - Same method name behaves differently depending on the object it is called on
 *    - Can be implemented through method overriding and method overloading
 *    - Benefits: Flexibility, extensibility, simplifies code
 * 
 * 4. ABSTRACTION - Hiding implementation details and exposing only functionality
 *    - Focuses on what an object does rather than how it does it
 *    - Implemented using abstract classes and interfaces
 *    - Benefits: Reduced complexity, isolates impact of changes
 * 
 * This program provides examples of all four pillars along with basic OOP concepts:
 * - Classes and Objects
 * - Attributes and Methods
 * - Constructors
 */
public class OOPConcepts {
    public static void main(String[] args) {
        System.out.println("JAVA OOP CONCEPTS EXAMPLES");
        System.out.println("==========================");
        
        ///////////////////////////////////////////////////////
        // Classes and Objects - The basic units of OOP
        ///////////////////////////////////////////////////////
        
        System.out.println("\n1. CREATING OBJECTS:");
        
        // Using constructor with parameters
        Person person1 = new Person("Abdul Samad", 25);
        Person person2 = new Person("Adeel", 30);
        
        // Display person details
        System.out.println("Person 1: " + person1.getName() + ", " + person1.getAge() + " years old");
        System.out.println("Person 2: " + person2.getName() + ", " + person2.getAge() + " years old");
        
        // Using methods
        System.out.println("\n2. USING METHODS:");
        person1.sayHello();
        person2.sayHello();
        
        ///////////////////////////////////////////////////////
        // PILLAR 1: ENCAPSULATION
        // Hiding data and providing controlled access via methods
        ///////////////////////////////////////////////////////
        
        System.out.println("\n3. ENCAPSULATION EXAMPLE:");
        // We cannot directly access private fields like person1.age
        // We must use getter and setter methods
        System.out.println("Before change - Person 1 age: " + person1.getAge());
        person1.setAge(26);
        System.out.println("After change - Person 1 age: " + person1.getAge());
        
        // Encapsulation allows data validation in setter methods
        System.out.println("Trying to set invalid age (-5):");
        person1.setAge(-5); // This will be rejected due to validation
        System.out.println("Age after invalid attempt: " + person1.getAge() + " (negative age rejected)");
        
        // Creating object using default constructor
        Person person3 = new Person();
        System.out.println("\nPerson 3 (default constructor): " + person3.getName() + ", " + person3.getAge() + " years old");
        person3.setName("Hafiz Muddasir");
        person3.setAge(22);
        System.out.println("After setting values - Person 3: " + person3.getName() + ", " + person3.getAge() + " years old");
        
        ///////////////////////////////////////////////////////
        // PILLAR 2: INHERITANCE
        // Creating new classes from existing classes
        ///////////////////////////////////////////////////////
        
        System.out.println("\n4. INHERITANCE EXAMPLE:");
        // Student class inherits from Person class (using 'extends')
        Student student1 = new Student("Abdul Samad", 20, "Computer Science");
        // Can use methods and properties from Person class
        System.out.println("Student: " + student1.getName() + ", " + student1.getAge() + " years old, Major: " + student1.getMajor());
        student1.sayHello(); // Method inherited from Person but overridden in Student
        student1.study();    // Method specific to Student
        
        // Another example of inheritance
        Teacher teacher1 = new Teacher("Prof. Abid", 45, "Computer Science");
        System.out.println("\nTeacher: " + teacher1.getName() + ", " + teacher1.getAge() + " years old, Department: " + teacher1.getDepartment());
        teacher1.sayHello();  // Method inherited from Person but overridden in Teacher
        teacher1.teach();     // Method specific to Teacher
        
        ///////////////////////////////////////////////////////
        // PILLAR 3: POLYMORPHISM
        // Same method behaves differently depending on the object
        ///////////////////////////////////////////////////////
        
        System.out.println("\n5. POLYMORPHISM EXAMPLE:");
        System.out.println("Different objects calling the same method with different implementations:");
        
        // Array can hold Person objects or any subclass of Person
        Person[] people = new Person[3];
        people[0] = person1;  // Person object
        people[1] = student1; // Student object (treated as Person)
        people[2] = teacher1; // Teacher object (treated as Person)
        
        // Polymorphic behavior - same method call, different behavior
        for (Person p : people) {
            p.sayHello(); // Each object responds according to its own implementation
        }
        
        ///////////////////////////////////////////////////////
        // PILLAR 4: ABSTRACTION
        // Hiding implementation details, focusing on functionality
        ///////////////////////////////////////////////////////
        
        System.out.println("\n6. ABSTRACTION EXAMPLE:");
        // Cannot instantiate an abstract class
        // Shape shape = new Shape(); // This would cause an error
        
        // Create objects of concrete subclasses
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        // Call abstract method - implementation details hidden
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
        
        // We don't need to know HOW each shape calculates its area
        // We just need to know that they CAN calculate area
    }
}

/*
 * Person class demonstrating encapsulation
 */
class Person {
    // Private attributes - ENCAPSULATION
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
    
    // Getter methods (accessors) - part of ENCAPSULATION
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Setter methods (mutators) - part of ENCAPSULATION
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age >= 0) {  // Data validation - benefit of encapsulation
            this.age = age;
        } else {
            System.out.println("Age cannot be negative");
        }
    }
}

/*
 * Student class inheriting from Person - example of INHERITANCE
 */
class Student extends Person {
    private String major;
    
    public Student(String name, int age, String major) {
        super(name, age); // Call parent constructor
        this.major = major;
    }
    
    // Override parent method - example of POLYMORPHISM
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
 * Teacher class inheriting from Person - another example of INHERITANCE
 */
class Teacher extends Person {
    private String department;
    
    public Teacher(String name, int age, String department) {
        super(name, age); // Call parent constructor
        this.department = department;
    }
    
    // Override parent method - example of POLYMORPHISM
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
 * Abstract class Shape - example of ABSTRACTION
 */
abstract class Shape {
    // Abstract method - no implementation here
    // Subclasses MUST provide an implementation
    public abstract double calculateArea();
    
    // Abstract classes can have concrete methods too
    public void displayType() {
        System.out.println("This is a shape");
    }
}

/*
 * Circle class inheriting from Shape
 */
class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Implementation of the abstract method
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
    
    // Implementation of the abstract method
    @Override
    public double calculateArea() {
        return width * height;
    }
} 