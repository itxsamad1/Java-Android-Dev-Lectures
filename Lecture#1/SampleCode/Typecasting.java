/**
 * Topic 4: Typecasting in Java
 * This program demonstrates the two types of typecasting in Java:
 * 1. Implicit Typecasting (Widening)
 * 2. Explicit Typecasting (Narrowing)
 */
public class Typecasting {
    public static void main(String[] args) {
        System.out.println("Java Typecasting Examples");
        System.out.println("========================");
        
        // 1. Implicit Typecasting (Widening Conversion)
        // When smaller data type is automatically converted to larger data type
        System.out.println("\n1. Implicit Typecasting (Widening):");
        
        // Conversion hierarchy: 
        // byte → short → int → long → float → double
        
        byte myByte = 100;
        short myShort = myByte;       // byte to short
        int myInt = myShort;          // short to int
        long myLong = myInt;          // int to long
        float myFloat = myLong;       // long to float
        double myDouble = myFloat;    // float to double
        
        System.out.println("byte value: " + myByte);
        System.out.println("Automatic conversion to short: " + myShort);
        System.out.println("Automatic conversion to int: " + myInt);
        System.out.println("Automatic conversion to long: " + myLong);
        System.out.println("Automatic conversion to float: " + myFloat);
        System.out.println("Automatic conversion to double: " + myDouble);
        
        // Another example with char to int
        char myChar = 'A';
        int charToInt = myChar;  // char is automatically converted to int (stores ASCII value)
        System.out.println("\nchar '" + myChar + "' to int: " + charToInt);
        
        
        // 2. Explicit Typecasting (Narrowing Conversion)
        // When larger data type is manually converted to smaller data type
        System.out.println("\n2. Explicit Typecasting (Narrowing):");
        
        double largeDouble = 123.456;
        
        // We need to explicitly cast to convert to smaller types
        float largeFloat = (float) largeDouble;    // double to float
        long largeLong = (long) largeFloat;        // float to long
        int largeInt = (int) largeLong;            // long to int
        short largeShort = (short) largeInt;       // int to short
        byte largeByte = (byte) largeShort;        // short to byte
        
        System.out.println("double value: " + largeDouble);
        System.out.println("Explicit cast to float: " + largeFloat);
        System.out.println("Explicit cast to long: " + largeLong);
        System.out.println("Explicit cast to int: " + largeInt);
        System.out.println("Explicit cast to short: " + largeShort);
        System.out.println("Explicit cast to byte: " + largeByte);
        
        // Data loss example
        int number = 130;  // Outside byte range (-128 to 127)
        byte smallByte = (byte) number;
        
        System.out.println("\nData Loss Example:");
        System.out.println("int value: " + number);
        System.out.println("After explicit cast to byte: " + smallByte);  // Will be -126
        System.out.println("(Data loss occurred because byte can only store -128 to 127)");
    }
} 