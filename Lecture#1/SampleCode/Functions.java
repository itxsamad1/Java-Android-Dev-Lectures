/**
 * Topic 8: Functions (Methods) in Java
 * This program demonstrates how to define and use methods in Java.
 */
public class Functions {
    public static void main(String[] args) {
        System.out.println("Java Methods (Functions) Examples");
        System.out.println("================================");
        
        // 1. Calling a method without parameters and without return value
        System.out.println("\n1. Method without parameters and without return value:");
        displayMessage();
        
        // 2. Calling a method with parameters but without return value
        System.out.println("\n2. Method with parameters but without return value:");
        greetUser("John");
        greetUser("Alice");
        
        // 3. Calling a method with parameters and with return value
        System.out.println("\n3. Method with parameters and with return value:");
        int sum = add(5, 3);
        System.out.println("Sum of 5 and 3 is: " + sum);
        
        // Direct use of returned value
        System.out.println("Product of 4 and 6 is: " + multiply(4, 6));
        
        // 4. Method Overloading (same name, different parameters)
        System.out.println("\n4. Method Overloading:");
        System.out.println("Sum of two integers: " + sum(10, 20));
        System.out.println("Sum of three integers: " + sum(10, 20, 30));
        System.out.println("Sum of two doubles: " + sum(10.5, 20.5));
        
        // 5. Recursive Methods (methods that call themselves)
        System.out.println("\n5. Recursive Methods:");
        System.out.println("Factorial of 5: " + factorial(5));
        
        // 6. Passing Arrays to Methods
        System.out.println("\n6. Passing Arrays to Methods:");
        int[] numbers = {5, 10, 15, 20, 25};
        System.out.println("Average of array elements: " + calculateAverage(numbers));
        
        // 7. Variable Arguments (varargs)
        System.out.println("\n7. Variable Arguments (varargs):");
        System.out.println("Sum using varargs (1, 2, 3): " + sumVarargs(1, 2, 3));
        System.out.println("Sum using varargs (1, 2, 3, 4, 5): " + sumVarargs(1, 2, 3, 4, 5));
        System.out.println("Sum using varargs (): " + sumVarargs()); // No arguments
    }
    
    // 1. Method without parameters and without return value
    public static void displayMessage() {
        System.out.println("Hello from the displayMessage method!");
    }
    
    // 2. Method with parameters but without return value
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "! Welcome to Java programming.");
    }
    
    // 3. Methods with parameters and with return value
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    // 4. Method Overloading examples
    // Same method name with different parameter lists
    
    // Sum of two integers
    public static int sum(int a, int b) {
        return a + b;
    }
    
    // Sum of three integers
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    
    // Sum of two doubles
    public static double sum(double a, double b) {
        return a + b;
    }
    
    // 5. Recursive Method example
    public static int factorial(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case
        return n * factorial(n - 1);
    }
    
    // 6. Method that accepts an array as parameter
    public static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }
    
    // 7. Method with variable arguments (varargs)
    public static int sumVarargs(int... numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
} 