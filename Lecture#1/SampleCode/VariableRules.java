/**
 * Topic 2: Variable Naming Rules
 * 
 * Rules for Java variable names:
 * 1. Can use A-Z (uppercase letters)
 * 2. Can use a-z (lowercase letters)
 * 3. Can use 0-9 (numbers, but not at the start)
 * 4. Cannot use spaces, use _ (underscore) instead
 * 5. Can use $ (special character)
 */
public class VariableRules {
    public static void main(String[] args) {
        System.out.println("Java Variable Naming Rules Examples:");
        System.out.println("====================================");
        
        // Rule 1 & 2: Can use uppercase and lowercase letters
        String MyName = "John";                  // Starting with uppercase (not recommended but valid)
        String myName = "John";                  // Starting with lowercase (recommended)
        
        // Rule 3: Can use numbers (but not at start)
        String player1 = "Player One";           // Valid - number not at start
        // String 1player = "Invalid";           // Invalid - can't start with number
        
        // Rule 4: Use underscore instead of spaces
        String user_name = "john_doe";           // Using underscore
        String lastName = "Smith";               // camelCase is preferred in Java
        
        // Rule 5: Can use $ special character
        String $price = "100.00";                // Starting with $
        String currency$ = "USD";                // Ending with $
        
        // Print all variables
        System.out.println("MyName: " + MyName);
        System.out.println("myName: " + myName);
        System.out.println("player1: " + player1);
        System.out.println("user_name: " + user_name);
        System.out.println("lastName: " + lastName);
        System.out.println("$price: " + $price);
        System.out.println("currency$: " + currency$);
        
        // Java naming conventions
        System.out.println("\nJava Naming Conventions:");
        System.out.println("========================");
        
        // Variables should start with lowercase letter (camelCase)
        String firstName = "John";
        
        // Constants should be all uppercase with underscores
        final double PI = 3.14159;
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydb";
        
        // Class names should start with uppercase letter (PascalCase)
        // Example: VariableRules, String, Integer
        
        System.out.println("Variable (camelCase): " + firstName);
        System.out.println("Constant (UPPERCASE): " + PI);
        System.out.println("Constant (UPPERCASE): " + DATABASE_URL);
    }
} 