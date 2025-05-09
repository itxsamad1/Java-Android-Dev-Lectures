/**
 * Topic 5: Operators in Java
 * This program demonstrates the seven types of operators in Java:
 * 1. Arithmetic Operators
 * 2. Assignment Operators
 * 3. Comparison/Conditional Operators
 * 4. Logical Operators
 * 5. Binary Operators
 * 6. Unary Operators
 * 7. Ternary Operator
 */
public class Operators {
    public static void main(String[] args) {
        System.out.println("Java Operators Examples");
        System.out.println("======================");
        
        // 1. Arithmetic Operators
        System.out.println("\n1. Arithmetic Operators:");
        int a = 10;
        int b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        System.out.println("Modulus (a % b): " + (a % b));
        
        // 2. Assignment Operators
        System.out.println("\n2. Assignment Operators:");
        int c = 10;
        
        System.out.println("Original value: c = " + c);
        c += 5;  // c = c + 5
        System.out.println("After c += 5: " + c);
        c -= 3;  // c = c - 3
        System.out.println("After c -= 3: " + c);
        c *= 2;  // c = c * 2
        System.out.println("After c *= 2: " + c);
        c /= 6;  // c = c / 6
        System.out.println("After c /= 6: " + c);
        c %= 2;  // c = c % 2
        System.out.println("After c %= 2: " + c);
        
        // 3. Comparison/Conditional Operators
        System.out.println("\n3. Comparison Operators:");
        int d = 15;
        int e = 8;
        
        System.out.println("d = " + d + ", e = " + e);
        System.out.println("Equal to (d == e): " + (d == e));
        System.out.println("Not equal to (d != e): " + (d != e));
        System.out.println("Greater than (d > e): " + (d > e));
        System.out.println("Less than (d < e): " + (d < e));
        System.out.println("Greater than or equal to (d >= e): " + (d >= e));
        System.out.println("Less than or equal to (d <= e): " + (d <= e));
        
        // 4. Logical Operators
        System.out.println("\n4. Logical Operators:");
        boolean x = true;
        boolean y = false;
        
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("Logical AND (x && y): " + (x && y));
        System.out.println("Logical OR (x || y): " + (x || y));
        System.out.println("Logical NOT (!x): " + (!x));
        
        // More complex example
        int age = 25;
        int salary = 50000;
        boolean hasLoan = true;
        
        boolean isEligible = (age > 21 && salary > 30000) || !hasLoan;
        System.out.println("\nLoan Eligibility: " + isEligible);
        
        // 5. Binary (Bitwise) Operators
        System.out.println("\n5. Binary (Bitwise) Operators:");
        int num1 = 5;  // Binary: 0101
        int num2 = 3;  // Binary: 0011
        
        System.out.println("num1 = " + num1 + " (binary: " + Integer.toBinaryString(num1) + ")");
        System.out.println("num2 = " + num2 + " (binary: " + Integer.toBinaryString(num2) + ")");
        System.out.println("Bitwise AND (num1 & num2): " + (num1 & num2) + " (binary: " + Integer.toBinaryString(num1 & num2) + ")");
        System.out.println("Bitwise OR (num1 | num2): " + (num1 | num2) + " (binary: " + Integer.toBinaryString(num1 | num2) + ")");
        System.out.println("Bitwise XOR (num1 ^ num2): " + (num1 ^ num2) + " (binary: " + Integer.toBinaryString(num1 ^ num2) + ")");
        System.out.println("Bitwise NOT (~num1): " + (~num1));
        
        // 6. Unary Operators
        System.out.println("\n6. Unary Operators:");
        int f = 10;
        
        // Post-increment (value is used first, then incremented)
        System.out.println("Original value: f = " + f);
        System.out.println("Post-increment (f++): " + f++);
        System.out.println("After post-increment: " + f);
        
        // Pre-increment (value is incremented first, then used)
        System.out.println("Pre-increment (++f): " + (++f));
        System.out.println("After pre-increment: " + f);
        
        // Post-decrement (value is used first, then decremented)
        System.out.println("Post-decrement (f--): " + f--);
        System.out.println("After post-decrement: " + f);
        
        // Pre-decrement (value is decremented first, then used)
        System.out.println("Pre-decrement (--f): " + (--f));
        System.out.println("After pre-decrement: " + f);
        
        // 7. Ternary Operator
        System.out.println("\n7. Ternary Operator:");
        
        int age1 = 20;
        String status = (age1 >= 18) ? "Adult" : "Minor";
        System.out.println("Age: " + age1);
        System.out.println("Status: " + status);
        
        int number = 15;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("\nNumber: " + number);
        System.out.println("The number is: " + result);
        
        // More complex example
        int score = 85;
        String grade = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "F";
        System.out.println("\nScore: " + score);
        System.out.println("Grade: " + grade);
    }
} 