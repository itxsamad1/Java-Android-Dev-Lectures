/**
 * Topic 3: Data Types in Java
 * This program demonstrates the primitive data types in Java.
 */
public class DataTypes {
    public static void main(String[] args) {
        System.out.println("Java Data Types Examples");
        System.out.println("=======================");
        
        // Primitive Data Types
        
        // 1. byte: 8-bit signed integer (-128 to 127)
        byte myByte = 127;
        System.out.println("byte: " + myByte);
        
        // 2. short: 16-bit signed integer (-32,768 to 32,767)
        short myShort = 32767;
        System.out.println("short: " + myShort);
        
        // 3. int: 32-bit signed integer (-2,147,483,648 to 2,147,483,647)
        int myInt = 2147483647;
        System.out.println("int: " + myInt);
        
        // 4. long: 64-bit signed integer (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807)
        long myLong = 9223372036854775807L;  // Note the 'L' suffix
        System.out.println("long: " + myLong);
        
        // 5. float: 32-bit floating point
        float myFloat = 3.14f;  // Note the 'f' suffix
        System.out.println("float: " + myFloat);
        
        // 6. double: 64-bit floating point (default for decimal values)
        double myDouble = 3.14159265359;
        System.out.println("double: " + myDouble);
        
        // 7. char: 16-bit Unicode character (0 to 65,535)
        char myChar = 'A';
        System.out.println("char: " + myChar);
        
        // 8. boolean: true or false
        boolean myBoolean = true;
        System.out.println("boolean: " + myBoolean);
        
        // Size and range of primitive data types
        System.out.println("\nSize of Data Types (in bits):");
        System.out.println("byte: " + Byte.SIZE);
        System.out.println("short: " + Short.SIZE);
        System.out.println("int: " + Integer.SIZE);
        System.out.println("long: " + Long.SIZE);
        System.out.println("float: " + Float.SIZE);
        System.out.println("double: " + Double.SIZE);
        System.out.println("char: " + Character.SIZE);
        
        // Non-primitive data types (Reference types)
        System.out.println("\nReference Types:");
        
        // String: sequence of characters
        String myString = "Hello Java";
        System.out.println("String: " + myString);
        
        // Array: collection of similar data types
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println("Array: " + myArray[0] + ", " + myArray[1] + ", " + myArray[2]);
    }
} 