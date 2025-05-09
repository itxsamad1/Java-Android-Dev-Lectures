/**
 * Topic 6: Loops in Java
 * This program demonstrates the different types of loops in Java:
 * 1. for loop
 * 2. while loop
 * 3. do-while loop
 * 4. Enhanced for loop (for-each)
 */
public class Loops {
    public static void main(String[] args) {
        System.out.println("Java Loops Examples");
        System.out.println("==================");
        
        // 1. for loop
        // Syntax: for(initialization; condition; update) { ... }
        System.out.println("\n1. For Loop:");
        System.out.println("Counting from 1 to 5:");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // For loop with multiple variables
        System.out.println("\nFor loop with multiple variables:");
        for (int i = 1, j = 10; i <= 5; i++, j--) {
            System.out.println("i = " + i + ", j = " + j);
        }
        
        // 2. while loop
        // Syntax: while(condition) { ... }
        System.out.println("\n2. While Loop:");
        System.out.println("Counting down from 5 to 1:");
        
        int count = 5;
        while (count > 0) {
            System.out.println("Count: " + count);
            count--;
        }
        
        // 3. do-while loop
        // Syntax: do { ... } while(condition);
        System.out.println("\n3. Do-While Loop:");
        System.out.println("Counting from 1 to 5:");
        
        int doCount = 1;
        do {
            System.out.println("Count: " + doCount);
            doCount++;
        } while (doCount <= 5);
        
        // Key difference with while loop - do-while executes at least once
        System.out.println("\nDo-While with false condition still executes once:");
        
        int x = 10;
        do {
            System.out.println("This will print once even though condition is false");
            x++;
        } while (x < 10);
        
        // 4. Enhanced for loop (for-each)
        // Syntax: for(dataType item : collection) { ... }
        System.out.println("\n4. Enhanced For Loop (for-each):");
        
        int[] numbers = {1, 2, 3, 4, 5};
        
        System.out.println("Iterating through an array:");
        for (int num : numbers) {
            System.out.println("Number: " + num);
        }
        
        // Loop control statements
        System.out.println("\nLoop Control Statements:");
        
        // break - exits the loop
        System.out.println("\nBreak Example:");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                System.out.println("Breaking the loop at i = " + i);
                break;
            }
            System.out.println("Value of i: " + i);
        }
        
        // continue - skips the current iteration
        System.out.println("\nContinue Example:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                // Skip even numbers
                continue;
            }
            System.out.println("Odd number: " + i);
        }
        
        // Nested loops
        System.out.println("\nNested Loops Example:");
        System.out.println("Multiplication Table (1-5):");
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();  // New line after each row
        }
    }
} 