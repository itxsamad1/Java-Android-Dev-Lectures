/**
 * This program demonstrates implicit and explicit typecasting in Java
 */
public class Typecasting {
    public static void main(String[] args) {
        System.out.println("Typecasting in Java");
        System.out.println("===================\n");
        
        // 1. Implicit Typecasting (Widening)
        // Smaller type to larger type - done automatically
        System.out.println("Implicit Typecasting (Widening):");
        
        // byte -> short -> int -> long -> float -> double
        byte byteValue = 100;
        short shortValue = byteValue;     // byte to short
        int intValue = shortValue;        // short to int
        long longValue = intValue;        // int to long
        float floatValue = longValue;     // long to float
        double doubleValue = floatValue;  // float to double
        
        System.out.println("byte value: " + byteValue);
        System.out.println("After byte to short: " + shortValue);
        System.out.println("After short to int: " + intValue);
        System.out.println("After int to long: " + longValue);
        System.out.println("After long to float: " + floatValue);
        System.out.println("After float to double: " + doubleValue);
        
        // char to int
        char charValue = 'A';
        int charToInt = charValue;  // Stores the ASCII value of 'A' (65)
        System.out.println("\nchar '" + charValue + "' to int: " + charToInt);
        
        // 2. Explicit Typecasting (Narrowing)
        // Larger type to smaller type - requires explicit casting
        System.out.println("\nExplicit Typecasting (Narrowing):");
        
        double doubleNum = 123.456;
        float floatNum = (float) doubleNum;     // double to float
        long longNum = (long) floatNum;         // float to long
        int intNum = (int) longNum;             // long to int
        short shortNum = (short) intNum;        // int to short
        byte byteNum = (byte) shortNum;         // short to byte
        
        System.out.println("Original double value: " + doubleNum);
        System.out.println("After double to float: " + floatNum);
        System.out.println("After float to long: " + longNum);
        System.out.println("After long to int: " + intNum);
        System.out.println("After int to short: " + shortNum);
        System.out.println("After short to byte: " + byteNum);
        
        // Potential data loss example
        int largeInt = 129;  // Out of byte range (-128 to 127)
        byte smallByte = (byte) largeInt;
        System.out.println("\nPotential data loss:");
        System.out.println("Original int value: " + largeInt);
        System.out.println("After conversion to byte: " + smallByte);  // Result will be -127
    }
} 