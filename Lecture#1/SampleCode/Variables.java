/**
 * This program demonstrates variable naming rules in Java
 */
public class Variables {
    public static void main(String[] args) {
        // Rule 1 & 2: Can use uppercase and lowercase letters
        String MyVariable = "Using uppercase letters";
        String myVariable = "Using lowercase letters";
        
        // Rule 3: Can use numbers (but not at start)
        String variable1 = "Variable with number";
        // String 1variable = "Invalid: Can't start with number"; // This would cause error
        
        // Rule 4: Use underscore instead of spaces
        String user_name = "Using underscore instead of space";
        
        // Rule 5: Can use $ special character
        String $specialVar = "Variable with $ symbol";
        String special$Var = "Variable with $ symbol in middle";
        
        // Valid but not recommended - using both underscore and $
        String $_mixed_var = "Mixed variable name";
        
        // Java convention - camelCase for variables
        String camelCaseVariable = "Following Java convention";
        
        // Constants are typically UPPERCASE with underscores
        final String CONSTANT_VALUE = "This is a constant";
        
        // Print all variables
        System.out.println("Demonstrating variable naming rules:");
        System.out.println("Uppercase: " + MyVariable);
        System.out.println("Lowercase: " + myVariable);
        System.out.println("With number: " + variable1);
        System.out.println("With underscore: " + user_name);
        System.out.println("With $ at start: " + $specialVar);
        System.out.println("With $ in middle: " + special$Var);
        System.out.println("Mixed style: " + $_mixed_var);
        System.out.println("camelCase (convention): " + camelCaseVariable);
        System.out.println("CONSTANT: " + CONSTANT_VALUE);
    }
} 