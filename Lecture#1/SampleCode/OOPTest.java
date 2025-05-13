/**
 * Simple test class to demonstrate the four pillars of OOP
 */
public class OOPTest {
    public static void main(String[] args) {
        System.out.println("==== FOUR PILLARS OF OOP DEMO ====");
        
        // 1. Encapsulation
        System.out.println("\n1. ENCAPSULATION");
        System.out.println("------------------");
        Person p1 = new Person("John", 25);
        System.out.println("Created person: " + p1.getName() + ", " + p1.getAge() + " years old");
        
        // Private fields can only be accessed via getter/setter methods
        p1.setAge(26); // Valid operation
        System.out.println("After setAge(26): " + p1.getAge());
        
        p1.setAge(-5); // Invalid operation, will be rejected
        System.out.println("After setAge(-5): " + p1.getAge() + " (negative age rejected)");
        
        // 2. Inheritance
        System.out.println("\n2. INHERITANCE");
        System.out.println("------------------");
        Student s1 = new Student("Emma", 20, "Computer Science");
        System.out.println("Student inherits from Person: " + s1.getName() + ", " + s1.getAge() + 
                           " years old, studying " + s1.getMajor());
        
        // Student can use methods from Person
        s1.introduceSelf();
        
        // 3. Polymorphism
        System.out.println("\n3. POLYMORPHISM");
        System.out.println("------------------");
        
        System.out.println("Same method behaves differently depending on the object type:");
        
        Person[] people = new Person[3];
        people[0] = new Person("Alice", 30);
        people[1] = new Student("Bob", 22, "Physics");
        people[2] = new Teacher("Dr. Smith", 45, "Mathematics");
        
        for (Person person : people) {
            person.introduceSelf(); // Same method call, different implementations
        }
        
        // 4. Abstraction
        System.out.println("\n4. ABSTRACTION");
        System.out.println("------------------");
        
        // Cannot instantiate abstract class
        // Shape shape = new Shape(); // This would cause a compilation error
        
        // Create concrete implementations
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        
        System.out.println("Circle area: " + circle.calculateArea());
        System.out.println("Rectangle area: " + rectangle.calculateArea());
    }
}

// Classes for demonstration

class Person {
    // Private fields for encapsulation
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void introduceSelf() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }
    
    // Getters and setters
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
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Cannot set negative age.");
        }
    }
}

// Inheritance example
class Student extends Person {
    private String major;
    
    public Student(String name, int age, String major) {
        super(name, age);  // Call parent constructor
        this.major = major;
    }
    
    // Override method from parent (polymorphism)
    @Override
    public void introduceSelf() {
        System.out.println("Hi, I'm " + getName() + ", I'm " + getAge() + 
                           " years old, and I'm studying " + major + ".");
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
}

// Another inheritance example
class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    // Override method from parent (polymorphism)
    @Override
    public void introduceSelf() {
        System.out.println("Hello, I'm " + getName() + ", I'm " + getAge() + 
                           " years old, and I teach " + subject + ".");
    }
    
    public String getSubject() {
        return subject;
    }
}

// Abstraction example
abstract class Shape {
    // Abstract method - no implementation here
    public abstract double calculateArea();
}

// Concrete implementation of abstract class
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

// Another concrete implementation
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