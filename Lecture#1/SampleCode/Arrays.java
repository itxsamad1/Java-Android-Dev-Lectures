/**
 * Topic 7: Arrays in Java
 * This program demonstrates the different ways to create and use arrays in Java.
 */
public class Arrays {
    public static void main(String[] args) {
        System.out.println("Java Arrays Examples");
        System.out.println("===================");
        
        // 1. Array Declaration and Initialization
        System.out.println("\n1. Array Declaration and Initialization:");
        
        // Method 1: Declare and then initialize
        int[] numbers;       // Declaration
        numbers = new int[5]; // Initialization with size
        
        // Assigning values
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        System.out.println("First element: " + numbers[0]);
        System.out.println("Second element: " + numbers[1]);
        
        // Method 2: Declare and initialize in one step
        int[] scores = new int[3];
        scores[0] = 85;
        scores[1] = 90;
        scores[2] = 78;
        
        // Method 3: Declare and initialize with values
        int[] marks = {95, 80, 75, 90, 88};
        System.out.println("\nMarks array length: " + marks.length);
        System.out.println("Third mark: " + marks[2]);
        
        // 2. Accessing and Modifying Array Elements
        System.out.println("\n2. Accessing and Modifying Array Elements:");
        
        System.out.println("Original value at index 1: " + marks[1]);
        marks[1] = 85;  // Modifying value
        System.out.println("New value at index 1: " + marks[1]);
        
        // 3. Iterating Through Arrays
        System.out.println("\n3. Iterating Through Arrays:");
        
        // Method 1: Using for loop with index
        System.out.println("\nUsing standard for loop:");
        for (int i = 0; i < marks.length; i++) {
            System.out.println("marks[" + i + "] = " + marks[i]);
        }
        
        // Method 2: Using enhanced for loop (for-each)
        System.out.println("\nUsing enhanced for loop:");
        for (int mark : marks) {
            System.out.println("Mark: " + mark);
        }
        
        // 4. Multi-Dimensional Arrays
        System.out.println("\n4. Multi-Dimensional Arrays:");
        
        // 2D Array - 3 rows, 2 columns
        int[][] matrix = new int[3][2];
        
        // Initialization
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[2][0] = 5;
        matrix[2][1] = 6;
        
        // Displaying 2D array
        System.out.println("\n2D Array (Matrix):");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();  // New line after each row
        }
        
        // Alternative way to declare and initialize 2D array
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\nAnother 2D Array (Grid):");
        for (int[] row : grid) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
        
        // 5. Common Array Operations
        System.out.println("\n5. Common Array Operations:");
        
        // Finding the sum of array elements
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        System.out.println("Sum of marks: " + sum);
        
        // Finding the average
        double average = (double) sum / marks.length;
        System.out.println("Average mark: " + average);
        
        // Finding the maximum value
        int max = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        System.out.println("Maximum mark: " + max);
        
        // Finding the minimum value
        int min = marks[0];
        for (int i = 1; i < marks.length; i++) {
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        System.out.println("Minimum mark: " + min);
    }
} 