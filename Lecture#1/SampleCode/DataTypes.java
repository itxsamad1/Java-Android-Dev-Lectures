/**
 * This program demonstrates the different data types in Java
 */
public class DataTypes {
    public static void main(String[] args) {
        // Primitive data types
        
        // 1. byte: 8-bit signed integer (-128 to 127)
        byte byteValue = 127;
        System.out.println("Byte value: " + byteValue);
        
        // 2. short: 16-bit signed integer (-32,768 to 32,767)
        short shortValue = 32767;
        System.out.println("Short value: " + shortValue);
        
        // 3. char: 16-bit Unicode character (0 to 65,535)
        char charValue = 'A';
        System.out.println("Char value: " + charValue);
        
        // 4. int: 32-bit signed integer (-2^31 to 2^31-1)
        int intValue = 2147483647;
        System.out.println("Int value: " + intValue);
        
        // 5. long: 64-bit signed integer (-2^63 to 2^63-1)
        long longValue = 9223372036854775807L; // Note the 'L' suffix
        System.out.println("Long value: " + longValue);
        
        // 6. float: 32-bit floating point
        float floatValue = 3.14159f; // Note the 'f' suffix
        System.out.println("Float value: " + floatValue);
        
        // 7. double: 64-bit floating point (default for decimal values)
        double doubleValue = 3.141592653589793;
        System.out.println("Double value: " + doubleValue);
        
        // 8. boolean: true or false
        boolean booleanValue = true;
        System.out.println("Boolean value: " + booleanValue);
        
        // Memory size demonstration
        System.out.println("\nMemory size of primitive data types:");
        System.out.println("byte: " + Byte.SIZE + " bits");
        System.out.println("short: " + Short.SIZE + " bits");
        System.out.println("char: " + Character.SIZE + " bits");
        System.out.println("int: " + Integer.SIZE + " bits");
        System.out.println("long: " + Long.SIZE + " bits");
        System.out.println("float: " + Float.SIZE + " bits");
        System.out.println("double: " + Double.SIZE + " bits");
    }
} 