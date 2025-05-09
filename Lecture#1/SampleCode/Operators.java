/**
 * This program demonstrates different types of operators in Java
 */
public class Operators {
    public static void main(String[] args) {
        System.out.println("Operators in Java");
        System.out.println("=================\n");
        
        int a = 10;
        int b = 5;
        
        // 1. Arithmetic Operators
        System.out.println("Arithmetic Operators:");
        System.out.println("a + b = " + (a + b));   // Addition
        System.out.println("a - b = " + (a - b));   // Subtraction
        System.out.println("a * b = " + (a * b));   // Multiplication
        System.out.println("a / b = " + (a / b));   // Division
        System.out.println("a % b = " + (a % b));   // Modulus (remainder)
        
        // 2. Assignment Operators
        System.out.println("\nAssignment Operators:");
        int c = 10;
        System.out.println("Initial value: c = " + c);
        
        c += 5;  // Same as: c = c + 5
        System.out.println("After c += 5: " + c);
        
        c -= 3;  // Same as: c = c - 3
        System.out.println("After c -= 3: " + c);
        
        c *= 2;  // Same as: c = c * 2
        System.out.println("After c *= 2: " + c);
        
        c /= 4;  // Same as: c = c / 4
        System.out.println("After c /= 4: " + c);
        
        c %= 3;  // Same as: c = c % 3
        System.out.println("After c %= 3: " + c);
        
        // 3. Comparison/Conditional Operators
        System.out.println("\nComparison Operators:");
        System.out.println("a > b: " + (a > b));    // Greater than
        System.out.println("a < b: " + (a < b));    // Less than
        System.out.println("a >= b: " + (a >= b));  // Greater than or equal to
        System.out.println("a <= b: " + (a <= b));  // Less than or equal to
        System.out.println("a == b: " + (a == b));  // Equal to
        System.out.println("a != b: " + (a != b));  // Not equal to
        
        // 4. Logical Operators
        System.out.println("\nLogical Operators:");
        boolean x = true;
        boolean y = false;
        
        System.out.println("x && y: " + (x && y));  // Logical AND
        System.out.println("x || y: " + (x || y));  // Logical OR
        System.out.println("!x: " + (!x));          // Logical NOT
        
        // 5. Binary Operators
        System.out.println("\nBinary Operators:");
        System.out.println("a & b: " + (a & b));    // Bitwise AND
        System.out.println("a | b: " + (a | b));    // Bitwise OR
        System.out.println("a ^ b: " + (a ^ b));    // Bitwise XOR
        
        // 6. Unary Operators
        System.out.println("\nUnary Operators:");
        
        // Post-increment
        int d = 5;
        System.out.println("d = " + d);
        System.out.println("d++ = " + (d++));  // First use, then increment
        System.out.println("After d++, d = " + d);
        
        // Pre-increment
        int e = 5;
        System.out.println("\ne = " + e);
        System.out.println("++e = " + (++e));  // First increment, then use
        System.out.println("After ++e, e = " + e);
        
        // Post-decrement
        int f = 5;
        System.out.println("\nf = " + f);
        System.out.println("f-- = " + (f--));  // First use, then decrement
        System.out.println("After f--, f = " + f);
        
        // Pre-decrement
        int g = 5;
        System.out.println("\ng = " + g);
        System.out.println("--g = " + (--g));  // First decrement, then use
        System.out.println("After --g, g = " + g);
        
        // 7. Ternary Operator
        System.out.println("\nTernary Operator:");
        int age = 20;
        String status = (age >= 18) ? "Adult" : "Minor";
        System.out.println("Age = " + age);
        System.out.println("Status: " + status);
        
        // Another example
        int num = 7;
        String result = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println("\nNumber = " + num);
        System.out.println("Number is: " + result);
    }
} 